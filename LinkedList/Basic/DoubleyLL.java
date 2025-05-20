package LinkedList.Basic;
//Here we will emplement doubley linkedlist
public class DoubleyLL {
    Node head;
    Node tail;
    class Node{
        int val;
        Node pre;
        Node next;
        public Node(int val){
            this.val=val;
//            this.next=null;
//            this.pre=null;
        }
    }
    void addFirst(int n){
        Node newNode=new Node(n);
        if(head==null){
            head=newNode;
            head.next=null;
            head.pre=null;
            tail=newNode;
            return;
        }
        newNode.next=head;
        head.pre=newNode;
        newNode.pre=null;
        head=newNode;
    }
    void addLast(int n){
        Node newNode=new Node(n);
        if(tail==null){
            tail=newNode;
            tail.next=null;
            tail.pre=null;
            head=tail;
            return;
        }
        tail.next=newNode;
        newNode.pre=tail;
        tail=newNode;
        tail.next=null;
    }
    int size(Node he){
        Node temp=he;
        int size=0;
        while(temp!=null){
            size+=1;
            temp=temp.next;
        }
        return size;
    }
    void addIndex(int n,int idx){
        if(idx==1){
            addFirst(n);
            return;
        }
        if(idx==size(head)){
            addFirst(n);
            return;
        }
        if(idx>size(head) || idx<0)return;
        Node newNode=new Node(n);
        Node temp=head;
        for(int i=0;i<idx-1;i++){
//            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println(temp.val+" : "+temp.pre.val+" : "+temp.next.val);
        newNode.next=temp.next;
        temp.next.pre=newNode;
        newNode.pre=temp;
        temp.next=newNode;
    }
    void print(Node n){
        if(head==null)System.out.println("List is empty :- ");
        Node temp=n;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String[]args){
        DoubleyLL ll1=new DoubleyLL();
        ll1.addFirst(1);
        ll1.addFirst(2);
        ll1.addFirst(3);
        ll1.addFirst(4);
        ll1.addFirst(5);
        ll1.addLast(6);
        ll1.addIndex(7,2);
        ll1.print(ll1.head);
        System.out.println("Tail is :- "+ll1.head.val+"\nHead is :- "+ll1.tail.val);
    }
}
