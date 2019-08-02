package GOF23.B3_decorator;


/**
 * 装饰类，可以把人进化为超人，然后增强run方法
 */
public class SuperMan implements Human {

    private Human human;


    SuperMan(Human human){
        this.human = human;
    }

    private void fly(){
        System.out.println("走的速度达到了就能飞了");
    }

    @Override
    public void run() {
        this.human.run();
        this.fly();
    }
}
