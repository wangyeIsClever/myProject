package GOF23.B3_decorator;

public class DecoratorTest {


    public static void main(String[] args) {
        // 当人没有进化成超人的时候
        Human man = new Man();
        man.run();

        // 把人进化装饰成超人
        SuperMan superMan = new SuperMan(man);
        //进化成超人的人，就能速度达到就能飞
        superMan.run();
    }



}
