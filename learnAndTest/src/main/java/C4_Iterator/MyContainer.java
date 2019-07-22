package C4_Iterator;

public interface MyContainer {

    void addElement(Object element);

    void removeElement(Object element);

    int getSize();

    MyIterator getIterator();
}
