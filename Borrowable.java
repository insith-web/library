package library;
public interface Borrowable {
    String borrowItem(int days);
    String returnItem();
    boolean isBorrowed();
}
