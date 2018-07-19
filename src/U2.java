public class U2 extends Rocket{
    @Override
    public boolean launch() {
        return (Math.random() < 0.5);
    }

    @Override
    public boolean land() {
        return (Math.random() < 0.5);
    }
}
