package C4_Iterator;

public class ItteratorTest {

    public static void main(String[] args) {
        MyContainer container = new MyContianerImpl(8);

        container.addElement(0);
        container.addElement(1);
        container.addElement(2);
        container.addElement(3);
        container.addElement(4);
        container.addElement(5);
        container.addElement(6);
        container.addElement(7);

        container.addElement(8); // 这个元素加不进去

        MyIterator iterator = container.getIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }
}
