package C9_State;

public class ConnectingState implements ConnectState {

    private ConnectMachine connectMachine;

    private boolean connectResult;

    public ConnectingState(ConnectMachine connectMachine) {
        this.connectMachine = connectMachine;
    }

    @Override
    public void handleRequest(MyRequest myRequest) {
        this.goConnect(myRequest);
    }

    /**
     * 连接方法， 连接成功就去成功处理，连接不成功就尝试重连
     */
    private void goConnect(MyRequest myRequest) {
        this.connectResult = this.goToConnect(myRequest);
        if (this.connectResult){
            this.connectMachine.connectSuccess(myRequest);
        }else{
            this.connectMachine.reConnect(myRequest);
        }
    }

    /**
     *  判断请求有没有方法，如果有true，没有就false
     */
    private boolean goToConnect(MyRequest myRequest) {
        System.out.println("正在连接。。。。。");
        if (myRequest.getMethod() != null){
            return true;
        } else{
            return false;
        }
    }
}
