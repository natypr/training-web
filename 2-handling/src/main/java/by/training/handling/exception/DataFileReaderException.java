package by.training.handling.exception;

public class DataFileReaderException extends Exception{

    public DataFileReaderException() {
    }

    public DataFileReaderException(String message) {
        super(message);
    }

    public DataFileReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataFileReaderException(Throwable cause) {
        super(cause);
    }

}
