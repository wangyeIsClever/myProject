package C7_Command;


public class Designer implements Receiver {
    @Override
    public void action() {
        System.out.println("我是设计员，我要做产品设计");
    }
}
