package Algorithms.Sorting;

import java.util.Arrays;

public class BubbleSort {

    static  void sort(int arr[]){

        boolean isSorted = true;
        for(int i =0;i< arr.length;i++){
            for(int j = 0 ;j+1< arr.length-i;j++){
                if(arr[j] > arr[j+1]){
                    //swap elements
                    isSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(isSorted){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {90,67,23,56,46,27,89,190,89763,34};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
