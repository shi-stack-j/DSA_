package stacks;
import java.util.Stack;
public class LetNGEPSE{
    public static void display(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void NextSmallerEelment(int[]arr,int[]NSE){
        int  n=arr.length;
        Stack<Integer> st=new Stack<>();
        NSE[n-1]=n;
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty())st.push(i);
            else if(arr[st.peek()]<arr[i]){
                NSE[i]=st.peek();
                st.push(i);
            }else{
                if(arr[st.peek()]>arr[i]){
                    while(!(st.isEmpty()) && (arr[st.peek()]>arr[i])){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        NSE[i]=n;
                        st.push(i);
                    }else{
                        NSE[i]=st.peek();
                        st.push(i);
                    }
                }
            }
        }
    }
    public static void PrevSmallerElement(int[]arr,int[]PSE){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        PSE[0]=-1;
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(i);
            }
            else if(arr[st.peek()]<arr[i]){
                PSE[i]=st.peek();
                st.push(i);
            }else{
                if(arr[st.peek()]>arr[i]){
                    while(!(st.isEmpty())&&(arr[st.peek()]>arr[i])){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        PSE[i]=-1;
                        st.push(i);
                    }else{
                        PSE[i]=st.peek();
                        st.push(i);
                    }
                }
            }
        }
    }
    public static int max(int[]arr,int[]PSE,int[]NSE){
        int max=0;
        for(int i=0;i<arr.length;i++){
            int area=((arr[i])*(NSE[i]-PSE[i]-1));
            if(area>max) max=area;
        }
        return max;
    }
    public static void  main(String[]args){
        int[]arr={5,2,4,6,3,5};
        int[]NSE=new int[arr.length];
        int[]PSE=new int[arr.length];
        NextSmallerEelment(arr,NSE);
        display(NSE);
        PrevSmallerElement(arr,PSE);
        display(PSE);
        System.out.println("The maximum area is :- "+max(arr,PSE,NSE));
    }
}