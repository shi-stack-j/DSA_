package RecurSion;
public class SudokuSolver {
    static void travler(int[][]arr,int r,String str,int m){
        if(r==arr.length){
            System.out.println(str);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[r][i]!=1) {
                arr[r][i]=m;
                travler(arr, r + 1, str + "Row - " + r + "| Col -" + i + "| ",m+1);
                //m=m-1;
            }else{
                travler(arr,r,str,m+1);
            }
        }
//        for(int i=1;i<5;i++){
//            if(arr[r][j]==i){
//
//            }
//        }
    }
    public static void main(String[]args){
        int[][]arr=new int[2][2];
        travler(arr,0,"",1);
        for(int[]i:arr){
            for(int j:i){
                System.out.println(j);
            }
        }
    }
}
