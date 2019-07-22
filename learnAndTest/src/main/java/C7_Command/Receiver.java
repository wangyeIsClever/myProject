package C7_Command;

/**
 * 命令接收者
 * 真正执行命令的角色
 */
public interface Receiver {

    /**
     * 执行任务方法
     */
   void action();
}
