package B2_Adapter;

public class AdapterTest {


    public static void main(String[] args) {
        // 假设没有适配器 TargetImpl 和 Adaptee 是毫无关联的两个类，他们的方法是不能使用同一个对象来调用的
        Adaptee adaptee = new Adaptee();
        adaptee.method2(); // adaptee只能调用menthod2

        // 但是有了适配器，argetImpl 和 Adaptee 就能产生关联，他们的方法都能用同一个类的对象调用
        Adapter adapter = new Adapter();
        // 适配器中能调用它连接的两个对象的所有方法
        adapter.method1();
        adapter.method2();



    }
}
