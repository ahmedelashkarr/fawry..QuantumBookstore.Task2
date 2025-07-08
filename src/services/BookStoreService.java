package services;

import exceptions.NullBookException;
import exceptions.OutOfStockException;
import interfaces.IPaperBook;
import model.books.Book;
import model.storeTest.BookItem;

import java.time.LocalDate;
import java.util.*;

public class BookStoreService {
    private final static Map<String, BookItem> inventory = new HashMap<>();

    public static Map<String, BookItem> getInventory() {
        return inventory;
    }

    public static void add(BookItem bookItem) {
        if (bookItem.getBook() instanceof IPaperBook)
            bookItem.setQuantity(((IPaperBook) bookItem.getBook()).getQuantityInStock());
        inventory.putIfAbsent(bookItem.getBook().getISBN(), bookItem);
    }

    public static List<Book> removeOutdatedBooks(int numberOfYearsToRemove) {
        if (numberOfYearsToRemove < 0) throw new RuntimeException("NUMBER OF YEAR MUST BE MORE THAN 0 !!!");
        List<Book> removed = new ArrayList<>();
        var list = inventory.values().stream().toList();
        System.out.println("-----------------");
        for (BookItem bookItem : list) {
            Book book = bookItem.getBook();
            if (LocalDate.now().getYear() - book.getPublishedYear().getYear()
                    >= numberOfYearsToRemove) {
                removed.add(book);
                inventory.remove(book.getISBN());
                System.out.printf("** %s Has Been Removed **\n", book.getTitle());
            }
        }
        return removed;
    }

    public static void buy(String isbn, int quantity, String mail, String address) {
        BookItem bookItem = inventory.get(isbn);
        NullBookException.BookIsNull(bookItem.getBook());
        double price = bookItem.getBook().buy(isbn, quantity, mail, address);
        printReceipt(bookItem.getBook().getTitle(), quantity, price);
    }

    public static void reduceBookQuantity(BookItem item, int quantity) {
        OutOfStockException.IsBookOutOfStock(item.getBook(), quantity);
        BookItem existingItem = inventory.get(item.getBook().getISBN());
        existingItem.setQuantity(existingItem.getQuantity() - quantity);
    }

    public static void printReceipt(String bookTitle, int quantity, double price) {
        System.out.printf("%dx %s\t\t :%.1f\n",
                quantity,
                bookTitle,
                (price / quantity));
        System.out.println("Total\t\t :" + price);

    }

    public static boolean IsBookOutOfStock(Book book, int quantity) {
        isTheBookAvailableInTheStock(book);
        return inventory.get(book.getISBN()).getQuantity() < quantity;
    }

    public static boolean isTheBookAvailableInTheStock(Book book) {
        return inventory.get(book.getISBN()) != null;
    }
}
