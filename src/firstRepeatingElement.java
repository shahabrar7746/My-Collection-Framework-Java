import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class firstRepeatingElement {
    public static void main(String[] args) {


        int arr[]= {
                -1,1,1,1,1};
      //  System.out.println(firstRepeated(arr,arr.length));
        System.out.println(firstNonRepeating(arr, arr.length));
    }
    static  public int firstNonRepeating(int arr[], int n)
    {
        // Complete the function

        List<Integer> list = new ArrayList<Integer> ();

        for(int num : arr){

            list.add(num);
        }

List<Integer> temp = new ArrayList<>(list);

        for(int i =0;i<n;i++){
            list.remove(i);

            if(!list.contains(arr[i])){
                return arr[i];
            }else{
               list = new ArrayList<>(temp);
            }

        }
        return 0;

    }

    static int remove_duplicate(int arr[],int N){
        // code here
        int s = 0;
        int f = 1;
        int minusIndex = 0;
        while(f < N){
            if(arr[s] == arr[f]){
                minusIndex++;
                arr[f] = -1;

            }else{
                s = f;

            }
            f++;
        }
        Arrays.sort(arr);
        int temp[] = new int[N];
        for(int i =0;i<N;i++){
            temp[i] = arr[i];
        }
        int index = 0;
        for(int i =0;i<N;i++){
            if(temp[i] != -1){
                arr[index] = temp[i];
                index++;
            }
        }
        return N-minusIndex;
    }
    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(arr[0]);
        list.add(arr[0]);
        for(int i =1;i<n;i++){
            int num = arr[i];
            if(queue.contains(num)){


                return list.indexOf(num);
            }
            queue.add(num);
            list.add(num);
        }

        return -1;

    }
}
