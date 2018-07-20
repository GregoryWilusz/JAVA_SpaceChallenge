import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {


    public Simulation() {

    }

    public ArrayList<Item> loadItems(ArrayList<Item> items, int phaseNumber) {

        String line;
        String fileName = "";

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
                items.add(item);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

//    loadU1: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
//    It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and filling
//    that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.

    public ArrayList<U1> loadU1(ArrayList<Item> items) {
        ArrayList<U1> fleetU1 = new ArrayList<>();

        int i = 0;
        while (i < (items.size()-1)) {
            U1 u1 = new U1();
            while (u1.currentRocketWeight <= u1.rocketMaxWeight) {
                // Extremely heavy item case (human mistake)
                if(items.get(i).weight > u1.cargoLimit) {
                    System.out.println("File phase-1.txt item " + items.get(i).name + " has weight " + items.get(i).weight
                            + "which is heavier than cargo limit of U1 rocket -> " + u1.cargoLimit);
                    System.out.println("Program stop");
                    System.exit(1);
                }

                // Carrying items
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
        return fleetU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> items) {
        ArrayList<U2> fleetU2 = new ArrayList<>();

        int i = 0;
        while (i < (items.size() - 1)) {
            U2 u2 = new U2();
            while(u2.currentRocketWeight <= u2.rocketMaxWeight) {
                if(items.get(i).weight > u2.cargoLimit) {
                    System.out.println("File phase-2.txt item " + items.get(i).name + " has weight " + items.get(i).weight
                            + "which is heavier than cargo limit of U1 rocket -> " + u2.cargoLimit);
                    System.out.println("Program stop");
                    System.exit(1);
                }

                if(u2.canCarry(items.get(i))) {
                    u2.carry(items.get(i));
                    i++;
                    if(i >= items.size()) { // Checks if we are not out of items array bound
                        u2.rocketStatus = "loaded";
                        fleetU2.add(u2);
                        break;
                    }
                } else {
                    u2.rocketStatus = "loaded";
                    fleetU2.add(u2);
                    break;
                }
            }
        }
        return fleetU2;
    }

    /*
    A method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
    Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
    All while keeping track of the total budget required to send each rocket safely to Mars. runSimulation then returns
    the total budget required to send all rockets (including the crashed ones).
     */

    public int runSimulation(ArrayList fleet) {

        int totalBudget;

        Rocket rocket = new Rocket(); // create new object of type Rocket for getting U1 or U2
        int rocketCounter = 1;
        for (int i = 0; i < fleet.size(); i++) { // repeat until all fleet landed on Mars
            rocket = (Rocket) fleet.get(i); // get object of type U1 or U2 in common object Rocket
            if(rocket.launch()) {
                System.out.println("Rocket " + rocketCounter + " successfully launched.");
                rocket.rocketStatus = "launched";
                if (rocket.land()) {
                    System.out.println("Rocket " + rocketCounter + " successfully landed.");
                    rocket.rocketStatus = "landed";
                    rocketCounter++;
                } else {
                    System.out.println("Rocket " + rocketCounter + " crashed at landing.");
                    rocket.rocketStatus = "crashed";
                    fleet = launchNewRocket(fleet, i);
                }
            } else {
                System.out.println("Rocket " + rocketCounter + " exploded at launching. Repeat launch with the same cargo.");
                rocket.rocketStatus = "exploded";
                fleet = launchNewRocket(fleet, i);
            }
        }

        totalBudget = fleet.size() * rocket.rocketCost;
        return totalBudget;
    }

    private ArrayList<Rocket> launchNewRocket(ArrayList fleet, int rocketIndex) {

        Rocket oldRocketCopy;
        oldRocketCopy = (Rocket) fleet.get(rocketIndex);

        if (oldRocketCopy instanceof U1) {
            U1 newU1Rocket = new U1();
            newU1Rocket.rocketStatus = "loaded";
            newU1Rocket.cargoCarried = oldRocketCopy.cargoCarried;
            newU1Rocket.currentRocketWeight = oldRocketCopy.currentRocketWeight;
            fleet.add(rocketIndex + 1, newU1Rocket);
        } else if (oldRocketCopy instanceof U2) {
            U2 newU2Rocket = new U2();
            newU2Rocket.rocketStatus = "loaded";
            newU2Rocket.cargoCarried = oldRocketCopy.cargoCarried;
            newU2Rocket.currentRocketWeight = oldRocketCopy.currentRocketWeight;
            fleet.add(rocketIndex + 1, newU2Rocket);
        } else {
            System.out.println("Cannot run simulation, unknown rocket model.");
            System.out.println("Program stop");
            System.exit(1);
        }

        return fleet;
    }
}
