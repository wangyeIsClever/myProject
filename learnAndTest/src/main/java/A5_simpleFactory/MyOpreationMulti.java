package A5_simpleFactory;

import java.math.BigDecimal;

public class MyOpreationMulti extends MyOperation {

    MyOpreationMulti(BigDecimal number1, BigDecimal number2) {
        super(number1, number2);
    }

    public BigDecimal getResult() {
        return this.getNumber1().multiply(this.getNumber2());
    }
}
