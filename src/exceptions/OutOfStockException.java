package exceptions;

import model.books.Book;
import services.BookStoreService;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }

    public static void isTheBookAvailableInTheStock(Book book ) {
        NullBookException.BookIsNull(book);
        if (!BookStoreService.isTheBookAvailableInTheStock(book))
            throw new OutOfStockException("%s IS OUT OF STOCK !!!".formatted(book.getTitle()));
    }
    public static void IsBookOutOfStock(Book book , int quantity){
        isTheBookAvailableInTheStock(book);
        if(BookStoreService.IsBookOutOfStock(book , quantity))
            throw new OutOfStockException("%s THE QUANTITY IN THE STOCK NOT ENOUGH !!!".formatted(book.getTitle()));
    }
}
