import java.util.*;

public class Genre implements java.io.Serializable {
  private String genre;
  private ArrayList<Book> catalog = new ArrayList<Book>();
  // arraylist that stores the books under the genre

  public Genre(String g) {
    // constructor
    genre = g;
  }

  public void addNewBook(String t, String a, String c, String i, int co) {
    // adds book to the array
    // currentGenre.addNewBook(title, author, call, isbn, copies);
    catalog.add(new Book(t,a,c,i,co));
  }

  public ArrayList<Book> getBooks() {
    // get method
    // accessor method
    return catalog;
  }

  public String getGenre() {
    // accessor method
    // get method
    return genre;
  }

  public void setGenre(String genre) {
    // set method
    // mutator method
    this.genre = genre;
  }

  public void deleteCatalog() {
    // delete catalog
    catalog.clear();
  }

  public void deleteBook(Book item) {
    // delete the item from the array
    catalog.remove(item);
  }

}
