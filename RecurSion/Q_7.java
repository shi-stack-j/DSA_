package RecurSion;
import java.util.Scanner;
//  5/10->0   5%10=5
public class Q_7 {
    static int NumDigits(int n){
        //I have used three methods below to find number of digits
        //Method ->1
//        if(n==0) {
//            System.out.println("Number of digits are :- "+(sum));
//            return ;
//        }
//        NumDigits(n/10,sum+1);
        //Method ->2
//        if(n==0)return 0;
//        int s=1;
//        return s+NumDigits(n/10);
        //Method -> 3
        if(n==0)return 0;
        return 1+NumDigits(n/10);
    }
    static int digSum(int n){
        if(n==0)return 0;
        return (digSum(n/10)+n%10);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number to find Sum of its Digit :- ");
        int n=sc.nextInt();
        System.out.println("Sum of digits of "+n+" is :- "+digSum(n));
        System.out.println("Number of digits of "+n+" are :- "+NumDigits(n));
    }
}
