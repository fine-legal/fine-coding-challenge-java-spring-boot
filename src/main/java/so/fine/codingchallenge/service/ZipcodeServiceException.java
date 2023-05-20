package so.fine.codingchallenge.service;

public class ZipcodeServiceException extends RuntimeException {

    public ZipcodeServiceException() {
        super("A problem occurred while attempting to use the court data service.");
    }
}
