package A1_abstractFactory;

public class AbstractFactoryTest {

    public static void main(String[] args) {
        CarFactory carFactory;

        //首先使用奔驰的工厂创建奔驰的汽车零件
        carFactory = new BenzFactory();
        Engine benzEngine = carFactory.createEngine();
        benzEngine.work();
        Chassis benzChassis = carFactory.createChassis();
        benzChassis.canBuild();
        Wheel benzWheel = carFactory.createWheel();
        benzWheel.run();

        //然后使用大众的工厂创建大众的汽车零件
        carFactory = new VWFactory();
        Engine vwEngine = carFactory.createEngine();
        vwEngine.work();
        Chassis vwChassis = carFactory.createChassis();
        vwChassis.canBuild();
        Wheel vwWheel = carFactory.createWheel();
        vwWheel.run();
    }

}
