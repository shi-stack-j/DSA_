package RecurSion;
public class laxical {
    static void laxical(int i,int n){
        if(i>n){
            return;
        }
        System.out.println(i);
        for(int j=0;j<10;j++){
            laxical(10*i+j,n);
        }
    }
    public static void main(String[] args) {
        for(int i=1;i<10;i++){
            laxical(i,1000);
        }
    }
}
