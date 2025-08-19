package iofiles.corporation;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int workExperience;
    private Position position;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, int age, int workExperience, Position position) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workExperience = workExperience;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18) this.age = age;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Employee employee)
            return this.hashCode() == o.hashCode();
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, workExperience, position);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", workExperience=" + workExperience +
                ", position=" + position +
                '}';
    }
}
