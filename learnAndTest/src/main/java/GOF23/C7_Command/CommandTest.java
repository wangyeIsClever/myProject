package GOF23.C7_Command;

public class CommandTest {



    public static void main(String[] args) {
        // 创建设计命令
        Command designCommand = new DesignCommand();
        // 创建代码命令
        Command codeComamnd = new CodeCommand();
        // 创建发命令者
        Invoker invoker = new Invoker();

        // 设置设计命令
        invoker.invoke(designCommand);
        // 调用
        invoker.call();

        // 设置代码命令
        invoker.invoke(codeComamnd);

        // 调用
        invoker.call();
    }
}
