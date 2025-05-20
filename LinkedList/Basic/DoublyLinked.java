package LinkedList.Basic;

public class DoublyLinked {
    Node head;
    Node tail;
    class Node{
        int n;
        Node next;
        Node pre;
        public Node(int data){
            this.n=data;
            this.next=null;
            this.pre=null;
        }
    }
    void addLast(int n){
        Node nn=new Node(n);
        if(head==null){
            head=nn;
            tail=nn;
            return;
        }
        tail.next=nn;
        nn.pre=tail;
        tail=nn;
    }
    void addFirst(int n){
        Node nn=new Node(n);
        if(head==null){
            head=nn;
            tail=nn;
            return;
        }
        nn.next=head;
        head.pre=nn;
        head=nn;
    }
    void print(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node cn=head;
        while(cn!=null){
            System.out.print(cn.n+"->");
            cn=cn.next;
        }
        System.out.println("null");

    }
    void printRev(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node nn=tail;
        while(nn!=null){
            System.out.print(nn.n+"->");
            nn=nn.pre;
        }
        System.out.println("null");
    }
    public static void main(String[]args){
        DoublyLinked ll=new DoublyLinked();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addFirst(10);
        ll.print();
        ll.printRev();
    }
}
