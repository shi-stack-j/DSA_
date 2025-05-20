package RecurSion;
import java.util.Scanner;
//Print the numbers from 1 to 5 using recursion
public class Q_1 {
    public static void PrintNum(int n){
        if(n==0)return;
        PrintNum(n-1);
        System.out.println(n);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value of n:- ");
        int n=sc.nextInt();
        PrintNum(n);
    }
}
