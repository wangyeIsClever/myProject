package C9_State;

public class DisconnectState implements ConnectState {

    private ConnectMachine connectMachine;

    public DisconnectState(ConnectMachine connectMachine) {
        this.connectMachine = connectMachine;
    }

    @Override
    public void handleRequest(MyRequest myRequest) {
        this.disConnect(myRequest);
    }

    /**
     * 断开连接
     */
    private void disConnect(MyRequest myRequest) {
        System.out.println("已经断开与" + myRequest.getUrl() + "连接");
    }
}
