package GOF23.C6_ChainOfResponsibility;

public enum Position {

    Staff(0,"员工"),
    TEAM_LEADER(1,"组长"),
    GENERAL_MANAGER(2,"总经理"),
    BOSS(3,"老板");

    private Integer positionLevel;// 职级

    private String positionName; // 职位名称

    Position(Integer positionLevel,String positionName){
        this.positionLevel = positionLevel;
        this.positionName = positionName;
    }

    public Integer getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(Integer positionLevel) {
        this.positionLevel = positionLevel;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
