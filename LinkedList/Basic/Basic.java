package LinkedList.Basic;
/***
 * This is class and learning of implementation of linked list
 * @author Shivam
 * @since 2024
 * @version 0.1v
 */
public class Basic {
    Node head;
    /***
     * This is node class containing the details of each element if linkedList
     */
    class Node {
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    /***
     * This function is used to remove last Element
     */
    public void removeLast(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        Node curNode=head;
        if(curNode.next==null){
            head=null;
            return;
        }
        while(curNode.next.next!=null){
            curNode=curNode.next;
        }
        curNode.next=null;
    }
    /***
     * This function is used to add element at first
     * @param data The Data entered by the user
     */
    public void addFirst(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    /***
     * This function is used to add element at last of LinkedList
     * @param data The Data entered by the user
     */
    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node curNode=head;
        while(curNode.next!=null){
            curNode=curNode.next;
        }
        curNode.next=newNode;
    }
    /***
     * This function is used to print all the elements of LinkedList
     */
    public void print(){
        if(head==null){
            System.out.println("The list is empty....");
            return;
        }
        Node curNode=head;
        while(curNode!=null){
            System.out.print(curNode.data+"->");
            curNode=curNode.next;
        }
        System.out.print("null");
        System.out.println();
    }
    /***
     * This function is used to remove First element of the LinkedList
     */ 
    public void removeFirst(){
        if(head==null){
            System.out.println("The list is empty...");
            return;
        }
        if(head.next==null){
            head=null;
            System.out.println("Item removed Successfully....");
            return;
        }
        head=head.next;

        System.out.println("Item removed Successfully....");
    }
    public void reverItrative(){
        if(head==null || head.next==null){
            return;
        }
        Node curr=head.next;
        Node prevNode=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prevNode;
            prevNode=curr;
            curr=next;
        }
        head.next=null;
        head=prevNode;
    }
    public Node reverSeRecursive(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead=reverSeRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

    /***
     * This is main function where all the above methods are implemented
     * @param args This is used to input arguments
     */
    public static void main(String[] args) {
        Basic ll=new Basic();
        ll.addFirst("a");
        ll.addFirst("B");
        ll.addFirst("c");
        ll.addFirst("d");
        ll.print();
//        ll.reverItrative();
        ll.head=ll.reverSeRecursive(ll.head);
        ll.print();
    }
}