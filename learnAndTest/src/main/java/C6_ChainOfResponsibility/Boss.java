package C6_ChainOfResponsibility;

/**
 * 老板BOSS
 */
public class Boss extends AbstractProcessor {

    Boss(AbstractProcessor superior, Position position) {
        super(superior, position);
    }

    @Override
    public void leaveHandle(int leaveDays) {
        if (leaveDays > 2){
            System.out.println("我 " + this.getPosition().getPositionName() +" 有权审批， 允许请假");
        } else {
            System.out.println("我 " + this.getPosition().getPositionName() +" 没有权限审批，已经递交给上一级 " + this.getSuperior().getPosition().getPositionName());
            this.transferToSuperior(leaveDays);
        }
    }
}
