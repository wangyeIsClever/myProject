package GOF23.C6_ChainOfResponsibility;

public class ChainOfResponsibilityTest {


    public static void main(String[] args) {
        //创建boss
        AbstractProcessor boss = new Boss(null,Position.BOSS);
        //创建GeneralManager 总经理
        AbstractProcessor generalManager = new GeneralManager(boss,Position.GENERAL_MANAGER);
        //创建TeamLeader 组长
        AbstractProcessor teamLeader = new TeamLeader(generalManager,Position.TEAM_LEADER);
        // 创建Staff 员工
        AbstractProcessor staff = new Staff(teamLeader,Position.Staff);

        staff.leaveHandle(3);
    }
}
