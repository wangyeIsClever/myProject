package A5_simpleFactory;

import java.math.BigDecimal;


public class MyOperationDivide extends MyOperation {

    MyOperationDivide(BigDecimal number1, BigDecimal number2) {
        super(number1, number2);
    }

    public BigDecimal getResult() {
        return this.getNumber1().divide(this.getNumber2(),10,BigDecimal.ROUND_HALF_DOWN);
    }
}
