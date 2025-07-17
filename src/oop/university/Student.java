package oop.university;

import java.util.Arrays;
import java.util.List;

public class Student {
    private String fullName;
    private Course[] courses;

    public Student(String fullName, Course[] courses) {
        this.fullName = fullName;
        this.courses = courses;
    }

    public String getFullName() {
        return fullName;
    }

    public Course[] getCourses() {
        return courses;
    }

    public boolean hasAnyFailedCourses() {
        for (Course course : courses) {
            if (course.isFailed()) return true;
        }
        return false;
    }

    public boolean hasNoFailedCourses() {
        return !hasAnyFailedCourses();
    }

    public boolean hasDebts() {
        for (Course course : courses) {
            if (course.hasDebt()) return true;
        }
        return false;
    }

    public double getAverageGrade() {
        int cnt = 0;
        int sum = 0;
        for (Course course : courses) {
            if (course.isPassed()) {
                sum += course.getCourseGrade();
                cnt++;
            }
        }
        if (cnt == 0) return 0;
        return (double) sum / cnt;
    }

    public Course[] getCoursesBySemester(int semester) {
        int count = 0;
        for (Course course : courses) {
            if (course.getSemester() == semester) count++;
        }
        Course[] result = new Course[count];
        int j = 0;
        for (Course course : courses) {
            if (course.getSemester() == semester) {
                result[j++] = course;
            }
        }
        return result;
    }

    public void printCoursesBySemester(int semester) {
        System.out.println("Courses in semester " + semester + " for " + fullName + ":");
        Course[] arr = getCoursesBySemester(semester);
        for (Course course : arr) {
            System.out.println(" - " + course.info());
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student student)
            return this.hashCode() == obj.hashCode();
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
