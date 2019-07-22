package C10_Interpreter;

/**
 * 句式解释器
 */
public class SentenceNode extends AbstractNode {

    private AbstractNode direction; // 句式中的方向
    private AbstractNode action; // 句式中的动作
    private AbstractNode distance; // 句式中的距离

    public SentenceNode(AbstractNode direction,AbstractNode action,AbstractNode distance) {
        this.direction = direction;
        this.action = action;
        this.distance = distance;
    }

    /**
     * 解释句式，句式一定要是 方向 + 动作 + 距离 如 : up move 10，如果不是就会出错
     * @return 解释后的结果
     */
    @Override
    public String interpret() {
        return this.direction.interpret() + this.action.interpret() + this.distance.interpret();
    }
}
