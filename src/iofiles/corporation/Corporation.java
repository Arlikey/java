package iofiles.corporation;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

public class Corporation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String title;
    private HashSet<Employee> employees = new HashSet<>();

    public Corporation() {
    }

    public Corporation(String title, HashSet<Employee> employees) {
        this.title = title;
        this.employees = employees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(HashSet<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Corporation that)
            return this.hashCode() == o.hashCode();
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, employees);
    }

    @Override
    public String toString() {
        return "Corporation{" +
                "title='" + title + '\'' +
                ", employees=" + employees +
                '}';
    }
}
