import java.util.Scanner;
//Here in this program we will calculate n multiples of any number using recursion
public class Q_8 {
    static void PriMulti(int x,int n){
        if(n==1){
            System.out.print(x+" ");
            return;
        }
        PriMulti(x,n-1);
        System.out.print(x*n+" ");
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number to find n multiples :- ");
        int x=sc.nextInt();
        System.out.print("Enter How many multiples you want :- ");
        int n=sc.nextInt();
        System.out.println("The n multiples of k are :- ");
        PriMulti(x,n);
    }
}
