  import java.util.ArrayList;

public class Menu {

	public static void displayMenu(ArrayList<MenuItem> items) {

		// Display Menu
		System.out.println(" MENU");
		System.out.println("------------------------");
		//Loop Through Options and items
			for (int i = 0; i < items.size(); i++) {

				MenuItem item = items.get(i);
				System.out.printf("%d. %s \t %.2f\n", i + 1, item.getName(), item.getPrice());
			}
			//Print the EXIT option
			System.out.printf("%d. Exit\n", items.size() + 1);
			System.out.println("------------------------");
	}
}