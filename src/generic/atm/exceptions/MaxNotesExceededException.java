package generic.atm.exceptions;

public class MaxNotesExceededException extends ATMException {
    public MaxNotesExceededException(String message) {
        super(message);
    }
}