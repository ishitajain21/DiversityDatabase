import java.io.*;
import java.util.*;


public class Main {
    ArrayList < Genre > gen = new ArrayList < Genre > ();
    // arraylist that stores the instances of Genre class
    // it stores the genres
    Scanner keyboard = new Scanner(System.in);

    public Main() {
        deserializeData();
    }

    public static void main(String[] args) {
        // Main menu
        Main app = new Main();
        boolean bContinue = false;
        do {
            try {
                System.out.println();
                System.out.println("========================");
                System.out.println("          Menu          ");
                System.out.println("========================");
                System.out.println("1. Add new Books");
                System.out.println("2. Add new Genre");
                System.out.println("3. View All Books");
                System.out.println("4. Delete Books");
                System.out.println("5. Search Book");
                System.out.println("6. Exit");

                System.out.print("Enter selection: ");
                int sel = Integer.parseInt(app.keyboard.nextLine());
                // sel is selection

                if (sel == 1)
                    app.addNewBook();
                else if (sel == 2)
                    app.addNewGenre();
                else if (sel == 3)
                    app.viewAllBooks();
                else if (sel == 4)
                    app.deleteBooks();
                else if (sel == 5)
                    app.searchBooks();
                bContinue = sel != 6;
            } catch (Exception e) {
                System.out.println("");
            }
        } while (bContinue);
    }

    public void addNewBook() {
        // this method allows you to add book into the data structure.

        System.out.println();
        System.out.println("------Add Book --------");
        if (gen.size() == 0) {
            System.out.println("No Genres yet! Press 2 and then add books.");
        } else {
            System.out.println("Genre List:");

            int counter = 1;
            // to put the number in front of the genre
            for (Genre client: gen) {
                // print out the list of genres
                System.out.println("" + counter + ". " + client.getGenre());
                counter++;
            }
            System.out.println();
            System.out.print("Select genre: ");
            int sel = Integer.parseInt(keyboard.nextLine());
            Genre currentGenre = gen.get(sel - 1);
            // the genre that the customer would like to add the title to

            // String title, String author, String call, String isbn, int copies
            System.out.print("Enter title: ");
            String title = keyboard.nextLine();

            System.out.print("Enter author: ");
            String author = keyboard.nextLine();

            System.out.print("Enter call: ");
            String call = keyboard.nextLine();

            System.out.print("Enter isbn: ");
            String isbn = keyboard.nextLine();

            System.out.print("Enter copies: ");
            int copies = Integer.parseInt(keyboard.nextLine());

            currentGenre.addNewBook(title, author, call, isbn, copies);
            // the book is added to the genre

        }
        serializeData();
    }

    public void addNewGenre() {
        // this method allows you to add new genre

        System.out.println();
        System.out.println("------Add Genre -------");
        System.out.print("Enter New Genre: ");
        String subGenre = keyboard.nextLine();
        // subGenre is input
        Genre newGenre = new Genre(subGenre);
        // instance
        gen.add(newGenre);
        // adds to the arraylist
        serializeData();
        // serialize data
    }

