package library.models.editions;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Almanac extends Publication {
    private String annotation;
    private HashSet<Book> books;

    public Almanac(String title, LocalDate yearOfPublish, String annotation, HashSet<Book> books) {
        super(title, yearOfPublish);
        this.annotation = annotation;
        this.books = books;
    }

    public String getAnnotation() {
        return annotation;
    }

    public HashSet<Book> getBooks() {
        return books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Almanac almanac)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(annotation, almanac.annotation)
                && Objects.equals(books, almanac.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), annotation, books);
    }

    @Override
    public String toString() {
        return "Almanac{" +
                "annotation='" + annotation + '\'' +
                ", books=" + books +
                "} " + super.toString();
    }

    @Override
    public String formatForUser() {
        StringBuilder s = new StringBuilder("Almanac:\n" + super.formatForUser() + "Annotation: " + annotation + "\n\tBooks:\n\t\t");
        for (var book : books)
            s.append(book.formatForList());
        return s.toString();
    }

    @Override
    public String formatForList() {
        return "";
    }
}
