package C1_Strategy;

import java.math.BigDecimal;

public class Add implements Calculation {
    @Override
    public void calculate(BigDecimal a, BigDecimal b) {
        System.out.println(a.add(b).toString());
    }
}
