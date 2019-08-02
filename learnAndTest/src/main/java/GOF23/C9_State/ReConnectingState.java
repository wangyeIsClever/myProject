package GOF23.C9_State;

public class ReConnectingState implements ConnectState {

    private ConnectMachine connectMachine;

    private boolean reConnectResult;

    public ReConnectingState(ConnectMachine connectMachine) {
        this.connectMachine = connectMachine;
    }

    /**
     * 重连 连接成功 就到成功处理，连接失败就到连接失败处理
     */
    @Override
    public void handleRequest(MyRequest myRequest) {
        this.reConnectResult = this.reConnect(myRequest);
        if (this.reConnectResult){
            connectMachine.connectSuccess(myRequest);
        } else {
            connectMachine.connectFailure(myRequest);
        }
    }

    /**
     * 如果请求没有必要需要方法 反true，否则反false
     */
    private boolean reConnect(MyRequest myRequest) {
        System.out.println("尝试重连。。。。。。");
        if (!myRequest.isMethodNessary()){
            return true;
        } else {
            return false;
        }
    }
}
