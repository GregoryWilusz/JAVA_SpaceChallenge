import java.util.Random;

public class Rocket implements SpaceShip {
    int rocketCost;
    int rocketWeight;
    int rocketMaxWeight;
    int cargoCarried;
    int currentRocketWeight;
    int cargoLimit;

    double launchExplosionRiskRate;
    double landingCrashRiskRate;
    double launchExplosionChance;
    double landingCrashChance;
    double random;

    String rocketStatus;

    public Rocket() {
        cargoCarried = 0;
        cargoLimit = 0;
        currentRocketWeight = 0;
        launchExplosionChance = 0.0;
        landingCrashChance = 0.0;
        random = new Random().nextDouble();
        rocketStatus = "not loaded";
    }

    // launch and land methods in the Rocket class should always return true, will be override in U1 and U2 classes.
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    // a method that takes an Item as an argument and returns true if the rocket can carry such item
    // or false if it will exceed the weight limit.
    @Override
    public boolean canCarry(Item item) {
        return (this.currentRocketWeight + item.weight) <= rocketMaxWeight;
    }

    // a method that also takes an Item object and updates the current weight of the rocket.
    @Override
    public void carry(Item item) {
        this.currentRocketWeight += item.weight;
        this.cargoCarried = this.currentRocketWeight - this.rocketWeight;
    }
}
