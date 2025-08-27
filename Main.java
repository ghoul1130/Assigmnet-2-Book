final class Book {

    private String title;
    private String author;
    private int totalPages;
    private int currentPage;
    private boolean isOpen;
    private final String publisher = "Penguin";

    public static int bookCount;  // Static scope - shared among all Book objects

    // Default constructor
    public Book() {
    }

    // Parameterized Constructor - custom initialization
    public Book(String title, String author, int totalPages) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.currentPage = 1; // Books start at page 1
        this.isOpen = false;
        bookCount++; // Class-level count
        System.out.println("  A new '" + this.publisher + "' Book object has been created.");
    }

    // ========== STATIC METHOD ==========
    public static int getBookCount() {
        return bookCount; // Class-level data access
    }

    // ========== INSTANCE METHODS ==========
    public void openBook() {
        if (!this.isOpen) {
            System.out.println("Opening the book: '" + this.title + "'");
            this.isOpen = true;
        } else {
            System.out.println("Book is already open.");
        }
    }

    public void closeBook() {
        if (this.isOpen) {
            System.out.println("Closing the book: '" + this.title + "'");
            this.isOpen = false;
        } else {
            System.out.println("Book is already closed.");
        }
    }

    public void readPage() {
        if (!this.isOpen) {
            System.out.println("Cannot read. The book is closed!");
            return;
        }

        if (currentPage > totalPages) {
            System.out.println("You've already finished reading the book!");
            return;
        }

        System.out.println("Reading page " + currentPage + " of '" + this.title + "'");
        currentPage++;
    }

    public void setTotalPages(int totalPages) {
        if (totalPages > 0) {
            this.totalPages = totalPages;
            System.out.println("Total pages of '" + this.title + "' updated to: " + totalPages);
        } else {
            System.out.println("Invalid page count! Must be greater than 0.");
        }
    }

    public void changeAuthor(String newAuthor) {
        System.out.println("Changing author from " + this.author + " to " + newAuthor);
        this.author = newAuthor;
    }

    public void checkCurrentPage() {
        System.out.println("Currently on page: " + this.currentPage + " of '" + title + "'");
    }
}

class TestBookDemo {
    public static void main(String[] args) {
        Book myBook = new Book("1984", "George Orwell", 328);

        myBook.openBook();
        myBook.readPage();
        myBook.readPage();
        myBook.checkCurrentPage();
        myBook.changeAuthor("Eric Arthur Blair");
        myBook.closeBook();
        myBook.setTotalPages(10);

        Book secondBook = new Book("Sapiens", "Yuval Noah Harari", 400);
        Book thirdBook = new Book("The Alchemist", "Paulo Coelho", 200);

        System.out.println("Total Number of Books created: " + Book.getBookCount());
    }
}