package library;
import java.util.Scanner;
public class Main{
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.addItem(new Book("97800001", "The Island", 300, "K. Junio"));
        library.addItem(new Book("97800003", "How to be a Dragon", 500, "M. Suguitan"));
        library.addItem(new Book("97800002", "Manipulate Everyone", 299, "K. Sumande"));
        library.addItem(new Textbook("97800008", "5 Feet Apart", 156, "B. Ong","Science"));
        library.addItem(new Textbook("97800004","Hunger Games: Mockingjay",529,"J. Lawrence","Math"));

        boolean running = true;
        IO.print("---Campus Library System---");
        while (running) {
            IO.println("\n--- Main Menu ---");
            IO.println("1. View All Items (Polymorphism Demo)");
            IO.println("2. Checkout Item");
            IO.println("3. Return Item");
            IO.println("4. Exit");
            IO.print("Select an option: ");
            String choice = scanner.nextLine();

        switch(choice){
            case "1": viewAllItems(library);
            break;
            case "2":
                IO.print("Select ISBN to checkout: ");
                String checkoutISBN = scanner.nextLine();
                try{
                    library.checkoutItem(checkoutISBN);
            }catch(InvalidLibraryOperationException e){
                    IO.println("ERROR: "+ e.getMessage());
                }
                break;
            case "3":
                IO.print("Enter ISBN to return: ");
                String returnISBN = scanner.nextLine();
                try {
                    library.returnItemByIsbn(returnISBN);
                }catch(InvalidLibraryOperationException e){
                    IO.print("ERROR: "+e.getMessage());
                }
                break;
            case "4":
                running = false;
                IO.println("GOODBYE!");
                break;
            default:
                IO.println("Invalid Option: Please enter 1, 2, 3 or 4");
        }
        }
        scanner.close();
    }
    private static void viewAllItems(Library library){
        IO.println("\n---Library Inventory---");
        for(Item item : library.getItems()){
            IO.println(item.toString());
            IO.println("  Rule: "+item.borrowingRule());
        }
    }


}