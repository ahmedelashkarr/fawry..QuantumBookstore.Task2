package model.books;

import java.time.LocalDate;

public abstract class Book {
    private String ISBN;
    private String title;
    private LocalDate publishedYear;

    public Book(String ISBN, String title, LocalDate publishedYear) {
        this.ISBN = ISBN;
        this.title = title;
        this.publishedYear = publishedYear;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(LocalDate publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public abstract double buy(String isbn , int quantity , String mail , String address);
}
