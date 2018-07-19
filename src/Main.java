import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File fileItemsPhase1 = new File("phase-1.txt");
        File fileItemsPhase2 = new File("phase-1.txt");
        Scanner scannerPhase1 = new Scanner(fileItemsPhase1);
        Scanner scannerPhase2 = new Scanner(fileItemsPhase2);
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1Items = simulation.loadItems(scannerPhase1);
        ArrayList<Item> phase2Items = simulation.loadItems(scannerPhase1);
        ArrayList<U1> u1RocketsList = simulation.loadU1(phase1Items);
        ArrayList<U2> u2RocketsList = simulation.loadU2(phase2Items);
    }
}
