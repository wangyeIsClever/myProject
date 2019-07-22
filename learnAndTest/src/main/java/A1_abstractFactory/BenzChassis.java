package A1_abstractFactory;

/**
 * 奔驰底盘
 */
public class BenzChassis implements Chassis{
    public void canBuild() {
        System.out.println("我是奔驰的底盘，我能完美组装其他部分");
    }
}
