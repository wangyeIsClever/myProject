package C7_Command;

public class Invoker {

    private Command command;

    /**
     * 设置命令
     * @param command 具体的命令
     */
    public void invoke(Command command) {
        this.command = command;
    }

    public void call(){
        if (this.command != null){
            this.command.execute();
        } else {
            throw new RuntimeException("没有具体的命令，不能发出命令");
        }

    }

}
