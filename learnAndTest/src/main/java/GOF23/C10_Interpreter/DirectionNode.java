package GOF23.C10_Interpreter;

/**
 * 方向文法的解释器
 */
public class DirectionNode extends AbstractNode {

    private String direction; // 具体的方向

    public DirectionNode(String direction) {
        this.direction = direction;
    }

    /**
     * 对向下左右的文法进行解释
     * @return 文法解释后的结果
     */
    @Override
    public String interpret() {
        if(direction.equalsIgnoreCase("up")) {
            return "向上";
        }else if(direction.equalsIgnoreCase("down")) {
            return "向下";
        }else if(direction.equalsIgnoreCase("left")) {
            return "向左";
        }else if(direction.equalsIgnoreCase("right")) {
            return "向右";
        }else {
            return "无效指令";
        }
    }
}
