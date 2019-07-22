package A5_simpleFactory;

import java.math.BigDecimal;

public abstract class MyOperation {

    private BigDecimal number1;

    private BigDecimal number2;


    MyOperation(BigDecimal number1,BigDecimal number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    public BigDecimal getNumber1() {
        return number1;
    }

    public void setNumber1(BigDecimal number1) {
        this.number1 = number1;
    }

    public BigDecimal getNumber2() {
        return number2;
    }

    public void setNumber2(BigDecimal number2) {
        this.number2 = number2;
    }

    public abstract BigDecimal getResult();
}
