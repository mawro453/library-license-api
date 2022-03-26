package io.github.mwrod453.mvn;

import pl.droidsonroids.jspoon.annotation.Selector;

/**
 * Wrapper for holding the license of a maven artifact version.
 */
public class MvnArtifactVersion {

    @Selector("#maincontent > table > tbody .lic")
    private String license;

    /**
     * @return License (e.g. MIT)
     */
    public String getLicense() {
        return license;
    }
}
