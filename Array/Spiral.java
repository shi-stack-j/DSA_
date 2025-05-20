package Array;
import java.util.Scanner;
//Here we will print and traverse the array in Spiral order
public class Spiral {
    static void print(int[][]arr){
        for(int[] i:arr){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    static void pSpiral(int[][]arr,int r,int c){
        int sr=0;
        int sc=0;
        int er=r-1;
        int ec=c-1;
        int total=0;
        while(total!=r*c){
            for(int i=sc;i<=ec && total!=r*c;i++){
                System.out.print(arr[sr][i]+" ");
                total++;

            }
            sr=sr+1;
            for(int i=sr;i<=er && total!=r*c;i++){
                System.out.print(arr[i][ec]+" ");
                total++;

            }
            ec=ec-1;
            for(int i=ec;i>=sc && total!=r*c;i--){
                System.out.print(arr[er][i]+" ");
                total++;

            }
            er=er-1;
            for(int i=er;i>=sr && total!=r*c;i--){
                System.out.print(arr[i][sc]+" ");
                total++;

            }
            sc=sc+1;
        }
    }
    static void GenerateSpiral(int n){
        int[][] arr=new int[n][n];
        int sr=0;
        int sc=0;
        int er=n-1;
        int ec=n-1;
        int total=0;
        while(total!=n*n){
            for(int i=sc;i<=ec && total!=n*n;i++){
                arr[sr][i]=total+1;
                total++;
            }
            sr++;
            for(int i=sr;i<=er && total!=n*n;i++){
                arr[i][ec]=total+1;
                total++;
            }
            ec--;
            for(int i=ec;i>=sc && total!=n*n;i--){
                arr[er][i]=total+1;
                total++;
            }
            er--;
            for(int i=er;i>=sr && total!=n*n;i--){
                arr[i][sc]=total+1;
                total++;
            }
            sc++;
        }
        print(arr);
    }
    static void prefixSum(int[][]arr){
        System.out.println("Calculating Prefix Sum......");
        //Row sum
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=0;j<arr[i].length;j++){
                sum+=arr[i][j];
                arr[i][j]=sum;
            }
        }
        //Colum Sum
        for(int i=0;i<arr.length;i++){
            sum=0;
            for(int j=0;j<arr.length;j++){
                sum+=arr[j][i];
                arr[j][i]=sum;
            }
        }
    }
    static void sum3(int[][]arr,int sr,int sc,int er,int ec){
        int sum=0,left=0,up=0,lu=0;
        if(sc>0)
            left=arr[er][sc-1];
        if(sr>0)
            up=arr[sr-1][ec];
        if(sr>0 && sc>0)
            lu=arr[sr-1][sc-1];
        sum=arr[er][ec]+lu-left-up;
        System.out.println(sum);
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Number of rows :- ");
        int r=sc.nextInt();
        System.out.print("Enter Number of Columbs :- ");
        int c=sc.nextInt();
        int[][]arr=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print("Enter value of "+i+j+":- ");
                arr[i][j]=sc.nextInt();
            }
        }
        print(arr);
        pSpiral(arr,r,c);
    }
}
