package model.books;

import interfaces.IEBook;
import model.storeTest.BookItem;
import services.BookStoreService;
import services.MailService;

import java.time.LocalDate;

public class EBook extends Book implements IEBook {
    private double price;
    String fileType;

    public EBook(String ISBN, String title, LocalDate publishedYear, double price , String fileType) {
        super(ISBN, title, publishedYear);
        setPrice(price);
        this.fileType = fileType;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        if (price < 0)
            throw new RuntimeException("PRICE CAN'T BE LESS THAN ZERO !!!");
        this.price = price;
    }

    @Override
    public double buy(String isbn, int quantity, String mail, String address) {
        BookItem bookItem = BookStoreService.getInventory().get(isbn);
        if (!(bookItem.getBook() instanceof IEBook iEBook))
            throw new RuntimeException("You can only purchase onlineBooks of type IEBook NOT %s !!!".formatted(bookItem.getBook().getTitle()));
        MailService.sendMail(iEBook, mail);
        System.out.println("-----------------");
        System.out.printf("We'll Send You This Books by type {%s} TO MAIL :%s\n" , fileType, mail);
        return iEBook.getPrice() * quantity;
    }
}
