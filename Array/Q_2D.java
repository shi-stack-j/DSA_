package Array;
public class Q_2D {
    static void print(int[][]arr){
        System.out.println("Printing the matrix.....");
        for (int[] i : arr) {
            for (int j:i) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
    }
    static void printTranspose(int[][]arr){
        System.out.println("Doing transpose of matrix....");
        for(int i=0;i<arr.length;i++){
            for(int j=i;j< arr.length;j++){
                if(i!=j){
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }
        }
    }
    public static void main(String[]args){
        int[][]arr={{1,2,3},{4,5,6},{7,8,9}};
        print(arr);
        System.out.println("Transpose...");
        printTranspose(arr);
        print(arr);
    }
}
