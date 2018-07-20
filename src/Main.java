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
        fleetU1Phase2 = simulation.loadU1(itemsPhase2);
        System.out.println("Phase 1 fleet U1 has " + fleetU1Phase1.size() + " rockets");
        System.out.println("Phase 2 fleet U1 has " + fleetU1Phase2.size() + " rockets");

    }
}
