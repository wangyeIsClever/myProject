package GOF23.A2_builder;

public interface CarBuilder {

    void buildEngine();

    void buildWheel();

    void buildChassis();

    Car buildCar();
}
