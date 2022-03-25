package npm;

public class NpmPackageVersion {

    private final String license;

    public NpmPackageVersion(String license) {
        this.license = license;
    }

    public String getLicense() {
        return license;
    }
}
