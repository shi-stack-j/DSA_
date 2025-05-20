package RecurSion;
//N guest
public class Nguest {
    static int guest(int n){
        if(n<=1)return 1;
        int sing=guest(n-1);
        int doub=(n-1)*guest(n-2);
        return sing+doub;
    }
    public static void main(String[]args){
        int n=4;
        System.out.println(guest(n));
    }
}
