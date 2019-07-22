package C10_Interpreter;

import java.util.Stack;

/**
 * 句子解释处理类
 */
public class InstructionHandler {

    private AbstractNode node;

    public void Handle(String instruction) {
        //用栈来保存语法树。
        AbstractNode left;
        AbstractNode right;
        AbstractNode direction;
        AbstractNode action;
        AbstractNode distance;

        AbstractNode andNode;
        Stack<AbstractNode> stack = new Stack<>();
        //用空格分隔指令
        String[] word = instruction.split(" ");
        //循环
        for(int i = 0; i < word.length; i++) {
            if(word[i].equalsIgnoreCase("and")) { // 如果遇到连接词and，先将左解释器弹出，然后解释右半部，最后左右合成一个连接解释器
                left = stack.pop();
                String wordl = word[++i];
                direction = new DirectionNode(wordl);
                String word2 = word[++i];
                action = new ActionNode(word2);
                String word3 = word[++i];
                distance = new DistanceNode(word3);
                right = new SentenceNode(direction, action, distance);
                andNode = new AndNode(left,right);
                stack.push(andNode);
            }else { // 如果没有遇到连接词and ，解释 方向 + 动作 + 距离，合成一个 短句解释器
                String word1 = word[i];
                direction = new DirectionNode(word1);
                String word2 = word[++i];
                action = new ActionNode(word2);
                String word3 = word[++i];
                distance = new DistanceNode(word3);
                left= new SentenceNode(direction, action, distance);
                stack.push(left);
            }
        }

        this.node = stack.pop();
    }

    public String output() {
        String result = node.interpret();
        return result;
    }

}
