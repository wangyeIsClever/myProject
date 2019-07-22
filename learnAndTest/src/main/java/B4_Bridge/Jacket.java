package B4_Bridge;


public class Jacket implements Production {
    @Override
    public void beProducted() {
        System.out.println("夹克被生产了");
    }

    @Override
    public void beSaled() {
        System.out.println("夹克被销售卖掉了");
    }

    @Override
    public void beBuyBySaleMan() {
        System.out.println("夹克被销售买进了");
    }
}