    public void viewAllBooks() {
        // this method allows you to view all books.

        System.out.println();
        System.out.println("------View Books ------");
        if (gen.size() == 0) {
            // to avoid the edge case where user tries to add books without adding genre
            System.out.println("No Genres yet! Press 2 and then view books.");
        } else {
            System.out.println("Genre List:");
            int counter = 1;
            System.out.println("0. View all genres");
            for (Genre client: gen) {
                System.out.println("" + counter + ". " + client.getGenre());
                counter++;
            }
            System.out.println();
            System.out.print("Select sub-genre: ");
            int sel = Integer.parseInt(keyboard.nextLine());
            if (sel == 0) {
                ArrayList < Book > all_books = new ArrayList < Book > ();
                for (Genre client: gen) {
                    for (Book b: client.getBooks()) {
                        all_books.add(b);
                    }
                }
                System.out.println("Sorting Filter:");
                // the filter which the user can choose from
                System.out.println("1.Sort by A-Z");
                System.out.println("2.Sort by Z-A");
                int sortFilter = Integer.parseInt(keyboard.nextLine());
                if (sortFilter == 1) {
                    // use collections to sort the catalog
                    // sorts from a-z
                    Collections.sort(all_books);
                    for (Book book: all_books) {
                        System.out.print(book);
                        System.out.print(" - ");
                        System.out.print(book.getAuthor());
                    }

                }
                if (sortFilter == 2) {
                    // sorts from z-a
                    Collections.sort(all_books);
                    for (int i = all_books.size() - 1; i >= 0; i--) {
                        // the for loop allows you to reverse the arraylist to organize books from z to
                        // a
                        System.out.print(all_books.get(i));
                        System.out.print(" - ");
                        System.out.print(all_books.get(i).getAuthor());
                    }
                }
            } else {
                Genre currentGenre = gen.get(sel - 1);

                System.out.println("Sorting Filter:");
                // the filter which the user can choose from
                System.out.println("1.Sort by A-Z");
                System.out.println("2.Sort by Z-A");
                int sortFilter = Integer.parseInt(keyboard.nextLine());
                ArrayList < Book > catalog = currentGenre.getBooks();
                // catalog is the genre's getBooks
                if (sortFilter == 1) {
                    // use collections to sort the catalog
                    // sorts from a-z
                    Collections.sort(catalog);
                    for (Book b: catalog) {
                        System.out.print(b);
                        System.out.print(" - ");
                        System.out.print(b.getAuthor());
                    }
                }
                if (sortFilter == 2) {
                    // sorts from z-a
                    Collections.sort(catalog);
                    for (int i = catalog.size() - 1; i >= 0; i--) {
                        // the for loop allows you to reverse the arraylist to organize books from z to
                        // a
                        System.out.print(catalog.get(i));
                        System.out.print(" - ");
                        System.out.print(catalog.get(i).getAuthor());
                    }
                }
            }


        }
        serializeData();
    }

    public void deleteBooks() {
        System.out.println();
        System.out.println("-----Delete Books -----");
        System.out.println("Would you like to:");
        System.out.println("1. Clear Database");
        System.out.println("2. Delete 1 book");
        int sel = Integer.parseInt(keyboard.nextLine());
        if (sel == 1) {
            // clears all traces of books and genres
            for (Genre client: gen) {
                client.deleteCatalog();
            }
            gen.clear();
        }
        else if (sel == 2) {
            System.out.print("Title of book: ");
            String title = keyboard.nextLine();
            for (Genre client: gen) {
                // uses enhanced for loop to find title of the book
                ArrayList < Book > catalog = client.getBooks();
                for (Book item: catalog) {
                    if (item.getTitle().equals(title)) {
                        client.deleteBook(item);
                        // calls method that will loop through arraylist in Genre and delete the book from the arraylist.
                    }
                }
            }
        }
        serializeData();
    }

    public void searchBooks() {
        System.out.println();
        System.out.println("-----Search Book ------");
        // has similar algorithm to delete books but instead of deleting it prints the
        // genre the book is unde
        System.out.print("Title of book: ");
        String title = keyboard.nextLine();
        for (Genre client: gen) {
            ArrayList < Book > catalog = client.getBooks();
            for (Book item: catalog) {
                // currentGenre.addNewBook(title, author, call, isbn, copies);
                if (item.getTitle().matches(title + ".*")) {
                    System.out.println();
                    System.out.print(item.getTitle());
                    System.out.print(" is under: ");
                    System.out.println(client.getGenre());
                    System.out.println("Author: " + item.getAuthor());
                    System.out.println("Call: " + item.getCall());
                    System.out.println("ISBN: " + item.getIsbn());
                    System.out.println("Copies: " + item.getCopies());

                }
            }
        }
        serializeData();
    }

    public void serializeData() {
        try {
            FileOutputStream fileOut = new FileOutputStream("GenreData.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(gen);
            out.close();
            fileOut.close();
            // System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            // i.printStackTrace();
        }
    }

    public void deserializeData() {
        try {
            FileInputStream fileIn = new FileInputStream("GenreData.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            gen = (ArrayList <Genre> ) in .readObject(); in .close();
            fileIn.close();
        } catch (IOException i) {
            // i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            // System.out.println("Employee class not found");
            // c.printStackTrace();
            return;
        }
    }
}