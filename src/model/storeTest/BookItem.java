package model.storeTest;

import exceptions.NullBookException;
import exceptions.QuantityIsValidException;
import model.books.Book;

public class BookItem {
    private Book book ;
    private int quantity;

    public BookItem(Book book) {
        NullBookException.BookIsNull(book);
        setBook(book);
    }
    public BookItem(Book book , int quantity) {
        NullBookException.BookIsNull(book);
        setBook(book);
        setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        QuantityIsValidException.quantityIsValid(quantity);
        this.quantity = quantity;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        NullBookException.BookIsNull(book);
        this.book = book;
    }
}
