package library;
public class Book extends Item {
    private int pages;
    private String author;

    public Book(String isbn, String title,int pages, String author){
        super(isbn,title);

        if(pages<=0){
            throw new IllegalArgumentException("Pages must be greater than zero.");
        }
        if(author==null||author.trim().isEmpty()){
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.pages = pages;
        this.author = author;

    }
    public Book(String isbn, String title, int pages){
        this(isbn,title,pages,"Unknown");
    }

    public int getPages(){
        return pages;
    }
    public String getAuthor(){
        return author;
    }
    public String borrowItem() {
        return super.borrowItem(14);
    }
    @Override
    public String borrowingRule() {
        return "Book can be borrowed for up to 14 days.";
    }
    @Override
    public String toString() {
        return super.toString() + " | Type: Book | Author: " + author + " | Pages: " + pages;
    }


}
