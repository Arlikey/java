package collections.db.exceptions;

public class DuplicatePersonRecordException extends RuntimeException {
  public DuplicatePersonRecordException(String pin) { super("Person already exists: " + pin); }
}
