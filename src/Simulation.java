import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    private ArrayList<Item> items;
    private File file;
    private Scanner scanner;

    public Simulation(ArrayList<Item> items, File file, Scanner scanner) {
        this.items = items;
        this.file = file;
        this.scanner = scanner;
    }

    public ArrayList<Item> loadItems(Scanner scanner) {
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            items.add(new Item(line.substring(0, line.indexOf("=")), Integer.parseInt(line.substring(line.indexOf("=") + 1))));
        }
        for (Item item : items) {
            System.out.println(item.name + " " + item.weight);
        }

        return items;
    }
}
