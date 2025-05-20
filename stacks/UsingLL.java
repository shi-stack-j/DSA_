package stacks;
//Here we will implement the stack using linked list
public class UsingLL {
    static Node head;
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Stack{
        private int size=0;
        void push(int n){
            Node newNode=new Node(n);
            if(head==null){
                head=newNode;
                head.next=null;
                size++;
                return;
            }
            newNode.next=head;
            head=newNode;
            size++;
        }
        void pop(){
            if(size==0){
                System.out.println("Stack is empty :- ");
                return;
            }
            if(head.next==null){
                head=null;
                size--;
                return;
            }
            head=head.next;
            size--;
        }
        int peek(){
            if(size==0){
                System.out.println("The stack is empty..");
                return -1;
            }
            return head.data;
        }
        void display(){
            if(head==null){
                System.out.println("The stack is empty :- ");
                return;
            }
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp=temp.next;
            }
        }
        int getSize(){
            return size;
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
