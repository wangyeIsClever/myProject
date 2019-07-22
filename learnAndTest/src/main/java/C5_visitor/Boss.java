package C5_visitor;

import java.math.BigDecimal;

public class Boss implements Viewer {

    private BigDecimal totalIncomeAmount = new BigDecimal("0");

    private BigDecimal totalComsumeAmount = new BigDecimal("0");

    @Override
    public void view(IncomeBill incomeBill) {
        totalIncomeAmount = totalIncomeAmount.add(incomeBill.getAmount());
    }

    @Override
    public void view(ComsumeBill comsumeBill) {
        totalComsumeAmount = totalComsumeAmount.add(comsumeBill.getAmount());
    }

    public BigDecimal getTotalIncomeAmount() {
        return totalIncomeAmount;
    }

    public BigDecimal getTotalComsumeAmount() {
        return totalComsumeAmount;
    }

    public void showTotalIncome(){
        System.out.println("收入总额是："+ totalIncomeAmount);
    }

    public void showTotalComsume(){
        System.out.println("支出总额是：" + totalComsumeAmount);
    }
}
