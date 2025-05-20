package Queues;
//Here we will solve the ques interview questions
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class InterV1 {
    static void reverse(Queue<Integer>qu){
        if(qu.size()==0){
            System.out.println("Cannot reverse the empty QUEUES");
            return;
        }
        Stack<Integer> st=new Stack<>();
        while(!(qu.isEmpty())){
            st.push(qu.remove());
        }
        while(!(st.isEmpty())){
            qu.add(st.pop());
        }
    }
    static void reverseKelem(Queue<Integer>qu,int k){
        Stack<Integer> st=new Stack<>();
        Queue<Integer> hel=new LinkedList<>();
        int i=1;
        while(!(qu.isEmpty())){
            if(i<=k){
                st.push(qu.remove());
                i++;
            }else{
                hel.add(qu.remove());
            }
        }
        while(!(st.isEmpty())){
            qu.add(st.pop());
        }
        while(!(hel.isEmpty())){
            qu.add(hel.remove());
        }
    }
    static void reorderQueue(Queue<Integer>qu){
        Stack<Integer> st=new Stack<>();
        int n=qu.size()/2;
        int j=0;
        int z=qu.size();
        //Pushing into stack second half
        for(int i=0;i<z;i++){
            if(i>=n)st.push(qu.remove());
            else qu.add(qu.remove());
        }
//        int z=qu.size();
//        while(j<=z){
//            if(j>n)st.push(qu.remove());
//            else qu.add(qu.remove());
//
//        }
        //Putting back these elements into queues
        while(!(st.isEmpty())){
            qu.add(st.pop());
        }
        //Pushing back those elements into stack
        for(int i=0;i<z;i++){
            if(i>=n)st.push(qu.remove());
            else qu.add(qu.remove());
        }
        //Just Reordring elemnts
        while(!(st.isEmpty())){
            qu.add(qu.remove());
            qu.add(st.pop());
        }
    }
    public static void main(String[]args){
        Queue<Integer> qu=new LinkedList<>();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        qu.add(6);
        qu.add(7);
        qu.add(8);
        System.out.println(qu);
//        reverse(qu);
//        System.out.println(qu);
//        reverseKelem(qu,2);
//        System.out.println(qu);
        reorderQueue(qu);
        System.out.println(qu);


    }
}
