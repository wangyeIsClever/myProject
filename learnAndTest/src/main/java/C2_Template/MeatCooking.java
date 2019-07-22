package C2_Template;

public class MeatCooking extends AbstractCooking {
    @Override
    public void wash() {
        System.out.println("洗肉");
    }

    @Override
    public void cut() {
        System.out.println("切肉");
    }

    @Override
    public void cook() {
        System.out.println("炒肉");
    }

    @Override
    public void onPalte() {
        System.out.println("肉装盘");
    }
}
