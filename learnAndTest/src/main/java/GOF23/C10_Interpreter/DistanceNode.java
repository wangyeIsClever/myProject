package GOF23.C10_Interpreter;

/**
 * 距离文法解释
 */
public class DistanceNode extends AbstractNode {

    private String distance; // 具体的距离

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    /**
     * 解释文法中的距离
     * @return 解释后的结果
     */
    @Override
    public String interpret() {
        return distance + "米";
    }

}
