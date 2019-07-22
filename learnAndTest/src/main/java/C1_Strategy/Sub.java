package C1_Strategy;

import java.math.BigDecimal;

public class Sub implements Calculation {

    @Override
    public void calculate(BigDecimal a, BigDecimal b) {
        System.out.println(a.subtract(b).toString());
    }
}
