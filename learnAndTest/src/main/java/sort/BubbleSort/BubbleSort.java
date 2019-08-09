package sort.BubbleSort;

public class BubbleSort {

    public static void main(String[] args) {
        Integer [] arr = {76,99,23,45,12,55,10};
        Integer [] arr2 = bubbleSort(arr);
        for (Integer item : arr2){
            System.out.print(item + ",");
        }
    }

    public static <T extends Number> T[] bubbleSort(T [] arr){
        for (int i = 0; i < arr.length ; i++){
            for(int j = 0; j < arr.length -1; j++ ){
                if (arr[j].doubleValue() > arr[j + 1].doubleValue()){
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static <T extends Number> T[] quickSort(T [] arr){
        for (int i = 0; i < arr.length ; i++){
            for(int j = i + 1; j < arr.length; j++ ){
                if (arr[i].doubleValue() > arr[j].doubleValue()){
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
