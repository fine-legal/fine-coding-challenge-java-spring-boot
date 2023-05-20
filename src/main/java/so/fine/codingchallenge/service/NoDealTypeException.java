package so.fine.codingchallenge.service;

public class NoDealTypeException extends RuntimeException {
    public NoDealTypeException() {
        super("Attempting to create a Deal without specifying a type");
    }
}
