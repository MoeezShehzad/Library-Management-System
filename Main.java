import java.util.Scanner;
import java.util.ArrayList;

class Library {
    ArrayList<String> books = new ArrayList<String>();
    int bookId;
    String bookName;
    String IssueDate;
    String ReturnDate;
    String name;

    public void getVal() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name: ");
        name = sc.nextLine();

        System.out.println("Enter Book ID: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer for Book ID: ");
            sc.next(); // discard the invalid input
        }
        bookId = sc.nextInt();
        sc.nextLine(); // consume the newline character

        System.out.println("Enter Book Name: ");
        bookName = sc.nextLine();

        System.out.println("Enter Issue Date: ");
        IssueDate = sc.nextLine();

        System.out.println("Enter Return Date: ");
        ReturnDate = sc.nextLine();
    }

    public void IssueBook() {
        System.out.println("Issuing a book...");
        getVal();
        System.out.println("Book Issued");
    }

    // Book returning method
    public void ReturnBook() {
        if (bookId == 0 || bookName == null || name == null) {
            System.out.println("No books data found to be returned");
            return;
        } else {
            System.out.println("Returning a book...");
            System.out.println("Book returned by " + name + " with Book ID: " + bookId + " on " + ReturnDate);
            System.out.println("Book Returned");
        }
    }

    // adding books using arraylist
    public void addingBookusingArrayList() {
        Scanner sc = new Scanner(System.in);
        int amountofBooks = 0;
        System.out.println("Enter amount of books you want to add: ");
        amountofBooks = sc.nextInt();
        for (int i = 0; i < amountofBooks; i++) {
            System.out.println("Enter Book Name: ");
            String bookName = sc.next();
            books.add(bookName);
        }
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found");
            return;
        } else {
            books.toArray();
            for (String book : books) {
                System.out.println(book);
            }
        }
    }

    // Main AddBook method
    public void AddBook() {
        System.out.println("Adding a book...");
        // calling the addingBookusingArrayList method
        addingBookusingArrayList();
        System.out.println("Book Added");
    }

    public void RemoveBook() {
        if(books.isEmpty()){
            System.out.println("Books not found");
        }
        else{
            Scanner scan = new Scanner(System.in);
            String bookToRemove = scan.nextLine();
            if(books.contains(bookToRemove)){
                books.remove(bookToRemove);
                System.out.println("Book removed of name: "+ bookToRemove);
            }
            else
                System.out.println("Book not found");
        }
    }

    public void info() {
        if (bookId == 0 || bookName == null || IssueDate == null || ReturnDate == null || name == null) {
            System.out.println("No Record Found");
            return;
        } else {
            System.out.println("Name: " + name + ", BookID: " + bookId + ", Book Name: " + bookName + ", Issue Date: "
                    + IssueDate);
        }
    }

    public void CreateAccount() {
        System.out.println("Creating a new account...");
        getVal();
        System.out.println("Account Created");
    }

    public void clearValues() {
        bookId = 0;
        bookName = null;
        IssueDate = null;
        ReturnDate = null;
        name = null;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("*************************************");
            System.out.println("Welcome to Library Management System!");
            System.out.println("*************************************");
            System.out.println(
                    " 1. Issue a book \n 2. Return a book \n 3. Add a book \n 4. Remove a book \n 5. Create a new account \n 6. Check information \n 7. Show Books \n 8. Exit");
            System.out.print("Enter your choice: ");

            int n = 0;
            while (true) {
                if (sc.hasNextInt()) {
                    n = sc.nextInt();
                    sc.nextLine(); // consume the newline character
                    if (n >= 1 && n <= 8) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    sc.next(); // discard the invalid input
                }
            }

            switch (n) {
                case 1:
                    lib.IssueBook();
                    break;
                case 2:
                    lib.ReturnBook();
                    lib.clearValues();
                    break;
                case 3:
                    lib.AddBook();
                    break;
                case 4:
                    lib.RemoveBook();
                    break;
                case 5:
                    lib.CreateAccount();
                    break;
                case 6:
                    lib.info();
                    break;
                case 7:
                    lib.showBooks();
                    break;
                case 8:
                    keepRunning = false;
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
        sc.close();
    }
}
