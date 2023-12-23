
public class Book implements java.io.Serializable, Comparable {
  private String title;
  private String author;
  private String call;
  private String isbn;
  private int copies;
  

  public Book(String title, String author, String call, String isbn, int copies) {
    // constructor
    this.title = title;
    this.author = author;
    this.call = call;
    this.isbn = isbn;
    this. copies = copies;
  }
  public Book(String title) {
    // constructor that can accept only title 
    this.title = title;
  }

  public String getTitle() {
    // get method
    // accessor method
    return title;
  }

  public void setTitle(String title) {
    // set method
    // mutator method
    this.title = title;
  }

  public String getAuthor(){
    // get method
    // accessor method
    return author;
  }

  public void setAuthor(String author){
    // set method
    // mutator method
    this.author = author;
  }
  public String getCall(){
    return call;
  }
  public void setCall(String call){
    this.call = call;
  }
  public String getIsbn(){
    return isbn;
  }
  public void setIsbn(String isbn){
    this.isbn = isbn;
  }
  public int getCopies(){
    return copies;
  }
  public void setCopies(int copies){
    this.copies = copies;
  }
  public int compareTo(Object b) {
    // allows the collection sort method to work because its comparing user defined
    // objects
    Book bb = (Book) b;
    if (this.getTitle().equalsIgnoreCase(bb.getTitle()))
      return 0;
    // if titles are equal, return 0
    else if (this.getTitle().compareTo(bb.getTitle()) > 0)
      return 1;
    // if current title is alphabetically higher than other title
    else
      return -1;
    // if current title is alphabetically lower than other title
  }

  @Override
  public String toString() {
    // toString
    return "\n" + title;
  }

}
