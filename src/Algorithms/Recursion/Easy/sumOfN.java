package Algorithms.Recursion.Easy;

public class sumOfN {
    static int sum(int num){
        if(num == 1){
            return num;
        }

        return num+sum(num-1);
    }


    public static void main(String[] args) {
        int num = 123456789;


    }

}
