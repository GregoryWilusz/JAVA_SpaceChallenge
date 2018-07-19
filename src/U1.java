public class U1 extends Rocket {
    @Override
    public boolean launch() {
        return (Math.random() < 0.5);
    }

    @Override
    public boolean land() {
        return (Math.random() < 0.5);
    }
}
