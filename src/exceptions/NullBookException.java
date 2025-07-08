package exceptions;

import model.books.Book;

public class NullBookException extends RuntimeException {
    public NullBookException(String message) {
        super(message);
    }
    public static void BookIsNull(Book book){
        if(book == null){
            throw new NullBookException("YOU CAN'T ADD NULL BOOK !!!");
        }
    }
}
