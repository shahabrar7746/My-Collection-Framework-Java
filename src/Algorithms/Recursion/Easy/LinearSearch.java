package Algorithms.Recursion.Easy;

public class LinearSearch {
    static int search(int arr[],int i,int target) {
        if (i >= arr.length) {
            return -1;
        }
        if(arr[i] == target){
            return i;
        }
        return search(arr,i+1,target);

    }
}
