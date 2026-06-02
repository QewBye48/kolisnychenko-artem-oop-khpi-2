package ua.khpi.oop.lab08.exception;

public class InvalidWorkspaceDataException extends Exception {

    public InvalidWorkspaceDataException(String message) {
        super(message);
    }

    public InvalidWorkspaceDataException(String message, Throwable cause) {
        super(message, cause);
    }
}