//import DataStructures.LinkedList.LinkedList;

import javax.xml.transform.Result;
import java.util.*;


import DataStructures.Trees.Tree;

public class Main {
    static int ChocolateProblem(ArrayList<Integer> arr,int n,int m){
        int min = 0;
        Collections.sort(arr);
        int i =0;
        while( i+m < n){
           int start = arr.get(i);
           int end = arr.get((i+m)-1);
           if(min > (end - start)){
               min = end - start;
           }
            i++;
        }
        return min;
    }
    public static void main(String[] args) throws Exception {

        ArrayList<Integer>
         chocolates = new ArrayList<>();
        chocolates.add(3);
        chocolates.add(4);
        chocolates.add(1);
        chocolates.add(9);
        chocolates.add(56);
        chocolates.add(7);
        chocolates.add(9);
        chocolates.add(12);
        System.out.println(ChocolateProblem(chocolates, chocolates.size(), 5));


        System.out.println("Running test cases.....");
        ArrayList<String> fail = new ArrayList<>();
        ArrayList<String> pass = new ArrayList<>();
        Random rand = new Random();
        int testCases = 1;
        while(testCases != 10){
            System.out.println("running testcase number : " + testCases);
            ArrayList<Integer> list = new ArrayList<>();
            DataStructures.LinkedList.LinkedList2D List = new DataStructures.LinkedList.LinkedList2D(rand.nextInt(1,10));
             int end = rand.nextInt(10,90);
            for(int i =1;i<=40;i++){
                int num = rand.nextInt(0,200);
                list.add(num);
                List.add(num);

            }
            int from = list.get( rand.nextInt(0,list.size()-1));
            int to =  list.get( rand.nextInt(0,list.size()-1));
         List.print();
            String shortestStr = List.findShortestPathFrom(from,to);
            System.out.println("Shortest Path finished");
            String efficientStr = List.findMostEfficientPath(from,to);
            System.out.println("Efficient Path finished");
            if(shortestStr.length() == efficientStr.length()){
                pass.add("Shortest path : - " + shortestStr + " Efficient Path : - " + efficientStr );
            }else{
                fail.add("Shortest path : - " + shortestStr + " Efficient Path : - " + efficientStr );
            }
            testCases++;

        }
        System.out.println("All the testcases completed below are the results");
        System.out.println("Accuracy of code : " + String.valueOf((pass.size()/10) * 100) + "%");
        System.out.println("number of passed case : " + pass.size());
        System.out.println("number of failed cases : " + fail.size());
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("passed cases : "+ pass);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("failed cases :" + fail);

    }
   static void rearrange(int arr[], int n) {
        // code here
  HashSet<Integer> set = new HashSet<>();
 Iterator<Integer> iterator=  set.iterator();
 while(iterator.hasNext()){
     int num = iterator.next();
 }

       Queue<Integer> positiveQueue = new ArrayDeque<>();
       Queue<Integer> negativeQueue = new ArrayDeque<>();

       for(int num : arr){
           if(num >= 0){
               positiveQueue.add(num);
           }else{
               negativeQueue.add(num);
           }
       }
     arr = new int[n];
       int index = 0;

       while(index < n && !positiveQueue.isEmpty()){


           arr[index] = positiveQueue.poll();

           System.out.println("index -> " + index + " " + Arrays.toString(arr));
           index += 2;
       }
       if(!positiveQueue.isEmpty()){
         arr[index-1] = positiveQueue.poll();
       }
       System.out.println(positiveQueue);


       System.out.println(Arrays.toString(arr));


       index = 1;

       while(index < n && !negativeQueue.isEmpty()){
           arr[index] = negativeQueue.poll();
           System.out.println("index -> " + index + " " + Arrays.toString(arr));


           index += 2;
       }



    }
    static int majorityElement(int a[], int size)
    {
        // your code here

        Arrays.sort(a);

        int count = 1;
        for(int i =0;i+1<size;i++){
            if(a[i] != a[i+1]){
                if(count > size/2){
                    return a[i];
                }

                count = 1;
            }else{
                count++;
            }
        }
        if(a[size-2] != a[size-1]){
            if(count > size/2){
                return a[size-2];
            }
        }else{
            if(count > size/2){
                return a[size-1];
            }
        }
        return -1;
    }

    public static String ABCheck(String str) {
        // code goes here
        String ans = "false";
        for(int i =0;i+5<str.length();i++){
            String ref = "";
            for(int j = i;j<i+5;j++){
                ref = ref + str.charAt(j);
            }
            if(ref.charAt(0) == 'a' && ref.charAt(ref.length()-1) == 'b'){
                ref =  ref.substring(1,ref.length()-1);
                if(!(ref.contains("a") || ref.contains("b"))){
                    return "true";
                }

            }
        }

        return "false";
    }
     static int getPairsCount(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
         System.out.println(Arrays.toString(arr));
        int count =0;
        for(int i = 0;i<n;i++){
            int diff = k - arr[i];
            System.out.println("diff -> " + diff);
            boolean condition = binarySearch(arr,n,i,diff);
            System.out.println("condition -> " + condition);
            if(condition){
                count++;
            }
        }
        return count;

    }

   static boolean binarySearch(int arr[],int n,int presentIndex,int target){

        int mid = 0;
        int start =0;
        int end = n;
        while(start <= end){
            mid = (start + end)/2;
            System.out.println("mid -> "  + mid);
            if(arr[mid] == target){
                return true;
            }
            if(arr[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;

            }
        }
        return false;
    }
}