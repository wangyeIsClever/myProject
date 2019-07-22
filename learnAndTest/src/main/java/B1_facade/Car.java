package B1_facade;

/**
 * 这个Car类就是一个门面封装
 * 他让car的调用者不需要知道car内部的结构，也不需要知道car是具体怎么运行的
 */
public class Car {

    private Engine engine;

    private Wheel wheel;

    Car(){
        this.engine = new Engine();
        this.wheel = new Wheel();
    }

    public void run(){
        this.engine.start();
        this.wheel.start();
    }

    public void stop(){
        this.engine.shutdown();
        this.wheel.shutdown();
    }
}
