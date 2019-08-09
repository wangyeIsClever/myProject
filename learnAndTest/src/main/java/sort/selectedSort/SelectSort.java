package sort.selectedSort;



public class SelectSort {

    public static void main(String[] args) {
        Integer [] arr = {76,99,23,45,12,55,10};
        Integer [] arr2 = selectSort(arr);
        for (Integer item : arr2){
            System.out.print(item + ",");
        }
    }

    public static <T extends Number> T[] selectSort(T [] arr){
        for (int i = 0; i < arr.length ; i++){
            int index = 0 ;
            for(int j = 0; j < arr.length - i; j++ ){
                if (arr[index].doubleValue() < arr[j].doubleValue()){
                    index = j;
                }
            }
            int swapIndex = arr.length - i - 1;
            T temp = arr[swapIndex];
            arr[swapIndex] = arr[index];
            arr[index] = temp;
            System.out.println("");
        }
        return arr;
    }

}
