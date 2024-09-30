package Algorithms.Searching;

public class BinarySearch
{

    /*
    Binary saerch requires O(log n) time complexity for worst case and for best it is O(1);
    recommended to use for sorted and unique elemental arrays.
     */
    static int binarySearch(int arr[],int n ,int target){
        int start =0;
        int end = n-1;
        while(start<=end){
            int mid = (start + end) /2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                start = mid +1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
}
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println((binarySearch(arr, arr.length,1)));
    }
}

