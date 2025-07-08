package model.books;

import exceptions.QuantityIsValidException;
import interfaces.IPaperBook;
import model.storeTest.BookItem;
import services.BookStoreService;
import services.ShippingService;

import java.time.LocalDate;

public class PaperBook extends Book implements IPaperBook {
    int quantityInStock;
    private double price;

    public PaperBook(String ISBN, String title, LocalDate publishedYear, double price , int quantityInStock) {
        super(ISBN, title, publishedYear);
        setPrice(price);
        setQuantityInStock(quantityInStock);
    }
    public PaperBook(String ISBN, String title, LocalDate publishedYear, double price ) {
        super(ISBN, title, publishedYear);
        setPrice(price);
    }

    @Override
    public int getQuantityInStock() {
        return quantityInStock;
    }

    @Override
    public void setQuantityInStock(int quantity) {
        QuantityIsValidException.quantityIsValid(quantity);
        quantityInStock = quantity;
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
        if (!(bookItem.getBook() instanceof IPaperBook iPaperBook))
            throw new RuntimeException("WE CAN SHIPPING PHYSICAL BOOKS ONLY NOT %s !!!".formatted(bookItem.getBook().getTitle()));
        ShippingService.shipping(iPaperBook, address);
        BookStoreService.reduceBookQuantity(bookItem, quantity);
        System.out.println("-----------------");
        System.out.printf("We'll Send You This Books TO ADDRESS :%s\n" , address);
        return iPaperBook.getPrice() * quantity;
    }
}
