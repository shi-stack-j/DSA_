package RecurSion;
//Ghode Ko 5X5 ke 2D array me ghumana hai aise ke woh array me ghum le
public class KnightTours {
    static void printArr(int[][]arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
    static void KnightTour(int[][]arr,int r,int c,int move){
        if(r>=arr.length||c>=arr.length || r<0 || c<0 ||arr[r][c]>0 ){
            return;
        }else if(move==arr.length*arr.length){
            arr[r][c]=move;
            printArr(arr);
            System.out.println("\n----------------");
            arr[r][c]=0;
            return;
        }
        //Marking Step
        arr[r][c]=move;
        //UP Right
        KnightTour(arr,r-2,c+1,move+1);
        //Right Up
        KnightTour(arr,r-1,c+2,move+1);
        //Right Down
        KnightTour(arr,r+1,c+2,move+1);
        //Down Right
        KnightTour(arr,r+2,c+1,move+1);
        //Down Left
        KnightTour(arr,r+2,c-1,move+1);
        //Left Down
        KnightTour(arr,r+1,c-2,move+1);
        //Left Up
        KnightTour(arr,r-1,c-2,move+1);
        //Up Left
        KnightTour(arr,r-2,c-1,move+1);
        //BackTracking
        arr[r][c]=0;
    }
    public static void main(String[]args){
        int[][]arr=new int[5][5];
        KnightTour(arr,0,0,1);
    }
}
/*
    static void printArr(int[][]arr){
        // for(int[]i:arr){
        //     for(int j:i){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void KnightTour(int[][]arr,int r,int c,int move){
        if(r>=arr.length||c>=arr.length || r<0 || c<0 ||arr[r][c]>0 ){
            return;
        }else if(move==arr.length*arr.length){
            arr[r][c]=move;
            printArr(arr);
            System.out.println("\n----------------");
            arr[r][c]=0;
            return;
        }
        //Marking Step
        arr[r][c]=move;
        //UP Right
        KnightTour(arr,r-2,c+1,move+1);
        //Right Up
        KnightTour(arr,r-1,c+2,move+1);
        //Right Down
        KnightTour(arr,r+1,c+2,move+1);
        //Down Right
        KnightTour(arr,r+2,c+1,move+1);
        //Down Left
        KnightTour(arr,r+2,c-1,move+1);
        //Left Down
        KnightTour(arr,r+1,c-2,move+1);
        //Left Up
        KnightTour(arr,r-1,c-2,move+1);
        //Up Left
        KnightTour(arr,r-2,c-1,move+1);
        //BackTracking
        arr[r][c]=0;
    }
    public static void main(String[] args) {
        int[][]arr=new int[5][5];
        KnightTour(arr,0,0,1);
    }
}
 */
