package GOF23.B4_Bridge;

/**
 * 销售人员
 */
public class SalesMan {

    public void saleProduct(Production production){
        production.beProducted();
        production.beBuyBySaleMan();
        production.beSaled();
    }
}
