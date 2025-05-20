public class StairPath {
    static int path(int n){
        if(n<0)return 0;
        if(n==0)return 1;
        if(n==1|| n==2)return n;
        int sing=path(n-1);
        int doub=path(n-2);
        int thre=path(n-3);
        return sing+doub+thre;
    }
    static void PrintPath(int n,String str){
        if(n<0){
            return;
        }
        if(n==0){
            System.out.println(str);
            return;
        }
        PrintPath(n-1,str+1);
        PrintPath(n-2,str+2);
        PrintPath(n-3,str+3);
    }
    public static void main(String[] args) {
        int n=4;
        System.out.println("The number of ways are :- "+path(n));
        PrintPath(n,"");
    }
}
