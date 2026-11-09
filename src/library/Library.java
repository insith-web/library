package library;
import java.util.ArrayList;
import java.util.List;

public class Library{
    private List<Item> items;
    public Library(){
        items = new ArrayList<>();
    }
    public void addItem(Item item){
        if(item==null){
            throw new IllegalArgumentException("Item cannot be empty.");
        }
        items.add(item);
    }
    public Item findByIsbn(String isbn){
        for(Item item: items){
            if(item.getIsbn().equals(isbn)){
                return item;
            }
        }
        return null;
    }
    public void checkoutItem(String isbn) throws InvalidLibraryOperationException{
        Item item = findByIsbn(isbn);
        if(item == null){
            throw new InvalidLibraryOperationException("Checkout failed: ISBN " + isbn + " not found.");
        }
        IO.println(item.borrowItem(14));
    }

    public void returnItemByIsbn(String isbn) throws InvalidLibraryOperationException{
        Item item = findByIsbn(isbn);
        if (item == null){
            throw new InvalidLibraryOperationException("Return Failed: ISBN " + isbn + " not found.");
        }
        if (!item.isBorrowed()){
            throw new InvalidLibraryOperationException("Return failed: " + item.getTitle() + " was not checked out.");
        }
        IO.println(item.returnItem());
    }

    public List<Item> getItems(){
        return new ArrayList<>(items);
    }
    public int getBorrowedCount(){
        int count = 0;
        for(Item item :  items){
            if(item.isBorrowed()){
                count++;
            }
        }
        return count;
    }
}