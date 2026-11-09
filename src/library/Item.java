package library;
public abstract class Item implements Borrowable {
    private String isbn, title;
    private boolean borrowed;

    protected Item(String isbn, String title, boolean borrowed) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.isbn = isbn;
        this.title = title;
        this.borrowed = borrowed;
    }

    protected Item(String isbn, String title) {
        this(isbn, title, false);
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public abstract String borrowingRule();

    @Override
    public String toString() {
        String status = borrowed ? "Borrowed" : "Available";
        return title + " | ISBN: " + isbn + " | Status: " + status;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
    @Override
    public String borrowItem(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be greater than zero!");
        }
        borrowed = true;
        return title + " borrowed for " + days + " days ";
        }
    @Override
    public String returnItem(){
        if(!borrowed){
            return title + " was not borrowed.";
        }
        borrowed = false;
        return title + " returned successfully";
    }

}



