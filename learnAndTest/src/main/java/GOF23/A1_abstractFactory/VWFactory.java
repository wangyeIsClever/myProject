package GOF23.A1_abstractFactory;

public class VWFactory implements CarFactory {

    public Engine createEngine() {
        return new VWEngine();
    }

    public Wheel createWheel() {
        return new VWWheel();
    }

    public Chassis createChassis() {
        return new VWChassis();
    }

}
