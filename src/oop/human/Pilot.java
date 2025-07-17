package oop.human;

import java.time.LocalDate;

public class Pilot extends Human {
    private String airline;

    public Pilot() {
    }

    public Pilot(String fullName, LocalDate birthdate, String gender, String phoneNumber,
                 String email, String city, String country, String homeAddress, Education education, int children, String airline) {
        super(fullName, birthdate, gender, phoneNumber, email, city, country, homeAddress, education, children);
        this.airline = airline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public void greet() {
        System.out.println("Hi, I'm Pilot. My name is " + this.fullName);
    }

    public void fly() {
        System.out.println("I'm flying...");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pilot pilot)
            return this.hashCode() == pilot.hashCode();
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "Pilot{" +
                super.toString() +
                ", airline='" + airline + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}