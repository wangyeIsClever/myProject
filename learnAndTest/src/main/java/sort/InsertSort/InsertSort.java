package sort.InsertSort;

import java.util.HashMap;

public class InsertSort {

    public static void main(String[] args) {
        Integer [] arr = {76,99,23,1,12,55,10};
        System.out.print("原来的数组为：");
        for (Integer item : arr){
            System.out.print(item + ",");
        }
        System.out.println();
        Integer [] arr2 = insertSort(arr);

        System.out.print("插排后：");
        for (Integer item : arr2){
            System.out.print(item + ",");
        }
        System.out.println();
        HashMap hashMap = new HashMap();
    }

    public static <T extends Number> T[] insertSort(T[] array) {
        if (array == null || array.length < 2) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            T currentValue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j].doubleValue() > currentValue.doubleValue()) {
                    array[j + 1] = array[j];
                    position -= 1;
                } else {
                    break;
                }
            }
            array[position] = currentValue;
        }
        return array;
    }

}
