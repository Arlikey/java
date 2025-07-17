package oop.human;

import java.time.LocalDate;

public class Sailor extends Human {
    private String shipName;

    public Sailor() {
    }

    public Sailor(String fullName, LocalDate birthdate, String gender, String phoneNumber,
                  String email, String city, String country, String homeAddress, Education education, int children, String shipName) {
        super(fullName, birthdate, gender, phoneNumber, email, city, country, homeAddress, education, children);
        this.shipName = shipName;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    @Override
    public void greet() {
        System.out.println("Hi, I'm Sailor. My name is " + this.fullName);
    }

    public void sail() {
        System.out.println("I'm sailing...");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Sailor sailor)
            return this.hashCode() == sailor.hashCode();
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "Sailor{" +
                super.toString() +
                ", shipName='" + shipName + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}