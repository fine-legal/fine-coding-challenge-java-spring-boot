package so.fine.codingchallenge.service;

public class DealForNonexistingUserException extends RuntimeException {

    public DealForNonexistingUserException(int id) {
        super(String.format("Attempting to create a deal for a nonexisting user ID: %d", id));
    }
}