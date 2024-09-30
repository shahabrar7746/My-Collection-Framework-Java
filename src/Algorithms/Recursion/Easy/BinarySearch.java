package Algorithms.Recursion.Easy;

import java.util.Arrays;

public class BinarySearch {


    static  int search(int arr[],int start,int end,int target){
        if(start>end){
            return -1;
        }
        int mid = (start + end)/2;
        if(arr[mid] == target){
            return  mid;
        }
        if(arr[mid] < target){
            return search(arr,mid+1,end,target);
        }
        return search(arr,start,mid-1,target);
    }


    public static void main(String[] args) {
        int arr[] = {78,243,90,12,89,67,54,89,9,4,0};
        Arrays.sort(arr);
        System.out.println(LinearSearch.search(arr,0, 12));
    }
}
