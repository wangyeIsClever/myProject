package GOF23.C7_Command;

public class DesignCommand implements Command {

    private Receiver designerReceiver;

    DesignCommand(){
        this.designerReceiver = new Designer();
    }

    @Override
    public void execute() {
        this.designerReceiver.action();
    }
}
