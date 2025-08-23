package library.models.editions;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

public class Newspaper extends Publication {
    private int issue;
    private HashSet<String> headers;

    public Newspaper(String title, LocalDate yearOfPublish, int issue, HashSet<String> headers) {
        super(title, yearOfPublish);
        this.issue = issue;
        this.headers = headers;
    }

    public int getIssue() {
        return issue;
    }

    public HashSet<String> getHeaders() {
        return headers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Newspaper newspaper)) return false;
        if (!super.equals(o)) return false;
        return issue == newspaper.issue && Objects.equals(headers, newspaper.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), issue, headers);
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "issue=" + issue +
                ", headers=" + headers +
                "} " + super.toString();
    }

    @Override
    public String formatForUser() {
        return "Newspaper:\n" + super.formatForUser() + "Issue: " + issue + "\n\tHeaders:\n\t\t" + headers.toString();
    }

    @Override
    public String formatForList() {
        return "Newspaper:" + super.formatForList() + " | Issue: " + issue + " | Headers: " + headers.toString();
    }
}
