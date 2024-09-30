package Algorithms.Recursion.Easy;

public class SumOfDigits {
    static int digitSum(int num){
        if(num/10 == 0){
            return num;
        }
        return (num%10)+digitSum(num/10);
    }

    public static void main(String[] args) {
        System.out.println(digitSum(123456));
    }
}
