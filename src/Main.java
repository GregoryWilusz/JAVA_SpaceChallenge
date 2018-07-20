import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Item> itemsPhase1 = new ArrayList<>();
        ArrayList<Item> itemsPhase2 = new ArrayList<>();
        Simulation simulation = new Simulation();
        ArrayList<U1> fleetU1Phase1;
        ArrayList<U2> fleetU2Phase1;
        ArrayList<U1> fleetU1Phase2;
        ArrayList<U2> fleetU2Phase2;

        itemsPhase1 = simulation.loadItems(itemsPhase1, 1 );
        itemsPhase2 = simulation.loadItems(itemsPhase2, 2 );

        fleetU1Phase1 = simulation.loadU1(itemsPhase1);
        fleetU2Phase1 = simulation.loadU2(itemsPhase1);
        System.out.println("Phase 1 fleet U1 has " + fleetU1Phase1.size() + " rockets");
        System.out.println("Phase 1 fleet U2 has " + fleetU2Phase1.size() + " rockets");

        fleetU1Phase2 = simulation.loadU1(itemsPhase2);
        fleetU2Phase2 = simulation.loadU2(itemsPhase2);
        System.out.println("Phase 2 fleet U1 has " + fleetU1Phase2.size() + " rockets");
        System.out.println("Phase 2 fleet U2 has " + fleetU2Phase2.size() + " rockets");

        System.out.println("Simulation Phase 1 with U1 rockets START ---------");
        int totalBudgetOfPhase1U1 = simulation.runSimulation(fleetU1Phase1);
        System.out.println("Simulation Phase 1 with U1 rockets: budget = $" + totalBudgetOfPhase1U1 + " millions.");

        System.out.println("Simulation Phase 2 with U1 rockets START ---------");
        int totalBudgetOfPhase2U1 = simulation.runSimulation(fleetU1Phase2);
        System.out.println("Simulation Phase 2 with U1 rockets: budget = $" + totalBudgetOfPhase2U1 + " millions.");

        int totalBudgetOfU1 = totalBudgetOfPhase1U1 + totalBudgetOfPhase2U1;
        System.out.println("Simulation using the fleet of U1 rockets: total budget = $" + totalBudgetOfU1 + " millions");

        System.out.println("Simulation Phase 1 with U2 rockets START ---------");
        int totalBudgetOfPhase1U2 = simulation.runSimulation(fleetU2Phase1);
        System.out.println("Simulation Phase 1 with U2 rockets: budget = $" + totalBudgetOfPhase1U2 + " millions.");

        System.out.println("Simulation Phase 2 with U2 rockets START ---------");
        int totalBudgetOfPhase2U2 = simulation.runSimulation(fleetU2Phase2);
        System.out.println("Simulation Phase 2 with U2 rockets: budget = $" + totalBudgetOfPhase2U2 + " millions.");

        int totalBudgetOfU2 = totalBudgetOfPhase1U2 + totalBudgetOfPhase2U2;
        System.out.println("Simulation using the fleet of U2 rockets: total budget = $" + totalBudgetOfU2 + " millions");
    }
}
