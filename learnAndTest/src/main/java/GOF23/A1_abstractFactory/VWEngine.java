package GOF23.A1_abstractFactory;

/**
 * 大众引擎
 */
public class VWEngine implements Engine{

    public void work() {
        System.out.println("我是大众的引擎，我运行的转速比较高");
    }
}
