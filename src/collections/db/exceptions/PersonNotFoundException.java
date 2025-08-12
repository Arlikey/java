package collections.db.exceptions;

public class PersonNotFoundException extends RuntimeException {
  public PersonNotFoundException(String pin) { super("Person not found: " + pin); }
}