package RecurSion;
import java.util.Scanner;
public class Q_4 {
    public static void PriFibo(int a,int b,int n){
        if(n==0 || n<0) return;
        int c=a+b;
        System.out.println(c);
        PriFibo(b,c,n-1);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter nth term of  Fibonacci series :- ");
        int n=sc.nextInt();
        System.out.println(0+"\n"+1);
        PriFibo(0,1,n-2);
    }
}
