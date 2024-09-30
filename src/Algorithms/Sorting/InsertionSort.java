package Algorithms.Sorting;

import java.util.Arrays;

public class InsertionSort {


    static  void sort(int arr[]){
        for(int i = 1; i< arr.length;i++){
            for(int j  = i; j>0;j--){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {90,67,23,56,46,27,89,190,89763,34};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
