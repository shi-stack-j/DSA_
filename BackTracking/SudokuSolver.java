package BackTracking;
public class SudokuSolver {
    static void printArr(int[][]arr){
        for(int i=0;i< arr.length;i++){
            for(int j=0;j< arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean isSafe(int[][]arr,int r,int c,int n){
        //Checking in row and column
        for(int i=0;i< arr.length;i++){
            if(arr[r][i]==n){
                return false;
            }if(arr[i][c]==n){
                return false;
            }
        }
        //Checking In 3X3 matrix
        int sr=(r/3)*3;
        int sc=(c/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(arr[i][j]==n){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean soduku(int[][]arr,int r,int c){
        if(r==arr.length){
            printArr(arr);
            return true;
        }
        int nr=0;
        int nc=0;
        if(c!=arr.length-1){
            nr=r;
            nc=c+1;
        }else{
            nr=r+1;
            nc=0;
        }
        if(arr[r][c]!=0){
            if(soduku(arr,nr,nc)){
                return true;
            }
        }else{
            for(int i=1;i<10;i++){
                if(isSafe(arr,r,c,i)) {
                    arr[r][c] = i;
                    if (soduku(arr, nr, nc)) {
                        return true;
                    } else {
                        arr[r][c] = 0;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[]args){
        int[][] arr={{5,3,0,0,7,0,0,0,0},
                     {6,0,0,1,9,5,0,0,0},
                     {0,9,8,0,0,0,0,6,0},
                     {8,0,0,0,6,0,0,0,3},
                     {4,0,0,8,0,3,0,0,1},
                     {7,0,0,0,2,0,0,0,6},
                     {0,6,0,0,0,0,2,8,0},
                     {0,0,0,4,1,9,0,0,5},
                     {0,0,0,0,8,0,0,7,9}};
        int r=0;
        int c=0;
        System.out.println(soduku(arr,r,c));
    }
}

