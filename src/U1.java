/*
Rocket Specifications : U-1
Rocket cost = $100 Million
Rocket weight = 10 Tonnes
Max weight (with cargo) = 18 Tonnes
Chance of launch explosion = 5% * (cargo carried / cargo limit)
Chance of landing crash = 1% * (cargo carried / cargo limit)
Create classes U1 and U2 that extend the Rocket class and override the land and launch methods
to calculate the corresponding chance of exploding and return either true or false
based on a random number using the probability equation for each.
 */

public class U1 extends Rocket {

    U1() {
        rocketCost = 100;
        rocketWeight = 10000;
        rocketMaxWeight = 18000;
        cargoLimit = rocketMaxWeight - rocketWeight;
        currentRocketWeight = rocketWeight;
        launchExplosionRiskRate = 0.05;
        landingCrashRiskRate = 0.01;
    }

    @Override
    public boolean launch() {
        return (Math.random() < 0.5);
    }

    @Override
    public boolean land() {
        return (Math.random() < 0.5);
    }

    @Override
    public String toString() {
        return "U1{" +
                "rocketCost=" + rocketCost +
                ", rocketWeight=" + rocketWeight +
                ", rocketMaxWeight=" + rocketMaxWeight +
                ", cargoCarried=" + cargoCarried +
                ", currentRocketWeight=" + currentRocketWeight +
                ", cargoLimit=" + cargoLimit +
                ", launchExplosionRiskRate=" + launchExplosionRiskRate +
                ", landingCrashRiskRate=" + landingCrashRiskRate +
                ", launchExplosionChance=" + launchExplosionChance +
                ", landingCrashChance=" + landingCrashChance +
                ", random=" + random +
                ", rocketStatus='" + rocketStatus + '\'' +
                '}';
    }
}
