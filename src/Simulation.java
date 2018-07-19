import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


    public Simulation() {

    }

    public ArrayList<Item> loadItems(Scanner scanner) {
        ArrayList<Item> items = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            items.add(new Item(line.substring(0, line.indexOf("=")), Integer.parseInt(line.substring(line.indexOf("=") + 1))));
        }
        for (Item item : items) {
            System.out.println(item.name + " " + item.weight);
        }
        return items;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> itemsArrayList) {
        ArrayList<U1> u1ArrayList = new ArrayList<>();

        return u1ArrayList;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> itemsArrayList) {
        ArrayList<U2> u2ArrayList = new ArrayList<>();

        return u2ArrayList;
    }
}
