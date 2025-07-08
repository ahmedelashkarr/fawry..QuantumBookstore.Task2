package model.books;

import exceptions.BuyDemoBookException;
import interfaces.IDemoBook;

import java.time.LocalDate;

public class DemoBook extends Book implements IDemoBook {

    public DemoBook(String ISBN, String title, LocalDate publishedYear) {
        super(ISBN, title, publishedYear);
    }

    @Override
    public double buy(String isbn, int quantity, String mail, String address) {
        throw new BuyDemoBookException("YOU CAN'T BUY DEMO BOOK !!!");
    }
}
