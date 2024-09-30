package Algorithms.Sorting;

import java.util.Arrays;

public class CycleSort {

    /*
    Cycle sort sorts the arrays which ranging from 1 to n or 0 to n-1;
    worst case time complexity = O(n * log n)
    best case time complexity = O(N)
     */


    static void doTheSort(int arr[]){
        int i =0;
        while(i < arr.length){
            int crt = arr[i]-1;
            if(arr[i] != arr[crt] && arr[i] < arr.length){
                int temp = arr[i];
                arr[i] = arr[crt];
                arr[crt] = temp;
            }else{
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,5,9,4,2,7,6,8,3,1};
        doTheSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
