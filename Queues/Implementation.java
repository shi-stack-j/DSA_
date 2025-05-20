package Queues;
//Here we will se the implementation of queues
public class Implementation {
    public static class Queu{
        private int size;
        private int idx;
        private int sidx;
        private int[]arr=new int[10];
        void add(int n){
            arr[idx]=n;
            idx++;
            size++;
        }
        int element(){
            if(size==0)return -1;
            return arr[sidx];
        }
        int size(){
            return size;
        }
        void remove(){
            if(size==0){
                System.out.println("The Queues is empty");
                return;
            }
            arr[sidx]=0;
            sidx++;
            size--;
        }
        void prin(){
            for(int i=sidx;i<idx;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public static class Qu{
        protected Node head;
        protected Node tail;
        protected int size;
        public class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
            }
        }
        void add(int n){
            Node newNode=new Node(n);
            if(head==null){
                head=newNode;
                head.next=null;
                tail=head;
                size++;
                return;
            }
            tail.next=newNode;
            tail=newNode;
            size++;
        }
        int element(){
            if(head==null){
                System.out.println("The queues is empty");
                return -1;
            }
            return head.data;
        }
        void print(){
            if(head==null){
                System.out.println("The Queues is empty");
                return;
            }
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        void remove(){
            if(head==null){
                System.out.println("Queue is empty ");
                return;
            }
            if(head.next==null){
                head=null;
                tail=null;
                size--;
                return;
            }
            head=head.next;
            size--;
        }
        int size(){
            return size;
        }

    }
    public static void main(String []args){
//        Queu q1=new Queu();
//        q1.add(1);
//        q1.add(2);
//        q1.add(3);
//        q1.add(4);
//        q1.add(5);
//        q1.prin();
//        System.out.println("Size :- "+q1.size());
//        System.out.println("Element :- "+q1.element());
//        q1.remove();
//        System.out.println("Size :- "+q1.size());
//        System.out.println("Element :- "+q1.element());
//        q1.prin();
        Qu ob=new Qu();
        ob.add(1);
        ob.add(2);
        ob.add(3);
        ob.add(4);
        ob.add(5);
        ob.print();
        System.out.println("Size :- "+ob.size());
        System.out.println("Element :- "+ob.element());
        ob.remove();
        ob.print();
        System.out.println("Size :- "+ob.size());
        ob.add(6);
        ob.print();
        System.out.println("Size :- "+ob.size());

    }
}
