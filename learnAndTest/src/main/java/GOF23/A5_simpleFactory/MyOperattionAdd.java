package GOF23.A5_simpleFactory;

import java.math.BigDecimal;

public class MyOperattionAdd extends MyOperation {

    MyOperattionAdd(BigDecimal number1, BigDecimal number2) {
        super(number1, number2);
    }

    public BigDecimal getResult() {
        return this.getNumber1().add(this.getNumber1());
    }
}
