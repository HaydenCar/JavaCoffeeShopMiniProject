import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeShop {

	public static void main(String[] args) {

	  while (true) {
		System.out.printf("HAPPY CULTURE DAY!\n");
		System.out.println("-----------------------");
		//Data for menu
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		menuItems = FileItems.getMenuItems();
		Menu.displayMenu(menuItems);
		//Input
		Scanner in = new Scanner(System.in);

		System.out.print("input here: ");
		//Exit option
		int EXIT = menuItems.size() + 1;

		//User choice
		int choice = in.nextInt();
        if(choice == EXIT) { break;}
        if(choice > menuItems.size() + 1 || choice < 1) {
			System.out.println("invalid number");
			continue;}
		//Transaction choice menu
		System.out.println("1: Card Transaction or 2: Cash Transaction or press 3: to cancel");
		System.out.print("input here: ");
		int cashOrCard = in.nextInt();
		if(cashOrCard > 3 || cashOrCard < 1) {
					System.out.println("invalid number");
			continue;}
		//checks if cash or card
		if(cashOrCard == 1) {

			System.out.println("1: VISA or 2: Mastercard or press 3: to cancel");
			System.out.print("input here: ");
			int card = in.nextInt();
			//visa
			if(card == 1) {

				MenuItem item = menuItems.get(choice - 1);
				double itemPrice = item.getPrice();
				String itemName = item.getName();

				Card.cardLog(itemName, itemPrice, "VISA");

				//Print receipt to screen
				System.out.println("-----------------------");
				System.out.println("RECIEPT \n** VISA Transaction **");
				Card.completeTransaction(choice, menuItems);
				System.out.printf("Amount in USD: %.2f\n", itemPrice * 1.18);
				System.out.printf("Amount in YEN: %.2f\n", itemPrice * 148.60);
				System.out.printf("Amount in LEV: %.2f\n", itemPrice * 1.97);
				System.out.printf("Amount in POUNDS: %.2f\n", itemPrice * 0.89);
				System.out.printf("For culture day we are showing price conversions for other currencies at checkout!\n");

			}
			//mastercard
			if(card == 2) {
				MenuItem item = menuItems.get(choice - 1);
				double itemPrice = item.getPrice();
				String itemName = item.getName();

				Card.cardLog(itemName, itemPrice, "Mastercard");

				//print receipt
				System.out.println("-----------------------");
				System.out.println("RECIEPT \n** Mastercard Transaction **");
				Card.completeTransaction(choice, menuItems);
				System.out.printf("Amount in USD: %.2f\n", itemPrice * 1.18);
				System.out.printf("Amount in YEN: %.2f\n", itemPrice * 148.60);
				System.out.printf("Amount in LEV: %.2f\n", itemPrice * 1.97);
				System.out.printf("Amount in POUNDS: %.2f\n", itemPrice * 0.89);
				System.out.printf("For culture day we are showing price conversions for other currencies at checkout!\n");
			}
		}
		//cash
		if(cashOrCard == 2) {

			double amountTendered = in.nextDouble();

			//calculate purchase
			MenuItem item = menuItems.get(choice - 1);
			double itemPrice = item.getPrice();
			String itemName = item.getName();
			double change = (amountTendered - itemPrice);

			System.out.println("-----------------------");
			System.out.println("RECIEPT \n** CASH Transaction **");
			Cash.completeTransaction(choice, menuItems);
			Cash.cashLog(itemName, itemPrice, amountTendered, change);

			//print receipt
			System.out.printf("Amount Tendered \t = %.2f \nItem Price \t\t = %.2f \nChange \t\t\t = %.2f\n", amountTendered, itemPrice, change);
			System.out.printf("Amount in USD: %.2f\n", itemPrice * 1.18);
			System.out.printf("Amount in YEN: %.2f\n", itemPrice * 148.60);
			System.out.printf("Amount in LEV: %.2f\n", itemPrice * 1.97);
			System.out.printf("Amount in POUNDS: %.2f\n", itemPrice * 0.89);
			System.out.printf("For culture day we are showing price conversions for other currencies at checkout!\n");

		}

	System.out.println("-----------------------");
	System.out.printf("Thanks for stopping bye\n\n");
   }
}
}