package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StacksUsiingQues {
    public static class stac{
        Queue<Integer> mai=new LinkedList<>();
        Queue<Integer> hel=new LinkedList<>();
        int size=0;
        void push(int n){
            mai.add(n);
            size++;
        }
        void pop(){
            while(mai.size()>1){
                hel.add(mai.remove());
            }
            mai.remove();
            while(!(hel.isEmpty())){
                mai.add(hel.remove());
            }
            size--;
        }
        int peek(){
            while(mai.size()>1){
                hel.add(mai.remove());
            }
            int ele=mai.remove();
            while(!(hel.isEmpty())){
                mai.add(hel.remove());
            }
            mai.add(ele);
            return ele;
        }
        int size(){
            return size;
        }
        void print(){
            Stack<Integer>st=new Stack<>();
            if(mai.isEmpty()){
                System.out.println("The stack is empty");
                return;
            }
            while(!(mai.isEmpty())){
                int ele=mai.remove();
                st.push(ele);
                hel.add(ele);
            }
            while(!(hel.isEmpty())){
                mai.add(hel.remove());
            }
            System.out.println(st);

        }
    }
    public static void main(String[]args){
        stac st=new stac();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.print();
        System.out.println("Size :- "+st.size());
        System.out.println("Size :- "+st.peek());
        st.pop();
        st.print();
        System.out.println("Size :- "+st.size());
        System.out.println("Size :- "+st.peek());



    }
}
