package oop.book;

import java.time.LocalDate;
import java.time.Period;

public class Book {
    private String title;
    private String author;
    private LocalDate yearOfPublish;
    private String publisherTitle;
    private String genre;
    private int pagesCount;

    public Book() {
    }

    public Book(String title, String author, LocalDate yearOfPublish, String publisherTitle, String genre, int pagesCount) {
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.publisherTitle = publisherTitle;
        this.genre = genre;
        this.pagesCount = pagesCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(LocalDate yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public String getPublisherTitle() {
        return publisherTitle;
    }

    public void setPublisherTitle(String publisherTitle) {
        this.publisherTitle = publisherTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPagesCount() {
        return pagesCount;
    }

    public void setPagesCount(int pagesCount) {
        if (pagesCount > 0)
            this.pagesCount = pagesCount;
    }

    public void consolePrint() {
        System.out.println("Book:" +
                "\n\tTitle: " + title +
                "\n\tAuthor: " + author +
                "\n\tGenre: " + genre +
                "\n\tPages: " + pagesCount +
                "\n\tPublish Date: " + yearOfPublish +
                "\n\tPublisher: " + publisherTitle);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book book)
            return this.hashCode() == book.hashCode();
        return false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", publisherTitle='" + publisherTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", pagesCount=" + pagesCount +
                '}';
    }
}
