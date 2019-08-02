package GOF23.A2_builder;

public class CarBuilderImpl  implements CarBuilder {

    private Car car;

    public void buildEngine() {
        this.car.setEngine("引擎");
        System.out.println("汽车引擎构建完毕");
    }

    public void buildWheel() {
        this.car.setChassis("底盘");
        System.out.println("汽车底盘构建完毕");
    }

    public void buildChassis() {
        this.car.setWheel("轮子");
        System.out.println("汽车轮子构建完毕");
    }

    public Car buildCar() {
        this.car =  new Car();
        this.buildChassis();
        this.buildEngine();
        this.buildWheel();
        System.out.println("汽车建造完毕");
        return this.car;
    }
}
