package collections.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PersonRecord {
    private String pin;
    private String name;
    private String city;
    private final List<Fine> fines = new ArrayList<>();

    public PersonRecord(String pin, String name, String city) {
        this.pin = pin == null ? UUID.randomUUID().toString() : pin;
        this.name = name;
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addFine(Fine fine) {
        fines.add(fine);
    }

    public boolean removeFineById(String fineId) {
        return fines.removeIf(f -> f.getFineId().equals(fineId));
    }

    public Fine findFineById(String fineId) {
        for (Fine f : fines)
            if (f.getFineId().equals(fineId))
                return f;
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonRecord that)) return false;
        return Objects.equals(pin, that.pin)
                && Objects.equals(name, that.name)
                && Objects.equals(city, that.city)
                && Objects.equals(fines, that.fines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin, name, city, fines);
    }

    @Override
    public String toString() {
        return "PersonRecord{" +
                "pin='" + pin + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", fines=" + fines +
                '}';
    }
}
