package RecurSion;
import java.util.Scanner;
public class Q_3 {
    public static void fact(int i,int fact,int n){
        if(i==n || n<0){
            fact=i*fact;
            System.out.println("Factorial is :- "+fact);
            return;
        }
        fact(i+1,fact*i,n);
    }
    public static int fact2(int n){
        if(n==1 || n<0) return 1;
        return n*fact2(n-1);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number to find factorial :- ");
        int n=sc.nextInt();
        fact(1,1,n);
        System.out.println("Factroial using m2 :- "+fact2(n));
    }
}
