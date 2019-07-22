package C10_Interpreter;

public class InterpreterTest {

    public static void main(String[] args) {
        String instruction ="down run 10 and left move 20 and up run 500";
        InstructionHandler iHandler = new InstructionHandler();
        iHandler.Handle(instruction);
        String outString ;
        outString =iHandler.output();
        System.out.println(outString);
    }
}
