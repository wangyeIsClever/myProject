package GOF23.A5_simpleFactory;


import java.math.BigDecimal;

/**
 * 工厂角色
 */
public class OperationFactory {

    public static MyOperation getOperation(OperationType operationType, BigDecimal number1,BigDecimal number2) throws Exception{

        switch (operationType){
            case ADD:
                return new MyOperattionAdd(number1, number2);
            case SUB:
                return new MyOperationSub(number1,number2);
            case MULTI:
                return new MyOpreationMulti(number1,number2);
            case DIVIDE:
                return new MyOperationDivide(number1,number2);
            default:
                throw new Exception("NO this Opreation");

        }

    }
}
