import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LibraryLicenseApiTest {

    private LibraryLicenseApi libraryLicenseApi;

    @BeforeEach
    void beforeEach() {
        this.libraryLicenseApi = LibraryLicenseApi.create();
    }

    @Nested
    class NpmTests {

        @Test
        void givenExistingPackageVersion_shouldReturnLicense() throws LibraryLicenseException {
            String license = libraryLicenseApi.getNpmLicense("npm", "8.5.5");
            assertThat(license).isEqualTo("Artistic-2.0");
        }

        @Test
        void givenNotExistingPackageVersion_shouldReturnLicense() {
            assertThatThrownBy(() -> libraryLicenseApi.getNpmLicense("npm", "0.1"))
                    .isInstanceOf(LibraryLicenseException.class)
                    .hasMessage("npm:0.1 does not exist.");
        }
    }

    @Nested
    class MvnTests {

        @Test
        void givenExistingArtifactVersion_shouldReturnLicense() throws LibraryLicenseException {
            String license = libraryLicenseApi.getMvnLicense("org.apache.maven", "maven-artifact", "3.8.5");
            assertThat(license).isEqualTo("Apache 2.0");
        }

        @Test
        void givenNotExistingPackage_shouldReturnLicense() {
            assertThatThrownBy(() -> libraryLicenseApi.getMvnLicense("org.apache.maven", "maven-artifact", "0.1"))
                    .isInstanceOf(LibraryLicenseException.class)
                    .hasMessage("org.apache.maven:maven-artifact:0.1 does not exist.");
        }
    }
}