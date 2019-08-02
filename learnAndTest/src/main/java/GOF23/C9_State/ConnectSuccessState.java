package GOF23.C9_State;

public class ConnectSuccessState implements ConnectState {

    private ConnectMachine connectMachine;

    private boolean handleResult;

    public ConnectSuccessState(ConnectMachine connectMachine) {
        this.connectMachine = connectMachine;
    }

    @Override
    public void handleRequest(MyRequest myRequest) {
        this.connectSuccessAndHandle(myRequest);
    }

    /**
     * 处理成功就断开连接
     */
    private void connectSuccessAndHandle(MyRequest myRequest) {
        this.handleResult = this.handle(myRequest);
        if (this.handleResult){
            connectMachine.disConnect(myRequest);
        }
    }

    /**
     * 处理请求 ，处理成功 反true 处理失败false
     */
    private boolean handle(MyRequest myRequest) {
        System.out.println(myRequest.getUrl() + " 连接成功了，正在处理。。。。");
        if (myRequest.getMethod() != null){
            System.out.println(myRequest.getMethod() + " 处理成功" );
        } else {
            System.out.println(" 处理成功" );
        }
        return true;
    }
}
