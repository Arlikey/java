package oop.university;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private String name;
    private int course;
    private Student[] students;

    public Group(String name, int course, Student[] students) {
        this.name = name;
        this.course = course;
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public Student[] getFailingStudents() {
        int count = 0;
        for (Student value : students) {
            if (value.hasAnyFailedCourses()) count++;
        }
        Student[] res = new Student[count];
        int i = 0;
        for (Student student : students) {
            if (student.hasAnyFailedCourses()) res[i++] = student;
        }
        return res;
    }

    public Student[] getSuccessfulStudents() {
        int count = 0;
        for (Student student : students) {
            if (student.hasNoFailedCourses()) count++;
        }
        Student[] result = new Student[count];
        int i = 0;
        for (Student student : students) {
            if (student.hasNoFailedCourses()) result[i++] = student;
        }
        return result;
    }

    public Student[] getStudentsWithoutDebts(){
        int count = 0;
        for (Student student : students) {
            if (!student.hasDebts()) count++;
        }
        Student[] result = new Student[count];
        int i = 0;
        for (Student student : students) {
            if (!student.hasDebts()) result[i++] = student;
        }
        return result;
    }

    public void printRatings() {
        System.out.println("\nStudent Ratings:");
        for (Student student : students) {
            System.out.println(" - " + student.getFullName() + ": " + student.getAverageGrade());
        }
    }

    public void printMostFailedCourses() {
        String[] allNames = new String[students.length * 10];
        int totalNames = 0;
        for (Student student : students) {
            Course[] courses = student.getCourses();
            for (Course course : courses) {
                boolean alreadyIn = false;
                for (int i = 0; i < totalNames; i++) {
                    if (allNames[i].equals(course.getName())) {
                        alreadyIn = true;
                        break;
                    }
                }
                if (!alreadyIn) {
                    allNames[totalNames++] = course.getName();
                }
            }
        }
        int[] failCounts = new int[totalNames];
        for (Student student : students) {
            Course[] courses = student.getCourses();
            for (Course course : courses) {
                if (course.isFailed()) {
                    for (int i = 0; i < totalNames; i++) {
                        if (allNames[i].equals(course.getName())) {
                            failCounts[i]++;
                        }
                    }
                }
            }
        }
        int maxFails = 0;
        for (int i = 0; i < totalNames; i++) {
            if (failCounts[i] > maxFails) maxFails = failCounts[i];
        }
        System.out.println("\nMost failed courses:");
        for (int i = 0; i < totalNames; i++) {
            if (failCounts[i] == maxFails && maxFails > 0) {
                System.out.println(" - " + allNames[i] + ": " + failCounts[i] + " fails");
            }
        }
    }

    public void printFailingStudents() {
        System.out.println("\nFailing Students:");
        Student[] array = getFailingStudents();
        for (Student student : array) {
            System.out.println(" - " + student.getFullName());
        }
    }

    public void printSuccessfulStudents() {
        System.out.println("\nSuccessful Students:");
        Student[] array = getSuccessfulStudents();
        for (Student student : array) {
            System.out.println(" - " + student.getFullName());
        }
    }

    public void printStudentsWithoutDebts() {
        System.out.println("\nStudents without debts:");
        Student[] array = getStudentsWithoutDebts();
        for (Student student : array) {
            System.out.println(" - " + student.getFullName());
        }
    }


    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Group group)
            return this.hashCode() == obj.hashCode();
        return false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", course=" + course +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
