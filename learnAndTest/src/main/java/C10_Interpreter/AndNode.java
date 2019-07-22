package C10_Interpreter;

/**
 * and 连接词文法解释器
 */
public class AndNode extends AbstractNode {

    private AbstractNode left; //左表达式
    private AbstractNode right;	//右表达式


    AndNode(AbstractNode left,AbstractNode right){
        this.left = left;
        this.right = right;
    }

    /**
     * 连接左右文法的解释
     * @return 解释后的结果
     */
    @Override
    public String interpret() {
        return this.left.interpret() +  " 再 " + this.right.interpret();
    }
}
