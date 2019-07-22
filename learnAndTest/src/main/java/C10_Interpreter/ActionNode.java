package C10_Interpreter;

/**
 * 动作的文法
 */
public class ActionNode extends AbstractNode {

    private String action; // 具体的动作，对具体的动作进行解释

    public ActionNode(String action) {
        this.action = action;
    }

    /**
     * 如果动作是move 就返回移动 ，如果是run 就返回奔跑，否则就是无效的文法指令
     * @return 解释后的结果
     */
    @Override
    public String interpret() {
        if(action.equalsIgnoreCase("move")) {
            return "移动";
        }else if(action.equalsIgnoreCase("run")) {
            return "奔跑";
        }else {
            return "无效指令";
        }
    }

}
