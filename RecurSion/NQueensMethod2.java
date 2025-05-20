package RecurSion;
public class NQueensMethod2 {
    static void Nqueens(int[]dr,int[]dl,int[]c,int r,String str,int[][]arr){
        if(r==arr.length){
            System.out.println(str);
            return;
        }
        for(int col=0;col<arr.length;col++){
            if(dr[r-col+ arr.length-1]!=1 && dl[r+col]!=1 && c[col]!=1 && arr[r][col]!=1) {
                dl[r + col] = 1;//  /
                dr[r - col + arr.length - 1] = 1;
                c[col] = 1;
                arr[r][col] = 1;
                Nqueens(dr, dl, c, r + 1, str + r + "-" + col + ".", arr);
                dl[r + col] = 0;//  /
                dr[r - col + arr.length - 1] = 0;
                c[col] = 0;
                arr[r][col] = 0;
            }
        }

    }
    public static void main(String[]args){
        int[][]arr=new int[4][4];
        int[]c=new int[arr.length];
        int[]dl=new int[2*(arr.length)-1];
        int[]dr=new int[dl.length];
        String str="";
        int r=0;
        Nqueens(dr,dl,c,r,str,arr);
    }
}
