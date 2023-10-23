package io.github.mwrod453;

import io.github.mwrod453.mvn.MvnArtifactVersion;
import io.github.mwrod453.mvn.MvnRepositoryApi;
import io.github.mwrod453.mvn.MvnRepositoryApiFactory;
import io.github.mwrod453.npm.NpmLicenseApi;
import io.github.mwrod453.npm.NpmLicenseApiFactory;
import io.github.mwrod453.npm.NpmPackageVersion;
import retrofit2.Response;

import java.io.IOException;

/**
 * This API can be used to retrieve the license of a library version.
 */
public class LibraryLicenseApi {

    private final NpmLicenseApi npmLicenseApi;
    private final MvnRepositoryApi mvnRepositoryApi;

    private LibraryLicenseApi() {
        this.npmLicenseApi = NpmLicenseApiFactory.create();
        this.mvnRepositoryApi = MvnRepositoryApiFactory.create();
    }

    /**
     * @return Instance of {@link LibraryLicenseApi}
     */
    public static LibraryLicenseApi create() {
        return new LibraryLicenseApi();
    }

    /**
     * <p>Returns the license of the given npm package version.</p>
     *
     * <p>The license will be retrieved from <a href="https://www.npmjs.com/">npmjs.com</a></p>
     *
     * @param packageName    Name of the package
     * @param packageVersion Version of the package
     * @return License (e.g. 'MIT')
     * @throws LibraryLicenseException If the artifact version does not exist or if there is no internet connection
     */
    public String getNpmLicense(String packageName, String packageVersion) throws LibraryLicenseException {
        Response<NpmPackageVersion> packageVersionCall;
        try {
            packageVersionCall = this.npmLicenseApi
                    .getLicense(packageName, packageVersion)
                    .execute();
        } catch (IOException e) {
            throw new LibraryLicenseException(e.getMessage());
        }

        if (packageVersionCall.isSuccessful() && packageVersionCall.body() != null) {
            return packageVersionCall.body().getLicense();
        }

        int code = packageVersionCall.code();
        if (code == 404 || code == 405) {
            throw new LibraryLicenseException(
                    packageName + ":" + packageVersion + " does not exist (Code: " + code + ").");
        }

        throw new LibraryLicenseException(packageVersionCall.message() + "(Code: " + code + ")");
    }

    /**
     * <p>Returns the license of the given maven artifact version.</p>
     *
     * <p>The license will be retrieved from <a href="https://mvnrepository.com/">mvnrepository.com</a></p>
     *
     * @param groupId    Id of the artifact's group
     * @param artifactId Id of the artifact (project)
     * @param version    Version of the artifact
     * @return License (e.g. 'MIT')
     * @throws LibraryLicenseException If the artifact version does not exist or if there is no internet connection
     */
    public String getMvnLicense(String groupId, String artifactId, String version) throws LibraryLicenseException {
        Response<MvnArtifactVersion> artifactVersionCall;
        try {
            artifactVersionCall = this.mvnRepositoryApi
                    .getLicense(groupId, artifactId, version)
                    .execute();
        } catch (IOException e) {
            throw new LibraryLicenseException(e.getMessage());
        }

        if (artifactVersionCall.isSuccessful() && artifactVersionCall.body() != null) {
            return artifactVersionCall.body().getLicense();
        }

        int code = artifactVersionCall.code();
        if (code == 404) {
            throw new LibraryLicenseException(
                    groupId + ":" + artifactId + ":" + version + " does not exist (Code: " + code + ").");
        }

        throw new LibraryLicenseException(artifactVersionCall.message() + "(Code: " + code + ")");
    }
}
