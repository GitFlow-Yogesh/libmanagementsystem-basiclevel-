import java.util.*;

// Student class
class Student {
    String name;
    String section;
    int rollNo;

    public Student(String name, String section, int rollNo) {
        this.name = name;
        this.section = section;
        this.rollNo = rollNo;
    }
}

// Faculty class
class Faculty {
    String facultyName;
    String facultyCourse;
    int facultyCode;

    public Faculty(String facultyName, String facultyCourse, int facultyCode) {
        this.facultyName = facultyName;
        this.facultyCourse = facultyCourse;
        this.facultyCode = facultyCode;
    }
}

// Book class
class Book {
    String bookName;
    String authorName;
    int bookId;

    public Book(String bookName, String authorName, int bookId) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Book{name='" + bookName + "', author='" + authorName + "', id=" + bookId + "}";
    }
}

// Main class
public class Main {
    static List<Book> bookDb = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void borrowBook() {
        System.out.print("Enter book name to borrow: ");
        String checkBook = scanner.nextLine();
        Iterator<Book> iterator = bookDb.iterator();
        boolean bookFound = false;

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.bookName.equalsIgnoreCase(checkBook)) {
                bookFound = true;
                iterator.remove();
                System.out.println("Book borrowed successfully: " + book.bookName);
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book not found.");
        }
    }

    public static void returnBook() {
        System.out.print("Enter book name to return: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book returnedBook = new Book(bookName, authorName, bookId);
        bookDb.add(returnedBook);
        System.out.println("Book returned successfully: " + bookName);
    }

    public static void userActions(String userType) {
        boolean active = true;
        while (active) {
            System.out.println("Press 1 to Borrow a book");
            System.out.println("Press 2 to Return a book");
            System.out.println("Press 3 to Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    borrowBook();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    active = false;
                    System.out.println(userType + " menu exited.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addBook() {
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Book book = new Book(bookName, authorName, bookId);
        bookDb.add(book);
        System.out.println("Book added successfully: " + book);
    }

    public static void showAllBooks() {
        if (bookDb.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Available books:");
            for (Book book : bookDb) {
                System.out.println(book);
            }
        }
    }

    public static void removeAllBooks() {
        bookDb.clear();
        System.out.println("All books removed successfully.");
    }

    public static void librarianActions() {
        boolean active = true;
        while (active) {
            System.out.println("Press 1 to Add a book");
            System.out.println("Press 2 to Remove all books");
            System.out.println("Press 3 to View all books");
            System.out.println("Press 4 to Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeAllBooks();
                    break;
                case 3:
                    showAllBooks();
                    break;
                case 4:
                    active = false;
                    System.out.println("Librarian menu exited.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Library System!");

        while (true) {
            System.out.println("Select 1 for Student");
            System.out.println("Select 2 for Faculty");
            System.out.println("Select 3 for Librarian");
            System.out.println("Select 4 to Exit");
            System.out.print("Choose option: ");

            int userOption = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (userOption) {
                case 1:
                    System.out.println("You are a Student.");
                    userActions("Student");
                    break;
                case 2:
                    System.out.println("You are Faculty.");
                    userActions("Faculty");
                    break;
                case 3:
                    System.out.println("You are a Librarian.");
                    librarianActions();
                    break;
                case 4:
                    System.out.println("Exiting the Library System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Choose a valid option.");
            }
            System.out.println();
        }
    }
}
