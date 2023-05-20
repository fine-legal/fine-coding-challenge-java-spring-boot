package so.fine.codingchallenge.service;

public class ConvertNonexistingLeadException extends RuntimeException {

    public ConvertNonexistingLeadException(long id) {
        super(String.format("Attempting to convert a nonexisting lead ID: %d", id));
    }
}
