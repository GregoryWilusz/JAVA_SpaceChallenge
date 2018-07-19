import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        File file = new File("phase-2.txt");
        Scanner scanner = new Scanner(file);
        Simulation simulation = new Simulation(items, file, scanner);
        simulation.loadItems(scanner);
    }
}
