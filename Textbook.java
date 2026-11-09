package library;
public class Textbook extends Book{
    private String subject;
    public Textbook(String isbn, String title, int pages, String author, String subject){
        super(isbn,title,pages,author);
        if(subject==null||subject.trim().isEmpty()){
            throw new IllegalArgumentException("Subject cannot be empty.");
        }
        this.subject = subject;
    }

    public String getSubject(){
        return subject;
    }
    @Override
    public String borrowingRule(){
        return "Textbook can be borrowed for up to 7 days.";
    }
    @Override
    public String toString(){
        return super.toString() + " | Subject: " + subject;
    }
}
