package library.models.catalogue;

import library.models.editions.Publication;

import java.util.HashSet;

public class Library {
    private HashSet<Publication> publications = new HashSet<>();

    public Library() {
    }

    public Library(HashSet<Publication> publications) {
        this.publications = publications;
    }

    public HashSet<Publication> getPublications() {
        return publications;
    }

    public void setPublications(HashSet<Publication> publications) {
        this.publications = publications;
    }
}
