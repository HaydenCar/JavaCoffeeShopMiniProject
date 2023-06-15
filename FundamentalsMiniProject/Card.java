import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Card {
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
	ArrayList<MenuItem> cardLogItems = new ArrayList<MenuItem>();
	public static void cardLog(String name, double price, String cardType) {
		LocalDateTime myDateTime = LocalDateTime.now();
		//need to write this to a log file
		//System.out.printf("Card Transaction,%tF %tT,%s,%.2f,%s\n",myDateTime,myDateTime,name,price,cardType);
		try {
			FileWriter fw = new FileWriter("Receipts.txt", true);
			PrintWriter pw = new PrintWriter(fw);
			pw.printf("\n***************Receipt***************\nCard: %s\nDate: %tF, Time: %tT\nCoffee:%s, Price: %.2f\n**************************************\n",cardType,myDateTime,myDateTime,name,price);
			pw.close();
		}
		catch(IOException e){
		System.out.println("Error");
		}
	}
}