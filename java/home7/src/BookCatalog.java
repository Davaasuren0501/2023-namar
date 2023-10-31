import java.util.HashMap;
import java.util.Map;


public class BookCatalog {
    private Map<String, Book> nameToBookMap;
    private Map<Integer, Book> pagesToBookMap;

    public BookCatalog() {
        nameToBookMap = new HashMap<>();
        pagesToBookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        nameToBookMap.put(book.getName(), book);
        pagesToBookMap.put(book.getPages(), book);
    }

    public Book searchByName(String bookName) {
        return nameToBookMap.get(bookName);
    }

    public Book searchByPages(int numPages) {
        return pagesToBookMap.get(numPages);
    }

    public static void main(String[] args) {
        BookCatalog catalog = new BookCatalog();

        // Adding books to the catalog
        catalog.addBook(new Book("Book1", 45));
        catalog.addBook(new Book("Book2", 161));
        catalog.addBook(new Book("Book3", 44));
        catalog.addBook(new Book("Book4", 2530));

        // Searching for books
        Book bookByName = catalog.searchByName("Book2");
        Book bookByPages = catalog.searchByPages(250);

        if (bookByName != null) {
            System.out.println( "Book name = " + bookByName.getName() );
            System.out.println( "Book page = " + bookByName.getPages());
        } else {
            System.out.println("Not found name");
        }

        if (bookByPages != null) {
            System.out.println( "Book name = " + bookByPages.getName() );
            System.out.println( "Book page = " + bookByPages.getPages());
        } else {
            System.out.println("Not found  pages.");
        }
    }
}
