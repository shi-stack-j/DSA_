package RecurSion;
//Prorgram to calcuate x^n (Stack height=n)
public class Q_5 {
    public static int calPow(int i,int n){
        if(n==0)return 1;
        if(i==0) return 0;
        int pow=calPow(i,n-1);
        int calp=i*pow;
        return calp;
    }
    public static void main(String[]args){
        int x=2,n=5;
        System.out.println(calPow(x,n));

    }
}
