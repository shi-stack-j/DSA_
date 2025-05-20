package BackTracking;
//Here we will se backtracking
//Rat int maze
public class Q_1 {
    static void printWays(int i, int j, int er, int ec, String way) {
        if (i > er || j > ec) return;
        if (i == er && j == ec) {
            System.out.println(way);
            return;
        }
        //Go Right
        printWays(i, j + 1, er, ec, way + "R");
        //Go Down
        printWays(i + 1, j, er, ec, way + "D");
    }

    static int TotalWays(int i, int j, int er, int ec) {
        if (er == i && ec == j) {
            return 0;
        }
        if (i == er  || j == ec ) {
            return 1;
        }
        int right = TotalWays(i, j + 1, er, ec);
        int down = TotalWays(i + 1, j, er, ec);
        return right + down;
    }
    static void printWaysFour(int i,int j,int er,int ec,String str,Boolean[][]arr){
        if(i>er||j>ec)return;
        if(i<0||j<0)return;
        if(arr[i][j]==true)return;
        if(i==er && j==ec){
            System.out.println(str);
            return;
        }
        arr[i][j]=true;
        //Right
        printWaysFour(i,j+1,er,ec,str+"R",arr);
        //Left
        printWaysFour(i,j-1,er,ec,str+"L",arr);
        //Up
        printWaysFour(i-1,j,er,ec,str+"U",arr);
        //Down
        printWaysFour(i+1,j,er,ec,str+"D",arr);
        //Backtracking
        arr[i][j]=false;
    }

    public static void main(String[] args) {
        int er = 2;
        int ec = 2;
        int i = 0;
        int j = 0;
        Boolean[][]arr={{false,false,false},{false,false,false},{false,false,false}};
        System.out.println("Total Ways :- " + TotalWays(i, j, er, ec));
        printWays(i, j, er, ec, "");
        printWaysFour(i,j,er,ec,"",arr);
    }
}
