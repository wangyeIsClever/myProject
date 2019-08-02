package GOF23.A5_simpleFactory;



import java.math.BigDecimal;

public class SimpleFactoryTest {

    public static void main(String[] args) throws Exception {
        // 初始化BigDecimal建议用String
        BigDecimal number1 = new BigDecimal("2.8");
        BigDecimal number2 = new BigDecimal("2.9");

        add(number1,number2);
        subtract(number1,number2);
        multiply(number1, number2);
        divide(number1,number2);
    }


    public static void add(BigDecimal number1,BigDecimal number2) throws Exception {

        MyOperation add = OperationFactory.getOperation(OperationType.ADD, number1,number2);
        BigDecimal result = add.getResult();
        System.out.println("加法："+result);
    }

    public static void subtract(BigDecimal number1,BigDecimal number2) throws Exception {
        MyOperation sub = OperationFactory.getOperation(OperationType.SUB,number1,number2);
        BigDecimal result = sub.getResult();
        System.out.println("减法："+result);
    }

    public static void multiply(BigDecimal number1,BigDecimal number2) throws Exception {
        MyOperation multi = OperationFactory.getOperation(OperationType.MULTI,number1,number2);
        BigDecimal result = multi.getResult();
        System.out.println("乘法："+result);
    }

    public static void divide(BigDecimal number1,BigDecimal number2) throws Exception {
        MyOperation divide = OperationFactory.getOperation(OperationType.DIVIDE,number1,number2);
        BigDecimal result = divide.getResult();
        System.out.println("除法："+result);
    }

}
