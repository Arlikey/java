package library.models.editions;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Book extends Publication {
    private String author;
    private HashSet<Genre> genres;
    private int pagesCount;
    private String annotation;

    public Book(String title, LocalDate yearOfPublish, String author,
                HashSet<Genre> genres, int pagesCount, String annotation) {
        super(title, yearOfPublish);
        this.author = author;
        this.genres = genres;
        this.pagesCount = pagesCount;
        this.annotation = annotation;
    }

    public String getAuthor() {
        return author;
    }

    public HashSet<Genre> getGenres() {
        return genres;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public String getAnnotation() {
        return annotation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!super.equals(o)) return false;
        if (!(o instanceof Book book)) return false;
        return pagesCount == book.pagesCount
                && Objects.equals(author, book.author)
                && Objects.equals(genres, book.genres)
                && Objects.equals(annotation, book.annotation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, genres, pagesCount, annotation);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genres=" + genres +
                ", pagesCount=" + pagesCount +
                ", annotation='" + annotation + '\'' +
                "} " + super.toString();
    }

    @Override
    public String formatForUser() {
        return "Book:\n" + super.formatForUser() + "Author: " + author + "\n\tGenres: " + genres.toString() + "\n\tPages: " + pagesCount + "\n\tAnnotation: " + annotation;
    }

    @Override
    public String formatForList() {
        return "Book:\n\t\t\t" + super.formatForList() + " | Author: " + author + " | Genres: " + genres.toString() + " | Pages: " + pagesCount + " | Annotation: " + annotation + "\n\t\t";
    }
}
