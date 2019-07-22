package A4_factoryMethod;


public class FactoryMethodTest {
    public static void main(String[] args) {
        CarFactory carFactory;

        carFactory = new BenZFactory();
        Car benz = carFactory.createCar();
        benz.run();

        carFactory = new VWFactory();
        Car vw = carFactory.createCar();
        vw.run();
    }
}
