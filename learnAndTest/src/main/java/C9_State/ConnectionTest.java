package C9_State;

public class ConnectionTest {

    public static void main(String[] args) {
        ConnectMachine machine = new ConnectMachine();

        MyRequest request = new MyRequest("www.baidu.com","search food",true);

        machine.tryConnect(request);
    }

}




