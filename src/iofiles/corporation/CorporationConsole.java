package iofiles.corporation;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CorporationConsole {
    private final String corporationDirectory = "src/iofiles/corporation/files/";
    private final String corporationReports = "src/iofiles/corporation/files/reports/";
    private final String corporationFileName = "corporation.txt";
    private final CorporationService service;
    private final Scanner scan = new Scanner(System.in);

    public CorporationConsole(CorporationService service) {
        this.service = service;
    }

    public void start() {
        loadFromFile();
        while (true) {
            System.out.println("\n=== Corporation Menu ===");
            System.out.println("1. Set corporation name");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Remove employee");
            System.out.println("5. Find employee by last name");
            System.out.println("6. Show all employees");
            System.out.println("7. Show employees by age or starting letter");
            System.out.println("8. Save to file");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            String choice = scan.nextLine().trim();

            switch (choice) {
                case "1" -> setCorporationTitle();
                case "2" -> addEmployee();
                case "3" -> editEmployee();
                case "4" -> removeEmployee();
                case "5" -> findEmployee();
                case "6" -> service.printAllEmployees();
                case "7" -> showByAgeOrLetter();
                case "8" -> saveToFile();
                case "9" -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void setCorporationTitle() {
        System.out.print("Enter title of corporation: ");
        String title = scan.nextLine().trim();
        service.getCorporation().setTitle(title);
        System.out.println("Corporation title changed.");
    }

    private void addEmployee() {
        Employee emp = promptEmployee();
        service.addEmployee(emp);
        System.out.println("Employee added.");
    }

    private void editEmployee() {
        System.out.print("Enter id of employee to edit: ");
        String id = scan.nextLine().trim();
        if (service.findEmployeeById(Integer.parseInt(id)) != null) {
            Employee updated = promptEmployee();
            boolean edited = service.editEmployee(Integer.parseInt(id), updated);
            System.out.println("Employee updated");
        }
        System.out.println("Employee not found.");
    }

    private void removeEmployee() {
        System.out.print("Enter id of employee to remove: ");
        String id = scan.nextLine().trim();
        boolean removed = service.removeEmployeeById(Integer.parseInt(id));
        System.out.println(removed ? "Employee removed." : "Employee not found.");
    }

    private void findEmployee() {
        System.out.print("Enter last name to search: ");
        String lastName = scan.nextLine().trim();
        List<Employee> found = service.findByLastName(lastName);
        if (found.isEmpty()) System.out.println("No employees found.");
        else {
            found.forEach(System.out::println);
            System.out.print("Save this search to report? (y/n): ");
            String save = scan.nextLine().trim();
            if (save.equalsIgnoreCase("y")) {
                String reportName = corporationReports + lastName + "_report.txt";
                service.saveReport(found, reportName);
            }
        }
    }

    private void showByAgeOrLetter() {
        System.out.print("Filter by (1) Age or (2) First letter of last name? ");
        String option = scan.nextLine().trim();
        if (option.equals("1")) {
            System.out.print("Enter age: ");
            int age = Integer.parseInt(scan.nextLine().trim());
            service.findByAge(age).forEach(System.out::println);
        } else if (option.equals("2")) {
            System.out.print("Enter first letter: ");
            char ch = scan.nextLine().trim().charAt(0);
            service.findByLastNameStart(ch).forEach(System.out::println);
        } else {
            System.out.println("Invalid option.");
        }
    }

    private void saveToFile() {
        try {
            service.saveToFile(corporationDirectory + corporationFileName);
            System.out.println("Saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        try {
            Corporation corp = CorporationService.loadFromFile(corporationDirectory + corporationFileName);
            service.setCorporation(corp);
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    private Employee promptEmployee() {
        System.out.print("First name: ");
        String firstName = scan.nextLine().trim();
        System.out.print("Last name: ");
        String lastName = scan.nextLine().trim();
        System.out.print("Age: ");
        int age = Integer.parseInt(scan.nextLine().trim());
        System.out.print("Work experience: ");
        int exp = Integer.parseInt(scan.nextLine().trim());
        System.out.print("Position (Manager, Specialist, Engineer, Analyst, Director, Officer): ");
        Position pos = Position.valueOf(scan.nextLine().trim());
        int id = service.generateNextId();
        return new Employee(id, firstName, lastName, age, exp, pos);
    }
}
