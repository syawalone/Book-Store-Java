package JavaProject;

class Books {

    protected Books() {
        System.out.println("In Books constructor!");
    }

    public double getPrice() {
        throw new UnsupportedOperationException("Not supported: getPrice");
    }

    public String getTitle() {
        throw new UnsupportedOperationException("Not supported: getTitle");
    }
}

class Fiction extends Books {

    private double price = 15.0;
    private String title = "Fiction Book";

    public Fiction() {}

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}

class NonFiction extends Books {

    private String title = "Non-Fiction Book";

    public NonFiction() {}

    public String getTitle() {
        return title;
    }
}

public class BookStore {

    public static void main(String[] args) {

        Fiction fiction = new Fiction();
        NonFiction nonFiction = new NonFiction();

        try {
            printBookDetails(fiction);
            printBookDetails(nonFiction);
            System.out.println("All done!");
        } catch (Exception ex) {
            System.out.println("Exception! " + ex.getMessage());
        }
    }

    private static void printBookDetails(Books book) {
        try {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Price: $" + book.getPrice());
        } catch (UnsupportedOperationException ex) {
            System.out.println("Error while printing book details!");
            System.out.println("Back to main()");
            throw ex;
        } finally {
            System.out.println("Cleaning up after printing");
        }
    }
}
