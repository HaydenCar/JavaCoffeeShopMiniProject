import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cash{
	String itemName;
	double itemPrice;

	public double getItemPrice() {
	   return itemPrice;
	}
	public String getItemName() {
	   return itemName;
    }
    public static void completeTransaction(int choice, ArrayList<MenuItem> items) {
	        MenuItem item = items.get(choice - 1);
	        System.out.printf("%s coffee \t %.2f\n", item.getName(), item.getPrice());
    }
    // Writes a cash transaction to a log file
    public static void cashLog(String name, double price, double tendered, double change) {
        LocalDateTime myDateTime = LocalDateTime.now();

        try {
            // Open a FileWriter to append to the transaction log file
            FileWriter fw = new FileWriter("Receipts.txt", true);
            // Create a PrintWriter to write formatted output to the file
            PrintWriter pw = new PrintWriter(fw);

            // Write the cash transaction data to the file in a formatted string
            pw.printf("\n***************Receipt***************\nPaid with Cash, Date: %tF, Time: %tT\nCoffee: %s, Price: %.2f \nCash tendered %.2f , Change given: %.2f\n**************************************\n", myDateTime, myDateTime, name, price, tendered, change);
            // Close the PrintWriter to flush the buffer and release the file resources
            pw.close();
        } catch (Exception e) {
            // If an exception occurs, print an error message to the console
            System.out.println("Error writing to transaction log file: " + e.getMessage());
        }
    }
}
