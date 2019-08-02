package GOF23.C7_Command;

public class CodeCommand implements Command{

    private Receiver codeReceiver;

    CodeCommand(){
        this.codeReceiver = new Coder();
    }

    @Override
    public void execute() {
        this.codeReceiver.action();
    }
}
