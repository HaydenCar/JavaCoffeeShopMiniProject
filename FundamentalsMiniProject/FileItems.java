import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileItems {
    // Returns an ArrayList of MenuItem objects by reading from a file
    public static ArrayList<MenuItem> getMenuItems() {
        // Read the file into an ArrayList of Strings
        ArrayList<String> items = readFile("inventory.txt");
        // Create an empty ArrayList of MenuItem objects
        ArrayList<MenuItem> fileItems = new ArrayList<MenuItem>();

        // Loop through each line in the file
        for (int i = 0; i < items.size(); i++) {
            // Split the line into its name and price components
            String name = items.get(i).split(",")[0];
            double price = Double.parseDouble(items.get(i).split(",")[1]);

            // Create a new MenuItem object using the name and price, and add it to the ArrayList
            fileItems.add(new MenuItem(name, price));
        }
        // Return the ArrayList of MenuItem objects
        return fileItems;
    }



    // Reads a file and returns an ArrayList of its lines
    public static ArrayList<String> readFile(String fileName) {
        // Create an empty ArrayList of Strings
        ArrayList<String> data = new ArrayList<String>();

        FileReader fr = null;
        try {
            // Attempt to open the file for reading
            fr = new FileReader(fileName);
        } catch (FileNotFoundException e1) {
            // If the file can't be opened, print an error message and return an empty ArrayList
            System.out.println("ERROR - Cannot read from file" + fileName);
            return data;
        }

        // Create a BufferedReader to read the file
        BufferedReader br = new BufferedReader(fr);
        String line;
        try {
            // Read each line from the file and add it to the ArrayList
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            // If an IOException occurs, print an error message and return an empty ArrayList
            System.out.println("ERROR - Cannot read from file" + fileName);
            return data;
        }
        // Return the ArrayList of file lines
        return data;
    }
}
