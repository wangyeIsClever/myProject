package B4_Bridge;


public class BridgeTest {

    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan();
        salesMan.saleProduct(new Jacket());
        salesMan.saleProduct(new Computer());
    }
}
