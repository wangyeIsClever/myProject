package B2_Adapter;

public class Adapter extends Adaptee implements Target {

    private Target target;

    Adapter(){
        this.target = new TargetImpl();
    }

    @Override
    public void method1() {
       this.target.method1();
    }


}
