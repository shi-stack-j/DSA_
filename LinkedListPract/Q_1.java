package LinkedListPract;

public class Q_1 {
    Node head;
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    void add(int n){
        Node nd=new Node(n);
        if(head==null){
            head=nd;
            return ;
        }
        nd.next=head;
        head=nd;
    }
    void pr(){
        if(head==null){
            System.out.println("The list is empty :- ");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
   int size(Node h){
        int size=0;
       if(head==null){
           System.out.println("The list is empty :- ");
           return 0;
       }
       Node temp=h;
       while(temp!=null){
           temp=temp.next;
           size+=1;
       }
       return size;
   }
    int  getNnodeFromLast(int n){
        int len=size(head);
        int nnod=len-n+1;
        Node temp=head;
        for(int i=1;i<nnod;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    int getNnodeFromLastM2(int n){
        //Here we taake two pointers one is slo and another is fast
        Node slow=head;
        Node fast=head;
        //First we will  make the fast pointer to move forward
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        //Then we will move both the pointers simontaneously
        //when first pointer will reacch the end the end the loop will break
        //The answer is slow pointer
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow.data;
    }
    void removeNnodeFromLast(int n){
        Node slo=head;
        Node fas=head;
        for(int i=0;i<n;i++){
            fas=fas.next;
        }
        if(fas==null){
            head=head.next;
            return;
        }
        while(fas.next!=null){
            fas=fas.next;
            slo=slo.next;
        }
        if(slo.next.next!=null){
            slo.next=slo.next.next;
        }else{
            slo.next=null;
        }
    }
    int InterSectionOfLinkedLists(Node h1,Node h2){
        int len1=size(h1);
        int len2=size(h2);
        int n;
        if(len1>len2){
            n=len1-len2;
        }else{
            n=len2-len1;
        }
        Node t1=h1;
        Node t2=h2;
        for(int i=0;i<n;i++){
            if(len1>len2){
                t1=t1.next;
            }else{
                t2=t2.next;
            }
        }
        while(t1!=null){
            if(t1.data==t2.data){
                return t2.data;
            }
            t1=t1.next;
            t2=t2.next;
        }
        return -1;
    }
    int FindMiddleOfLinkedList(Node h){
        Node slo=h;
        Node fas=h;
        while( fas!=null && fas.next!=null){
            slo=slo.next;
            fas=fas.next.next;
//            if(fas==null || fas.next==null)break;
        }
        return slo.data;
    }
    static Node reverse(Node head){
        if(head.next==null)return head;
        Node newhead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
    public static void main(String[]args){
        Q_1 obj1=new Q_1();
        obj1.add(10);
        obj1.add(20);
        obj1.add(30);
        
        
        obj1.add(40);
        obj1.add(50);
        obj1.pr();
        System.out.println("Head of obj1 is :- "+obj1.head.data);
        System.out.println("Middle of obj1 is :- "+obj1.FindMiddleOfLinkedList(obj1.head));
        Node n=reverse(obj1.head);
        obj1.head=n;
        obj1.pr();
//        Q_1 ll=new Q_1();
//        Q_1 ll2=new Q_1();
//        ll2.add(10);
//        ll2.add(20);
//        ll2.add(30);
//        ll2.add(70);
////        ll2.add(80);
//        ll.add(10);
//        ll.add(20);
//        ll.add(30);
//        ll.add(40);
//        ll.add(60);
//        ll.pr();
////        System.out.println("The nth node form last is :- "+ll.getNnodeFromLast(5));
////        System.out.println("The nth node form the last is :- "+ll.getNnodeFromLastM2(5));
////        ll.removeNnodeFromLast(5);
////        ll.pr();
//        ll.pr();
//        ll2.pr();
////        System.out.println("Intersection point is :- "+ll.InterSectionOfLinkedLists(ll.head,ll2.head));
//        System.out.println("Middle of linkedlist in one traveraal is :- "+ll2.FindMiddleOfLinkedList(ll2.head));
    }
}
