package stacks;
public class Video_1 {
    public static class Stack{
        private int[]arr=new int[10];
        private int idx=0;
        private int size=0;
        void push(int n){
            arr[idx]=n;
            idx++;
            size++;
        }
        void pop(){
            if(size==0){
                System.out.println("The stack is empty :- ");
                return;
            }
            arr[idx]=0;
            idx--;
            size--;
        }
        int peek(){
             if(size==0){
                 System.out.println("The stack is empty ");
                 return -1;
             }
            return arr[size-1];
        }
        void display(){
            System.out.print("[");
            int n=size-1;
            for(int i=n;i>=0;i--){
                System.out.print(arr[i]+" ");
            }
            System.out.println("]");
        }
        int getSize(){
            return size;
        }
        void isFull(){
            if(size== arr.length){
                System.out.println("Stack is full");
                return;
            }
            System.out.println("No");
        }
    }

    public static void main(String[]args){
        Stack st=new Stack();
        System.out.println("Length is :- "+st.getSize());
        st.display();
        st.push(1);
        System.out.println("Length is :- "+st.getSize());
        st.display();
        st.push(2);
        System.out.println("Length is :- "+st.getSize());
        st.display();
        st.push(3);
        System.out.println("Length is :- "+st.getSize());
        st.display();
        st.push(4);
        System.out.println("Length is :- "+st.getSize());
        st.display();
        st.push(5);
        System.out.println("Length is :- "+st.getSize());
        st.display();
        st.pop();
        st.pop();
        System.out.println("Length is :- "+st.getSize());
        st.display();
    }
}
