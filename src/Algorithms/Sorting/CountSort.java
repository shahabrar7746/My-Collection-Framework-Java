package Algorithms.Sorting;

import java.util.Arrays;

public class CountSort {



    static  void CountSort(int arr[]){
        int max = getMax(arr);
        int newArr[] = new int[max+1];
        for(int num : arr){
            newArr[num]++;
        }
        int index = 0;
        for(int i =0;i<newArr.length;i++){
            int val = newArr[i];
            for(int j =0;j<val;j++){
                arr[index] = i;
                index++;
            }
        }
    }
    static int getMax(int arr[]){
        int max =0;
        for(int i =0;i< arr.length;i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {90,67,23,56,46,27,89,34};
        CountSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
