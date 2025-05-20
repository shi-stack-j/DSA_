package RecurSion;
//Here will solve the frog jum question
public class Q_15 {
    static int FrogJum(int[]arr,int idx){
        if(arr.length-1==idx)return 0;
        int opt1=Math.abs(arr[idx]-arr[idx+1])+FrogJum(arr,idx+1);
        if(arr.length-2==idx) return opt1;
        int op2=Math.abs(arr[idx]-arr[idx+2])+FrogJum(arr,idx+2);
        return Math.min(opt1,op2);
    }
//    static int best(int[] h,int n,int idx){
//        if(idx==n-1)return 0;
//        int op1=Math.abs(h[idx]-h[idx+1])
//    }
    public static void main(String[]args){
        int[] arr={10,30,40,20};
        int idx=0;
        System.out.println("The minimum steps are :- "+FrogJum(arr,idx));
    }
}
