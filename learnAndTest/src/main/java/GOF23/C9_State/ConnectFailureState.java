package GOF23.C9_State;

public class ConnectFailureState implements ConnectState {

    private ConnectMachine connectMachine;

    public ConnectFailureState(ConnectMachine connectMachine) {
        this.connectMachine = connectMachine;
    }

    @Override
    public void handleRequest(MyRequest myRequest) {
        this.connectFailure(myRequest);
    }

    private void connectFailure(MyRequest myRequest) {
        System.out.println(myRequest.getUrl() + "连接失败。。。");
    }
}
