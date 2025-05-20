package RecurSion;
import java.util.Scanner;
//Here in this code we will calculate the sum of n natural number
//But the sum calculate with the alternate sign
//Give that number is greater than zero
//example->n=5;
//Sum->1-2+3-4+5;
//ans=3
public class Q_9 {
    static int altSignSum(int n){
        if(n<=0) return 0;
        int sum=altSignSum(n-1);
        if(n%2==0)return sum-n;
        else return sum+n;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number to find sum :- ");
        int n=sc.nextInt();
        System.out.println("The sum is :- "+altSignSum(n));
    }
}
