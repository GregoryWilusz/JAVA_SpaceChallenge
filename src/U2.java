/*
Rocket Specifications : U-2
Rocket cost = $120 Million
Rocket weight = 18 Tonnes
Max weight (with cargo) = 29 Tonnes
Chance of launch explosion = 4% * (cargo carried / cargo limit)
Chance of landing crash = 8% * (cargo carried / cargo limit)
Create classes U1 and U2 that extend the Rocket class and override the land and launch methods
to calculate the corresponding chance of exploding and return either true or false
based on a random number using the probability equation for each.
 */

public class U2 extends Rocket{

    U2() {
        rocketCost = 120;
        rocketWeight = 18000;
        rocketMaxWeight = 29000;
        cargoLimit = rocketMaxWeight - rocketWeight;
        currentRocketWeight = rocketWeight;
        launchExplosionRiskRate = 0.04;
        landingCrashRiskRate = 0.08;
    }

    @Override
    public boolean launch() {
        this.launchExplosionChance = launchExplosionRiskRate * ((double)cargoCarried / (double) cargoLimit);
        return !(this.launchExplosionChance >= this.random);
    }

    @Override
    public boolean land() {
        this.landingCrashChance = landingCrashRiskRate * ((double)cargoCarried / (double) cargoLimit);
        return !(this.landingCrashChance >= this.random);
    }

    @Override
    public String toString() {
        return "U2{" +
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
