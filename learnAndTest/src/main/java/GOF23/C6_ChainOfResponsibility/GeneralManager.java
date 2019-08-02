package GOF23.C6_ChainOfResponsibility;

/**
 * 总经理
 */
public class GeneralManager extends AbstractProcessor {


    GeneralManager(AbstractProcessor superior, Position position) {
        super(superior, position);
    }

    @Override
    public void leaveHandle(int leaveDays) {
        if (leaveDays > 1 && leaveDays <= 2){
            System.out.println("我 " + this.getPosition().getPositionName() +" 有权审批， 允许请假");
        }else {
            System.out.println("我 " + this.getPosition().getPositionName() +" 没有权限审批，已经递交给上一级 " + this.getSuperior().getPosition().getPositionName());
            this.transferToSuperior(leaveDays);
        }
    }
}
