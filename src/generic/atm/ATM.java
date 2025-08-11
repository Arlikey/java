package generic.atm;

import generic.atm.exceptions.ATMException;
import generic.atm.exceptions.InsufficientFundsException;
import generic.atm.exceptions.InvalidAmountException;
import generic.atm.exceptions.MaxNotesExceededException;

import java.util.*;

public class ATM {
    private final List<Integer> banknotes = new ArrayList<>();
    private final int minWithdrawal;
    private final int maxNotes;

    private final int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};

    public ATM(int minWithdrawal, int maxNotes) {
        this.minWithdrawal = minWithdrawal;
        this.maxNotes = maxNotes;
    }

    public void loadCash(List<Integer> bills) {
        banknotes.addAll(bills);
    }

    public void depositCash(List<Integer> bills) {
        loadCash(bills);
    }

    public int getTotalAmount() {
        int total = 0;
        for (int note : banknotes) {
            total += note;
        }
        return total;
    }

    public List<Integer> withdraw(int amount) throws ATMException {
        if (amount < minWithdrawal) {
            throw new InvalidAmountException("Amount less than minimum allowed: " + minWithdrawal);
        }
        if (amount > getTotalAmount()) {
            throw new InsufficientFundsException("Not enough funds in ATM");
        }

        int[] availableCounts = new int[denominations.length];
        for (int i = 0; i < denominations.length; i++) {
            int denom = denominations[i];
            int count = 0;
            for (int note : banknotes) {
                if (note == denom) count++;
            }
            availableCounts[i] = count;
        }

        int remaining = amount;
        int totalNotes = 0;
        int[] toDispenseCounts = new int[denominations.length];

        for (int i = 0; i < denominations.length; i++) {
            int denom = denominations[i];
            int canUse = Math.min(remaining / denom, availableCounts[i]);
            if (canUse > 0) {
                toDispenseCounts[i] = canUse;
                remaining -= canUse * denom;
                totalNotes += canUse;
            }
        }

        if (remaining > 0) {
            throw new InvalidAmountException("Cannot dispense exact amount with available banknotes");
        }
        if (totalNotes > maxNotes) {
            throw new MaxNotesExceededException("Exceeded max notes limit: " + maxNotes);
        }

        List<Integer> dispensed = new ArrayList<>();
        for (int i = 0; i < denominations.length; i++) {
            int denom = denominations[i];
            int countToRemove = toDispenseCounts[i];
            for (int j = 0; j < countToRemove; j++) {
                banknotes.remove((Integer) denom);
                dispensed.add(denom);
            }
        }

        return dispensed;
    }
}
