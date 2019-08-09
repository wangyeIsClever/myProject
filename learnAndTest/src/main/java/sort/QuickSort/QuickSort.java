package sort.QuickSort;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        Integer [] arr = {76,99,23,1,12,55,10};
        System.out.print("原来的数组为：");
        for (Integer item : arr){
            System.out.print(item + ",");
        }
        System.out.println();
        Integer [] arr2 = quickSort(arr,0,arr.length - 1);

        System.out.print("快排后：");
        for (Integer item : arr2){
            System.out.print(item + ",");
        }
        System.out.println();
    }


    public static <T extends Number> T[] quickSort(T [] arr,int lowIndex,int highIndex){
        int lo = lowIndex;
        int hi = highIndex;
        T mid;
        if(highIndex > lowIndex){
            mid = arr[(lowIndex + highIndex)/2];
            System.out.println("中间数组元素的值："+mid);
            while(lo <= hi){
                System.out.println("左指针" + lo + "小于右指针" + hi + "继续移动指针：");
                while((lo < highIndex) && (arr[lo].doubleValue() < mid.doubleValue())){
                    ++lo;
                }
                while ((hi > lowIndex) && (arr[hi]).doubleValue() > mid.doubleValue()){
                    --hi;
                }
                System.out.println("指针移动完：左指针lo:" + lo + " 右指针hi:" + hi);
                if(lo <= hi){
                    System.out.println("交换前指针指向元素当前的左指针lo：" + lo + " 当前的右指针hi：" + hi);
                    swap(arr,lo,hi);
                    System.out.print("交换排序完:");
                    for (T item : arr){
                        System.out.print(item + ",");
                    }
                    System.out.println();
                    ++lo;
                    --hi;
                    System.out.println("交换后++lo，--hi，lo：" + lo + " 当前的hi：" + hi);
                }
            }
            if (lowIndex < hi){
                System.out.println("开始左边排序：范围是数组下标" + lowIndex +"到数组下标" + hi);
                System.out.print("参与排序的元素：");
                for(int i = lowIndex ; i <= hi ; i ++){
                    System.out.print(arr[i] + ",");
                }
                System.out.println();
                quickSort(arr,lowIndex,hi);
            }
            if (lo < highIndex){
                System.out.println("开始右边排序：范围是数组下标" + lo +"到数组下标" + highIndex);
                System.out.print("参与排序的元素：");
                for(int i = lo ; i <= highIndex ; i ++){
                    System.out.print(arr[i] + ",");
                }
                System.out.println();
                quickSort(arr,lo,highIndex);
            }
        }

        return arr;
    }

    public static <T extends Number> void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
