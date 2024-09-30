package Algorithms.Searching;

public class LinearSearch {




    /*
    Linear saerch requires O(n) time complexity for worst case and for best it is O(1);
    recommended to use for unsorted arrays.
     */
    static  int linearSearch(int arr[],int n, int target){
        for(int i =0;i<n;i++){
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {89,28,89,162,45,19,10,28};
        System.out.println((linearSearch(arr, arr.length,10)));
    }
}

