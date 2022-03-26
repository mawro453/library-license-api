package io.github.mwrod453.npm;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * API for accessing <a href="https://www.npmjs.com/">npmjs.com</a>.
 */
public interface NpmLicenseApi {

    @GET("/{name}/{version}")
    Call<NpmPackageVersion> getLicense(@Path("name") String packageName, @Path("version") String packageVersion);
}
