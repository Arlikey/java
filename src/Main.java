import generic.Matrix;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        while (true) {
            System.out.println("\n================= MENU =================");
            System.out.println("1. Add new user");
            System.out.println("2. Delete user");
            System.out.println("3. Check if user exists");
            System.out.println("4. Change login");
            System.out.println("5. Change password");
            System.out.println("6. Print all users");
            System.out.println("0. Exit");
            System.out.print("Your choice -> ");

            int choice;
            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                scan.nextLine();
            } else {
                System.out.println("Incorrect variant. Try again!");
                scan.next();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter login: ");
                    String login = scan.nextLine();
                    System.out.print("Enter password: ");
                    String password = scan.nextLine();
                    if (UserUtil.addUser(users, login, password)) {
                        System.out.println("User added.");
                    } else {
                        System.out.println("User already exists.");
                    }
                    break;
                case 2:
                    System.out.print("Enter user's login: ");
                    String removeLogin = scan.nextLine();
                    if (UserUtil.removeUser(users, removeLogin)) {
                        System.out.println("User deleted.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter user's login: ");
                    String checkLogin = scan.nextLine();
                    if (UserUtil.userExists(users, checkLogin)) {
                        System.out.println("User exists.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter current login: ");
                    String oldLogin = scan.nextLine();
                    System.out.print("Enter new login: ");
                    String newLogin = scan.nextLine();
                    if (UserUtil.changeLogin(users, oldLogin, newLogin)) {
                        System.out.println("Login changed.");
                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                case 5:
                    System.out.print("Enter login: ");
                    String loginToChange = scan.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scan.nextLine();
                    if (UserUtil.changePassword(users, loginToChange, newPassword)) {
                        System.out.println("Password changed.");
                    } else {
                        System.out.println("User not found.");
                    }
                    break;
                case 6:
                    UserUtil.printUsers(users);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Incorrect variant. Try again!");
            }
        }
    }
}