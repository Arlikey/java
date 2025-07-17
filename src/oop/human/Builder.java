package oop.human;

import java.time.LocalDate;

public class Builder extends Human {
    private String company;

    public Builder() {
    }

    public Builder(String fullName, LocalDate birthdate, String gender, String phoneNumber,
                   String email, String city, String country, String homeAddress, Education education, int children, String company) {
        super(fullName, birthdate, gender, phoneNumber, email, city, country, homeAddress, education, children);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public void greet(){
        System.out.println("Hi, I'm Builder. My name is " + this.fullName);
    }

    public void build(){
        System.out.println("I'm building...");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Builder builder)
            return this.hashCode() == builder.hashCode();
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "Builder{" +
                super.toString() +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}