package Array;
import java.util.Scanner;
public class Q_3 {
    static void print(int[]arr){
        for(int i=1;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //To calculate the prefix sum of an array
    static void prefixSum(int[]arr){
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i]+arr[i-1];
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[]arr={0,2,4,1,3,6};
        print(arr);
        System.out.print("Enter Value of l :- ");
        int l=sc.nextInt();
        System.out.print("Enter value of S :- ");
        int s=sc.nextInt();
        prefixSum(arr);
        System.out.println("The sum from l :- "+l+" to S :- "+s+" = "+(arr[s]-arr[l-1]));
        print(arr);


    }
}
