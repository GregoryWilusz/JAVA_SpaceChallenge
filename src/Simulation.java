import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


    public Simulation() {

    }

    public ArrayList<Item> loadItems(ArrayList<Item> items, int phaseNumber) {

        String line;
        String fileName = "";
        int sumOfAllItems = 0;

        try {
            if (phaseNumber == 1) {
                System.out.println("Loading items for phase 1.");
                fileName = "phase-1.txt";
            } else if (phaseNumber == 2) {
                System.out.println("Loading items for phase 2.");
                fileName = "phase-2.txt";
            } else {
                System.out.println("Cannot load items for both phase 1 and phase 2.");
                System.out.println("Exiting the program");
                System.exit(1);
            }
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Item item = new Item();
                line = scanner.nextLine();
                int indexOfSeparator = line.indexOf("=");

                item.name = line.substring(0, indexOfSeparator);
                item.weight = Integer.parseInt(line.substring(indexOfSeparator + 1));
                sumOfAllItems += item.weight;
                items.add(item);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

            System.out.println(sumOfAllItems);


        return items;
    }

//    loadU1: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
//    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling
//    that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> fleetU1 = new ArrayList<>();

        int i = 0;
        while (i < (items.size() - 1)) {
            U1 u1 = new U1();
            while (u1.currentRocketWeight <= u1.rocketMaxWeight) {
                if(items.get(i).weight > u1.cargoLimit) {
                    System.out.println("File phase-1.txt item " + items.get(i).name + " has weight " + items.get(i).weight
                            + "which is heavier than cargo limit of U1 rocket -> " + u1.cargoLimit);
                    System.out.println("Program stop");
                    System.exit(1);
                }

                if(u1.canCarry(items.get(i))) { //  can carry item i ?
                    u1.carry(items.get(i));
                    i++; // point next item to load
                    if (i >= items.size()) {
                        u1.rocketStatus = "loaded";
                        fleetU1.add(u1);
                        break; // all items from file phase-1.txt are loaded --> exit loop
                    }
                } else { // if can not carry item (is almost full loaded):
                    u1.rocketStatus = "loaded";
                    fleetU1.add(u1);
                    break;
                }
            }
        }
        System.out.println(fleetU1);
        return fleetU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> fleetU2 = new ArrayList<>();

        

        return fleetU2;
    }
}
