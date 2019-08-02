package GOF23.A1_abstractFactory;

public interface CarFactory {

    Engine createEngine();

    Wheel createWheel();

    Chassis createChassis();
}
