import model.books.Book;
import model.books.DemoBook;
import model.books.EBook;
import model.books.PaperBook;
import model.storeTest.BookItem;
import services.BookStoreService;
import java.time.LocalDate;
public class Main {

    public static void main(String[] args) {
        Book paperBook = new PaperBook("Paper123", "Monster", LocalDate.of(2022, 4, 3), 500, 2);
        Book eBook = new EBook("EBook123", "Egypt", LocalDate.of(2016, 4, 3), 300, "PDF");
        Book Demo = new DemoBook("DemoBook123", "History", LocalDate.of(2016, 4, 3));

        BookItem bookItem = new BookItem(paperBook);
        BookItem bookItem2 = new BookItem(eBook);
        BookItem bookItem3 = new BookItem(Demo);

        BookStoreService.add(bookItem);
        BookStoreService.add(bookItem2);
        BookStoreService.add(bookItem3);

        try {
            BookStoreService.buy("Paper123", 2, "Ahmedelashkar243@gmail.com", "10th Of ramadan");
            BookStoreService.buy("EBook123", 3, "Elashkar@gmail.com", "Cairo");
            //BookStoreService.removeOutdatedBooks(5);
            BookStoreService.buy("DemoBook123", 2, "cascas@gmail.com", "Doki");

        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }

    }
}