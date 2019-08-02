package GOF23.A1_abstractFactory;

public class BenzFactory implements CarFactory{

    public Engine createEngine() {
        return new BenzEngine();
    }

    public Wheel createWheel() {
        return new BenzWheel();
    }

    public Chassis createChassis() {
        return new BenzChassis();
    }
}
