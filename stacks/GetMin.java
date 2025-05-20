package stacks;
import java.util.Stack;
//Here we wil solve the GetMin Problem using stack
public class GetMin {
    public static class stack{
        Stack<Integer> st=new Stack<>();
        static int min=0;
        void push(int n){
            if(st.isEmpty()){
                min=n;
                st.push(n);
            }
            else if(st.peek()<=n)st.push(n);
            else if(st.peek()>n){
                st.push(2*n-min);
                min=n;
            }
        }
        void pop(){
            if(st.isEmpty()){
                System.out.println("The stacck is empty");
                return;
            }
            if(st.peek()>=min){
                st.pop();
            }else if(st.peek()<min){
                int old=2*min-st.peek();
                min=old;
                st.pop();
            }
        }
        int peek(){
            if(st.isEmpty()){
                System.out.println("The stack is empty");
                return -1;
            }
            else if(st.peek()>=min)return st.peek();
            if(st.peek()<min){
                return min;
            }
            return st.peek();
        }
        int getMin(){
            return min;
        }
    }

    public static void main(String[]args){
        stack st=new stack();
        st.push(4);
        st.push(5);
        st.push(1);
        st.push(56);
        System.out.println("Print "+st.getMin());
        System.out.println("Print "+st.peek());

    }
}
