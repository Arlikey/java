package oop.university;

import java.util.Arrays;

public class Course {
    private String name;
    private int semester;
    private int[] grades;
    private int courseGrade;

    public Course(String name, int semester, int[] grades) {
        this.name = name;
        this.semester = semester;
        this.grades = grades;
        setCourseGrade();
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public int[] getGrades() {
        return grades;
    }

    public int getCourseGrade() {
        return courseGrade;
    }

    private void setCourseGrade() {
        int sum = 0;
        int count = 0;
        for (int grade : grades) {
            sum += grade;
            if (grade > 0) count++;
        }
        if (count > 0)
            this.courseGrade = sum / count;
        else
            this.courseGrade = 0;
    }

    public boolean isPassed() {
        return isPercentSatisfied() && courseGrade >= 8;
    }

    public boolean isFailed() {
        return !isPassed();
    }

    public boolean isPercentSatisfied() {
        int completed = 0;
        for (int grade : grades) {
            if (grade > 0) completed++;
        }
        return (double) completed / grades.length >= 0.8;
    }

    public boolean hasDebt() {
        for (int grade : grades) {
            if (grade == 0) return true;
        }
        return false;
    }

    public String info() {
        StringBuilder info = new StringBuilder("Course: " + name + ", semester: " + semester + ". Grades: ");
        for (int i = 0; i < grades.length; i++) {
            info.append(grades[i]);
            if (i != grades.length - 1) info.append(", ");
        }
        info.append("\nCourse grade: ").append(courseGrade);
        return info.toString();
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course course)
            return this.hashCode() == obj.hashCode();
        return false;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", semester=" + semester +
                ", grades=" + Arrays.toString(grades) +
                ", courseGrade=" + courseGrade +
                '}';
    }
}

