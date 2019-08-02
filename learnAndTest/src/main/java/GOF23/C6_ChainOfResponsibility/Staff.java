package GOF23.C6_ChainOfResponsibility;

/**
 * 底层员工
 */
public class Staff extends AbstractProcessor {

    Staff(AbstractProcessor superior, Position position) {
        super(superior, position);
    }

    @Override
    public void leaveHandle(int leaveDays) {
        System.out.println("我 " + this.getPosition().getPositionName() +" 不能擅自缺席，请假申请已经递交给上一级 " + this.getSuperior().getPosition().getPositionName());
        this.transferToSuperior(leaveDays);
    }
}
