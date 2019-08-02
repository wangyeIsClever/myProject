package GOF23.C6_ChainOfResponsibility;

public abstract class AbstractProcessor {

    private AbstractProcessor superior;

    private Position position;

    /**
     * 创建 具体处理角色的时候要指定上级和职位
     * @param superior 上级 可以为空
     * @param position 职位
     */
    AbstractProcessor(AbstractProcessor superior,Position position){
         this.superior = superior;
         this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public AbstractProcessor getSuperior() {
        return superior;
    }

    /**
     * 处理请假抽象方法
     * @param leaveDays 请假天数
     */
    public abstract void leaveHandle(int leaveDays);

    /**
     * 传递给下一级
     * @param leaveDays 请假天数
     */
    public void transferToSuperior(int leaveDays){
        if (superior != null){
            superior.leaveHandle(leaveDays);
        } else {
            System.out.println("我" + position.getPositionName() + "已经没有上级了，不能审批了");
        }
    }
}
