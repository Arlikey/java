package collections.db.exceptions;

public class FineNotFoundException extends RuntimeException {
    public FineNotFoundException(String fineId) { super("Fine not found: " + fineId); }
}
