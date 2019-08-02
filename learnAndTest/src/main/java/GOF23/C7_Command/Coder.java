package GOF23.C7_Command;

/**
 *
 */
public class Coder implements Receiver{
    @Override
    public void action() {
        System.out.println("我是码农，我根据产品设计去实现");
    }
}
