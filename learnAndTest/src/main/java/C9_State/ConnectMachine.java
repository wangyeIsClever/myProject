package C9_State;

public class ConnectMachine {

    private ConnectState initState;
    private ConnectState connectingState;
    private ConnectState reconnectState;
    private ConnectState disConnectState;
    private ConnectState connectSuccessState;
    private ConnectState connectFailureState;

    public ConnectMachine() {
        initState = new InitState(this);
        connectingState = new ConnectingState(this);
        reconnectState = new ReConnectingState(this);
        disConnectState = new DisconnectState(this);
        connectSuccessState = new ConnectSuccessState(this);
        connectFailureState = new ConnectFailureState(this);
    }

    public void tryConnect(MyRequest myRequest) {
        initState.handleRequest(myRequest);
    }

    public void goConnect(MyRequest myRequest) {
        connectingState.handleRequest(myRequest);
    }

    public void reConnect(MyRequest myRequest) {
        reconnectState.handleRequest(myRequest);
    }

    public void disConnect(MyRequest myRequest) {
        disConnectState.handleRequest(myRequest);
    }

    public void connectSuccess(MyRequest myRequest) {
        connectSuccessState.handleRequest(myRequest);
    }

    public void connectFailure(MyRequest myRequest) {
        connectFailureState.handleRequest(myRequest);
    }

}
