package BackTracking;
//Here also we will se the rat in a maze question but now the maze give
//And some of the columns of the maze is blocked
public class RatInDadMaze {
    static void printPathLR(int sr,int sc,int er,int ec,String str,int[][] maze){
        if(sr>er||sc>ec)return;
        if(maze[sr][sc]==0)return;
        if(sr==er && sc==ec){
            System.out.println(str);
            return;
        }
        //Right
        printPathLR(sr,sc+1,er,ec,str+"R",maze);
        //Down
        printPathLR(sr+1,sc,er,ec,str+"D",maze);
    }
    static void printPathLRUD(int sr,int sc,int er,int ec,String st,int[][]maze){
        if(sr>er||sc>ec)return;
        if(sr<0||sc<0)return;

        if(er==sr && ec==sc){
            System.out.println(st);
            return;
        }
        if(maze[sr][sc]==0 || maze[sr][sc]==-1){
            return;
        }
        maze[sr][sc]=-1;
        //Right
        printPathLRUD(sr,sc+1,er,ec,st+"R",maze);
        //Down
        printPathLRUD(sr+1,sc,er,ec,st+"D",maze);
        //Left
        printPathLRUD(sr,sc-1,er,ec,st+"L",maze);
        //Up
        printPathLRUD(sr-1,sc,er,ec,st+"U",maze);
        //Backtracking
        maze[sr][sc]=1;
    }
    public static void main(String[]args){
        int rows=3;
        int cols=4;
        int[][]maze={{1,0,1,1},
                      {1,1,1,1},
                      {1,1,0,1}};
        System.out.println("Maze R D ");
        printPathLR(0,0,rows-1,cols-1,"",maze);
        System.out.println("Maze L R U D ");
        printPathLRUD(0,0,rows-1,cols-1,"",maze);
    }
}
