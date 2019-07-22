package C4_Iterator;

public class MyContianerImpl implements MyContainer {

    private Object [] elements;

    private int size = 0;

    private int currentSite = 0;


    MyContianerImpl(int initSize){
        elements = new Object[initSize];
    }

    @Override
    public void addElement(Object element) {
        if (elements.length <= currentSite){
            System.out.println("集合已经满了，您要加的元素没有加进去");
        }else {
            this.elements[currentSite] = element;
            this.currentSite++;
            this.size++;
        }
    }

    @Override
    public void removeElement(Object element) {
        int index = -1;
        for (int i = 0 ; i < size ; i++ ){
            Object item = this.elements[i];
            if (item.equals(element)){
                index = i;
                break;
            }
        }
        if (index != -1){
            for (int j = index; j < currentSite -1; j++){
                elements[j] = elements[j+1];
            }
            this.elements[currentSite-1] = null;
            currentSite--;
            size--;
        } else {
            System.out.println("集合中没有该元素，未删除任何元素");
        }

    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public MyIterator getIterator() {
        return new MyIteratorImpl();
    }

    private class MyIteratorImpl implements MyIterator {

        int index = 0;

        @Override
        public boolean hasNext() {
            if (this.index < currentSite){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (index < currentSite){
                return elements[index++];
            } else {
                throw new RuntimeException("集合越界了");
            }

        }
    }

}
