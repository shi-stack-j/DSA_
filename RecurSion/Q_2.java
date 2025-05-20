package RecurSion;

import java.util.Scanner;

public class Q_2 {
    public static int sum(int n){
        if(n==0) return 0;
        int l=sum(n-1);
        return n+l;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Value of n :- ");
        int n=sc.nextInt();
        System.out.println("The sum of first n is :- "+sum(n));
    }
}
