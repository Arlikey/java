package oop.human;

import oop.book.Book;

import java.time.LocalDate;
import java.time.Period;

public class Human {
    protected String fullName;
    protected LocalDate birthdate;
    protected int age;
    protected String gender;
    protected String phoneNumber;
    protected String email;
    protected String city;
    protected String country;
    protected String homeAddress;
    protected Education education;
    protected int children;

    private static int count;

    public Human() {
        count++;
    }

    public Human(String fullName, LocalDate birthdate, String gender, String phoneNumber,
                 String email, String city, String country, String homeAddress, Education education, int children) {
        this.fullName = fullName;
        this.birthdate = birthdate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.country = country;
        this.homeAddress = homeAddress;
        this.education = education;
        this.children = children;
        this.age = getAgeByBirthdate();
        count++;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        this.age = getAgeByBirthdate();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        if (children >= 0)
            this.children = children;
    }

    public int getAge() {
        return age;
    }

    public void greet() {
        System.out.println("Hi, I'm Human. My name is " + this.fullName);
    }

    private int getAgeByBirthdate() {
        if (birthdate == null) return -1;
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Human human)
            return this.hashCode() == human.hashCode();
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "Human{" +
                "fullName='" + fullName + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", education='" + education + '\'' +
                ", children=" + children +
                '}';
    }

    public static int getPeopleCount() {
        return count;
    }

    @Override
    protected void finalize() throws Throwable {
        count--;
    }
}
