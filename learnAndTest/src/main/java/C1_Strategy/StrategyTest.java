package C1_Strategy;

import java.math.BigDecimal;

public class StrategyTest {

    public static void main(String[] args) {

        Calculator calculator = new Calculator(new BigDecimal("1.2"),new BigDecimal("1.5"));

        calculator.calculate(new Add());

        calculator.calculate(new Sub());
    }
}
