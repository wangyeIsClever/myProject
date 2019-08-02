package GOF23.C9_State;

class InitState implements ConnectState{

    private ConnectMachine connectMachine;

    private boolean tryResult;

    public InitState(ConnectMachine connectMachine) {
        this.connectMachine = connectMachine;
    }

    @Override
    public void handleRequest(MyRequest myRequest) {
        tryConnect(myRequest);
    }

    /**
     * 初始化后，如果成功，就去连接，不成功就连接失败
     */
    private void tryConnect(MyRequest myRequest) {
        // 尝试去连接
        this.tryResult = this.tryToConnect(myRequest);
        if (this.tryResult) {
            this.connectMachine.goConnect(myRequest);
        } else {
            this.connectMachine.connectFailure(myRequest);
        }
    }

    /**
     * 初始化连接方法
     * 判断请求有没有url参数，有反true，无反false
     */
    private boolean tryToConnect(MyRequest myRequest){
        System.out.println("与"+ myRequest.getUrl() +"连接初始化。。。。。");
        if (myRequest.getUrl() != null){
            return true;
        }else{
            return false;
        }
    }
}
