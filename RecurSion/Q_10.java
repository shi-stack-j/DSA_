package RecurSion;
import java.util.Scanner;
//We are finding its solution using gcd mathematical methods
//We are using the longDivision method to find the GCD
//GCD->Greatest Comman Deviser
public class Q_10 {
    //Euclids Algorithm ->
    //gcd(x,y)=gcd(y,x%y);
    //gcd(x,0)=x;
    static int gcd(int x,int y){
        if(y==0)return x;
        return gcd(y,x%y);
    }
    //This is itreative approch using loops and long Division method
    static int iGcd(int x,int y){
        while(x%y!=0){
            int rem=x%y;
            x=y;
            y=rem;
        }
        return y;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter value of x :- ");
        int x=sc.nextInt();
        System.out.print("Enter value of y :- ");
        int y=sc.nextInt();
        System.out.println("GCD is :- "+gcd(x,y));
        System.out.println("GCD is :- "+iGcd(x,y));
    }
}
