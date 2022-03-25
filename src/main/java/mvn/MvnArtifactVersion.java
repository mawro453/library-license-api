package mvn;

import pl.droidsonroids.jspoon.annotation.Selector;

public class MvnArtifactVersion {

    @Selector("#maincontent > table > tbody .lic")
    private String license;

    public String getLicense() {
        return license;
    }
}
