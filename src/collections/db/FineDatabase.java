package collections.db;

import collections.db.exceptions.DuplicatePersonRecordException;
import collections.db.exceptions.FineNotFoundException;
import collections.db.exceptions.PersonNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class FineDatabase {
    private final Map<String, PersonRecord> db = new HashMap<>();

    public void addPerson(PersonRecord person) {
        if (db.containsKey(person.getPin())) throw new DuplicatePersonRecordException(person.getPin());
        db.put(person.getPin(), person);
    }

    public void addFineToPerson(String pid, Fine fine) {
        PersonRecord p = db.get(pid);
        if (p == null) throw new PersonNotFoundException(pid);
        p.addFine(fine);
    }

    public void printAll() {
        if (db.isEmpty()) {
            System.out.println("Database is empty.");
            return;
        }
        System.out.println("=== Full database print ===");
        for (PersonRecord p : db.values()) {
            System.out.println(p);
        }
    }

    public void printByPin(String pin) {
        PersonRecord p = db.get(pin);
        if (p == null) {
            System.out.println("No person with PIN " + pin);
            return;
        }
        System.out.println("=== Data for PIN " + pin + " ===");
        System.out.println(p);
    }

    public void printByFineType(FineType type) {
        System.out.println("=== Records with fine type: " + type + " ===");
        boolean found = false;
        for (PersonRecord p : db.values()) {
            for (Fine f : p.getFines()) {
                if (f.getType() == type) {
                    System.out.println("PIN=" + p.getPin() + ", Name: " + p.getName() + "\n\t" + f);
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No fines of type " + type);
    }

    public void printByCity(String city) {
        System.out.println("=== Records in city: " + city + " ===");
        boolean found = false;
        for (PersonRecord p : db.values()) {
            if (city.equalsIgnoreCase(p.getCity())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) System.out.println("No records in city " + city);
    }

    public void removeFine(String pid, String fineId) {
        PersonRecord p = db.get(pid);
        if (p == null) throw new PersonNotFoundException(pid);
        boolean removed = p.removeFineById(fineId);
        if (!removed) throw new FineNotFoundException(fineId);
    }

    public void replacePerson(String pid, PersonRecord newRecord) {
        if (!pid.equals(newRecord.getPin())) {
            throw new IllegalArgumentException("PID mismatch when replacing person");
        }
        if (!db.containsKey(pid)) throw new PersonNotFoundException(pid);
        db.put(pid, newRecord);
    }
}
