package library.models.editions;

import library.interfaces.IFormattable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

abstract public class Publication implements IFormattable {
    private String title;
    private LocalDate yearOfPublish;

    public Publication(String title, LocalDate yearOfPublish) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getYearOfPublish() {
        return yearOfPublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Publication that) {
            return hashCode() == that.hashCode();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, yearOfPublish);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                '}';
    }

    @Override
    public String formatForUser() {
        return "\tTitle: " + title + "\n\tYear of Publish: " + yearOfPublish.format(DateTimeFormatter.ofPattern("dd MMM yyyy")) + "\n\t";
    }

    @Override
    public String formatForList(){
        return "Title: " + title + " | Year of Publish: " + yearOfPublish.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }
}
