package GOF23.A4_factoryMethod;



/**
 *
 */
public class VWFactory implements CarFactory {

    public Car createCar() {
        return new VW();
    }
}
