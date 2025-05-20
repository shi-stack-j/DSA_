package RecurSion;
import java.util.Scanner;
//from here we are starting the array questions using recursion
public class Q_11 {
    static void printArr(int[] arr,int idx){
        if(idx==arr.length || idx<0 ){
            return;
        }
        System.out.print(arr[idx]+" ");
        printArr(arr,idx+1);
    }
    static void findMax(int[] arr,int idx,int max){
        if(idx==arr.length|| idx<0 ){
            System.out.println("\nMax is :- "+max);
            return;
        }
        if(arr[idx]>max){
            findMax(arr,idx+1,arr[idx]);
        }else{
            findMax(arr,idx+1,max);
        }
    }
    static int findMax2(int[] arr,int idx){
        if(idx==arr.length || idx<0 ){
            return arr[idx-1];
        }
        int max=findMax2(arr,idx+1);
        if(arr[idx]>max)return arr[idx];
        return max;
    }
    static int ArrSum(int[]arr,int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        return arr[idx]+ArrSum(arr,idx+1);
    }
    public static void main(String[]args){
        int idx=0;
        int[] arr={1,2,3,4,5,6};
        printArr(arr,idx);
//        findMax(arr,0,arr[0]);
        System.out.println("\nThe max using recursion :- "+findMax2(arr,idx));
        System.out.println("The sum of array elements is :- "+ArrSum(arr,idx));
    }
}
