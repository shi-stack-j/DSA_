package stacks;
import java.util.Stack;
//Here we will solve the
//NEXT GREATER ELEMENT question
//NEXT SMALLER ELEMENT question
//PREVIOUS SMALLER ELEMENT question
//PREVIOUS GREATER ELEMENT question
public class AnaGram {
    public static void display(int[]arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    //This function will Make the array on NGE array
    public static void NextGreaterElement(int[]arr){
        int n=arr.length;
        int[]NGE=new int[n];
        NGE[n-1]=-1;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty())st.push(arr[i]);
            else if(st.peek()>arr[i]){
                NGE[i]=st.peek();
                st.push(arr[i]);
            }
            else{
                if(st.peek()<arr[i]){
                    while(!(st.isEmpty()) && st.peek()<arr[i]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        NGE[i]=-1;
                        st.push(arr[i]);
                    }else{
                        NGE[i]=st.peek();
                        st.push(arr[i]);
                    }
                }
            }
        }
        display(NGE);
    }
    public static void NextSmallerElement(int[]arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[]NSE=new int[n];
        NSE[n-1]=-1;
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty())st.push(arr[i]);
            else if(st.peek()<arr[i]){
                NSE[i]=st.peek();
                st.push(arr[i]);
            }
            else{
                if(st.peek()>arr[i]){
                    while(!(st.isEmpty())&&st.peek()>arr[i]){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        NSE[i]=-1;
                        st.push(arr[i]);
                    }else{
                        NSE[i]=st.peek();
                        st.push(arr[i]);
                    }
                }
            }
        }
        display(NSE);
    }
    public static void PrevGreaterElement(int[]arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
         int[]PGE=new int[n];
         PGE[0]=-1;
         for(int i=0;i<n;i++){
             if(st.isEmpty())st.push(arr[i]);
             else if(st.peek()>arr[i]) {
                 PGE[i]=st.peek();
                 st.push(arr[i]);
             }else{
                 if(st.peek()<arr[i]){
                     while(!(st.isEmpty())&&(st.peek()<arr[i])){
                         st.pop();
                     }
                     if(st.isEmpty()){
                         PGE[i]=-1;
                         st.push(arr[i]);
                     }else{
                         PGE[i]=st.peek();
                         st.push(arr[i]);
                     }
                 }
             }
         }
         display(PGE);

    }
    public static void PrevSmallerElement(int[]arr){
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        int[]PSE=new int[n];
        PSE[0]=-1;
        for(int i=0;i<n;i++){
            if(st.isEmpty())st.push(arr[i]);
            else if(st.peek()<arr[i]){
                PSE[i]=st.peek();
                st.push(arr[i]);
            }else{
                if(arr[i]<st.peek()){
                    while(!(st.isEmpty()) && (st.peek()>arr[i])){
                        st.pop();
                    }
                    if(st.isEmpty()){
                        PSE[i]=-1;
                        st.push(arr[i]);
                    }else{
                        PSE[i]=st.peek();
                        st.push(arr[i]);
                    }
                }
            }
        }
        display(PSE);
    }
    public static void main(String[]args){
        int[]arr={1,5,3,2,1,6,3,4};
        int[]arr2={3,2,1,4,5,2,45};
        NextGreaterElement(arr);
        NextSmallerElement(arr2);
        PrevGreaterElement(arr);
        PrevSmallerElement(arr2);

    }
}