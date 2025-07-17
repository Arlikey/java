package oop;

import oop.book.Book;
import oop.human.*;
import oop.university.Course;
import oop.university.Group;
import oop.university.Student;
import oop.zoo.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // book();

        // friends();

        // university();

        zoo();
    }

    public static void book() {
        Book book = new Book(
                "1984",
                "George Orwell",
                LocalDate.of(1949, 6, 8),
                "Secker & Warburg",
                "Dystopian",
                328
        );

        book.consolePrint();

    }

    public static void friends() {
        Human[] friends = setFriends();

        int childs = 0;
        for (Human friend : friends) {
            friend.greet();
            childs += friend.getChildren();
            if (friend instanceof Builder builder)
                builder.build();
        }

        System.out.println("\nChilds of friends: " + childs);
    }

    public static Human[] setFriends() {
        return new Human[]{
                new Human(
                        "John Ackermann",
                        LocalDate.of(2021, 5, 17),
                        "male",
                        "+380992019704",
                        "bob@gmail.com",
                        "Odesa",
                        "Ukraine",
                        "St. Isaak 52, 1",
                        Education.NONE,
                        0),
                new Builder("Dev Johnson",
                        LocalDate.of(1997, 2, 11),
                        "male",
                        "+380952310712",
                        "dev@gmail.com",
                        "Rome",
                        "Italy",
                        "Cesar street 192, 2",
                        Education.HIGHER,
                        2,
                        "Planks and Bricks"),
                new Sailor("Alex Carlson",
                        LocalDate.of(2000, 1, 1),
                        "male",
                        "+380962938172",
                        "alex@gmail.com",
                        "New York",
                        "USA",
                        "Liberty Isle, 12, 34",
                        Education.HIGHER,
                        1,
                        "Aurora"),
                new Pilot("Samuel Bobbinson",
                        LocalDate.of(1983, 4, 25),
                        "male",
                        "+380993927893",
                        "sam@gmail.com",
                        "Kiev",
                        "Ukraine",
                        "Grushevskogo street 21, 2",
                        Education.HIGHER,
                        3,
                        "Icarus")};
    }

    public static void university() {
        Group group = getGroup();

        group.printFailingStudents();

        group.printStudentsWithoutDebts();

        group.printMostFailedCourses();

        group.printRatings();

        System.out.println();

        group.getStudents()[0].printCoursesBySemester(1);
    }

    private static Group getGroup() {
        Course[] courses1 = {
                new Course("Math", 1, new int[]{6, 0, 9}),
                new Course("Physics", 1, new int[]{9, 6, 3}),
                new Course("Programming", 1, new int[]{11, 9, 12})
        };

        Course[] courses2 = {
                new Course("Math", 1, new int[]{12, 12, 12}),
                new Course("Physics", 1, new int[]{12, 12, 12}),
                new Course("Programming", 1, new int[]{12, 12, 12})
        };

        Course[] courses3 = {
                new Course("Math", 1, new int[]{3, 3, 3}),
                new Course("Physics", 1, new int[]{8, 8, 8}),
                new Course("Programming", 1, new int[]{3, 3, 3})
        };

        Student s1 = new Student("John Smith", courses1);
        Student s2 = new Student("Jane Miller", courses2);
        Student s3 = new Student("Peter Brown", courses3);

        return new Group("P-22", 1, new Student[]{s1, s2, s3});
    }

    public static void zoo() {
        Animal[] zoo = {
                new Tiger("Simba", 30),
                new Wolf("Wolfy", 20),
                new Wolf("Wolfer", 15),
                new Rabbit("Rabbity", 2),
                new Rabbit("Rabbitiny", 3),
                new Kangaroo("Kangaroony", 5)
        };

        int predatorsCount = 0;
        int meatNeeded = 0;
        int grassNeeded = 0;

        for (Animal animal : zoo) {
            System.out.println(animal.getName() + " makes: " + animal.makeSound());

            if (animal.isPredator()) {
                predatorsCount++;
                meatNeeded += animal.getFoodAmountPerDay();
            } else {
                grassNeeded += animal.getFoodAmountPerDay();
            }
        }

        System.out.println("\nPredators count: " + predatorsCount);
        System.out.println("Meat needed per day: " + meatNeeded + "kg");
        System.out.println("Grass needed per day: " + grassNeeded + "kg");
    }
}

