package iofiles.corporation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class CorporationService {
    private Corporation corporation;

    public CorporationService(Corporation corporation) {
        this.corporation = corporation;
    }

    public Corporation getCorporation() {
        return corporation;
    }

    public void setCorporation(Corporation corporation) {
        this.corporation = corporation;
    }

    public void addEmployee(Employee e) {
        corporation.getEmployees()
                .add(e);
    }

    public boolean removeEmployeeById(int id) {
        return corporation.getEmployees()
                .removeIf(e -> e.getId() == id);
    }

    public Employee findEmployeeById(int id) {
        return corporation.getEmployees().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findByLastName(String lastName) {
        return corporation.getEmployees()
                .stream()
                .filter(e -> e.getLastName()
                        .equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<Employee> findByAge(int age) {
        return corporation.getEmployees().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }

    public List<Employee> findByLastNameStart(char c) {
        return corporation.getEmployees().stream()
                .filter(e -> e.getLastName().toUpperCase().charAt(0) == Character.toUpperCase(c))
                .collect(Collectors.toList());
    }

    public boolean editEmployee(int id, Employee newData) {
        var e = findEmployeeById(id);
            if (e != null) {
                e.setFirstName(newData.getFirstName());
                e.setLastName(newData.getLastName());
                e.setAge(newData.getAge());
                e.setWorkExperience(newData.getWorkExperience());
                e.setPosition(newData.getPosition());
                return true;
            }
        return false;
    }

    public void saveToFile(String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(corporation);
        }
    }

    public static Corporation loadFromFile(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (Corporation) ois.readObject();
        }
    }

    public void saveReport(List<Employee> employees, String path) {
        try {
            List<String> lines = employees.stream()
                    .map(Employee::toString)
                    .toList();
            Files.write(Path.of(path), lines);
            System.out.println("Report saved to " + path);
        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public void printAllEmployees() {
        corporation.getEmployees().forEach(System.out::println);
    }

    public int generateNextId() {
        int nextId = corporation.getEmployees().size();
        return ++nextId;
    }
}
