package GOF23.C2_Template;

public abstract class AbstractCooking {

    /**
     * 洗菜
     */
    public abstract void wash();

    /**
     * 切菜
     */
    public abstract void cut();

    /**
     * 烹饪
     */
    public abstract void cook();

    /**
     * 装盘
     */
    public abstract void onPalte();

    /**
     * 这里定死做一道菜的步骤
     * 也就是定义算法框架,算法框架一般是定死的，不能被重写的，所以用final修饰
     */
    public final void makeFood(){
        this.wash();
        this.cut();
        this.cook();
        this.onPalte();
    }
}
