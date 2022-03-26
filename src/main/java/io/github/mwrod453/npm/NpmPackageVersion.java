package io.github.mwrod453.npm;

/**
 * Wrapper for holding the license of a npm package version.
 */
public class NpmPackageVersion {

    private final String license;

    NpmPackageVersion(String license) {
        this.license = license;
    }

    /**
     * @return License (e.g. MIT)
     */
    public String getLicense() {
        return license;
    }
}
