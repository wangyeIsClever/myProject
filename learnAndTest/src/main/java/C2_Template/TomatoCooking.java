package C2_Template;

import B5_composite.AbstractFile;

public class TomatoCooking extends AbstractCooking {
    @Override
    public void wash() {
        System.out.println("洗番茄");
    }

    @Override
    public void cut() {
        System.out.println("切番茄");
    }

    @Override
    public void cook() {
        System.out.println("煮番茄");
    }

    @Override
    public void onPalte() {
        System.out.println("番茄装盘");
    }
}
