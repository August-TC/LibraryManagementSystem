package RelatedObjects;

import java.util.ArrayList;
import java.util.List;

public class BookList {
    private ArrayList<Book> books;
    
    public BookList(){
    	this.books = new ArrayList<Book>();
    }
    
    public ArrayList<Book> getBooks()
    {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book)
    {
        books.remove(book);
    }
}
