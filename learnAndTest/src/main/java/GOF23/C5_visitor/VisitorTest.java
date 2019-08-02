package GOF23.C5_visitor;

import java.math.BigDecimal;

public class VisitorTest {
    public static void main(String[] args) {
        AccountBook accountBook = new AccountBook();

        accountBook.addBill(new IncomeBill(new BigDecimal("112.3"),"卖材料"));
        accountBook.addBill(new IncomeBill(new BigDecimal("105.3"),"平台服务赚取"));

        accountBook.addBill(new ComsumeBill(new BigDecimal("50.3"),"买办公器材"));
        accountBook.addBill(new ComsumeBill(new BigDecimal("15.3"),"内部培训"));

        Boss boss = new Boss();
        Finance finance = new Finance();

        accountBook.show(boss);
        accountBook.show(finance);

        boss.showTotalComsume();
        boss.showTotalIncome();

        finance.showTotalComsumeTax();
        finance.showTotalIncomeTax();
    }
}

