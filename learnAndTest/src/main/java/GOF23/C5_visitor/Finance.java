package GOF23.C5_visitor;


import java.math.BigDecimal;

public class Finance implements Viewer {

    private BigDecimal totalIncomeTax = new BigDecimal("0");

    private BigDecimal totalComsumeTax = new BigDecimal("0");

    @Override
    public void view(IncomeBill incomeBill) {
        totalIncomeTax = totalIncomeTax.add(incomeBill.getAmount().multiply(new BigDecimal("0.02")));
    }

    @Override
    public void view(ComsumeBill comsumeBill) {
        totalComsumeTax = totalComsumeTax.add(comsumeBill.getAmount().multiply(new BigDecimal("0.03")));
    }

    public BigDecimal getTotalIncomeTax() {
        return totalIncomeTax;
    }

    public BigDecimal getTotalComsumeTax() {
        return totalComsumeTax;
    }

    public void showTotalIncomeTax(){
        System.out.println("收入总税是："+ totalIncomeTax);
    }

    public void showTotalComsumeTax(){
        System.out.println("支出总税是：" + totalComsumeTax);
    }
}
