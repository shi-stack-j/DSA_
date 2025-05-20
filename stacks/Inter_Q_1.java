package stacks;
import java.util.Scanner;
import java.util.Stack;
//Here we will the stack Balanced Bracket Question
public class Inter_Q_1 {
    public static Boolean isBalanced(String str){
        if(str.isEmpty()){
            return true;
        }
        Boolean flag=false;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')' && st.isEmpty()){
                return false;
            }
            if(str.charAt(i)=='('){
                st.push(str.charAt(i));
            } else if (str.charAt(i)==')'){
                st.pop();
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
    public static Boolean isBalanced2(String str){
        if(str.isEmpty()) {
            return true;
        }
        Stack<Character> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            if((str.charAt(i)==')' ||str.charAt(i)=='}'||str.charAt(i)==']') && st.isEmpty()){
                return false;
            }
            if(str.charAt(i)=='('||str.charAt(i)=='{'||str.charAt(i)=='['){
                st.push(str.charAt(i));
            } else if ((str.charAt(i)==')' && st.peek()=='(')||(str.charAt(i)=='}' && st.peek()=='{')||(str.charAt(i)==']' && st.peek()=='[') ){
                st.pop();
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;

    }
    public static void remove(int[]arr){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty())st.push(arr[i]);
            else if(st.peek()==arr[i]){
                while(arr[i]==st.peek()){
                    i++;
                }
                st.pop();
                i--;
            }else{
                st.push(arr[i]);
            }
        }
        System.out.println(st);
    }
    public static void PreGre(int[]arr){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int[]ar=new int[n];
        ar[0]=-1;
        for(int i=0;i<n;i++){
            if(st.isEmpty())st.push(i);
            else if(arr[i]>arr[st.peek()]){
                while(arr[i]>arr[st.peek()]){
                    st.pop();
                }
                ar[i]=i-st.peek();
                st.push(i);
            }else{
                ar[i]=i-st.peek();
                st.push(i);
            }
        }
        for(int i:ar){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[]args){
//        Scanner sc=new Scanner(System.in);
//        System.out.print("Enter String :- ");
//        String str=sc.next();
//        //System.out.println("The Status of balanaced is :- "+isBalanced(str));
//        System.out.println(isBalanced2(str));
//        int[]arr={1,2,2,3,10,10,10,4,4,4,5,7,7,2};
//        remove(arr);
        int[]arr2={100,80,70,60,70,60,75,50,40};
        PreGre(arr2);

    }

}
