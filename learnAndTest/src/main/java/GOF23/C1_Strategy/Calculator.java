package GOF23.C1_Strategy;

import java.math.BigDecimal;

/**
 * 计算器只关心两个数计算，但是不关心两数是如何计算的（不关心是加，还是乘，还是除）
 */
public class Calculator {
    private BigDecimal a;

    private BigDecimal b;

    Calculator(BigDecimal a,BigDecimal b){
        this.a = a;
        this.b = b;
    }


    public void calculate(Calculation calculation){
        calculation.calculate(a,b);
    }
}
