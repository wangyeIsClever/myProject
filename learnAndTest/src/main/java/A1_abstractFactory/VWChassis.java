package A1_abstractFactory;

/**
 * 大众的底盘
 */
public class VWChassis implements Chassis{
    public void canBuild() {
        System.out.println("我是大众的地盘，我能比较好的组装其他零件");
    }
}
