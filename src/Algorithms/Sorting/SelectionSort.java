package Algorithms.Sorting;

import java.util.Arrays;

public class SelectionSort {



    static  void sort(int arr[]){

        int index = arr.length-1;

        for(int i =0;i< arr.length;i++){
            int max = 0;
            int lastIndex = 0;
            for(int j = 0;j< arr.length - i ;j++){
                if(max < arr[j]){
                    max = arr[j];
                    lastIndex = j;
                }
            }
            int temp = arr[index - i];
            arr[index - i] = max;
            arr[lastIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {90,67,23,56,46,27,89,190,89763,34};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
