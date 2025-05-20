package RecurSion;
//Here we will se the m X n tiles code using recursion
public class NxMTiles {
    static int tiles(int n,int m){
        if(m==n)return 2;
        if(m>n)return 1;
        int hor=tiles(n-m,m);
        int ver=tiles(n-1,m);
        int tow=hor+ver;
        return tow;
    }
    public static void main(String[]args){
        int n=4,m=2;
        System.out.println(tiles(n,m));

    }
}
