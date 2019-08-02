package GOF23.C5_visitor;

public interface Viewer {

    void view(IncomeBill incomeBill);

    void view(ComsumeBill comsumeBill);
}
