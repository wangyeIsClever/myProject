package C2_Template;

public class TemplateTest {
    public static void main(String[] args) {
        AbstractCooking meatCooking = new MeatCooking();
        meatCooking.makeFood();
        System.out.println();
        AbstractCooking tomatoCooking = new TomatoCooking();
        tomatoCooking.makeFood();
    }
}
