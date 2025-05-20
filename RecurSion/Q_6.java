package RecurSion;
//Printing x^n using recursuin in stackheight(long n)
public class Q_6 {
    public static int calPow(int i,int n){
        if(i==0) return 0;
        if(n==0) return 1;
        if(n%2==0){
            return calPow(i,n/2)*calPow(i,n/2);
        }else{
            return calPow(i,n/2)*calPow(i,n/2)*i;
        }
    }
    public static void main(String[]args){
        int i=2,n=5;
        System.out.println("Square in log n height is :- "+calPow(i,n));
    }
}
