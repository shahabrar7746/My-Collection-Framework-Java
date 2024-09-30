package Algorithms.Sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
static int[] MergeSort(int arr[]){
    if(arr.length == 1){
        return arr;
    }
    int start = 0;
    int end = arr.length;
    int mid = (start + end)/2;
    int left[] = MergeSort(Arrays.copyOfRange(arr,start,mid));
    int right[] = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));
    return merge(left,right);
}
static int[] merge(int left[],int right[]){
    int i= 0,j=0,k = 0;
    int arr[] = new int[left.length + right.length];
    while(i < left.length && j < right.length){
        if(left[i] < right[j]){
            arr[k] = left[i];
            i++;
        }else{
            arr[k] = right[j];
            j++;
        }
        k++;
    }
    while(i < left.length){
        arr[k] = left[i];
        k++;
                i++;
    }
    while(j < right.length){
        arr[k] = right[j];
        k++;
        j++;
    }

    return arr;
}

    public static void main(String[] args) {
        System.out.println(Arrays.toString(MergeSort(new int[]{90,56,78,24,78,9,15})));
    }
}
