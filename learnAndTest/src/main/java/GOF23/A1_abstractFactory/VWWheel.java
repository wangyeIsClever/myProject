package GOF23.A1_abstractFactory;

/**
 * 大众的轮子
 */
public class VWWheel implements Wheel{
    public void run() {
        System.out.println("我是大众的轮子，我运行起来比较稳");
    }
}
