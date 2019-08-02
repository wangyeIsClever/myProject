package GOF23.A4_factoryMethod;

public class BenZFactory implements CarFactory {

    public Car createCar() {
        return new Benz();
    }
}
