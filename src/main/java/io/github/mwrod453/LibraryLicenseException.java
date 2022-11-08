package io.github.mwrod453;

/**
 * Thrown when the license of a library can't be retrieved.
 */
public class LibraryLicenseException extends Exception {

    LibraryLicenseException(String message) {
        super(message);
    }
}
