package B4_Bridge;

public class Computer implements Production {
    @Override
    public void beProducted() {
        System.out.println("电脑被生产了");
    }

    @Override
    public void beSaled() {
        System.out.println("电脑被销售卖掉了");
    }

    @Override
    public void beBuyBySaleMan() {
        System.out.println("电脑被销售买进了");
    }
}
