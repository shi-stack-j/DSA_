package BinarSearchTree;
//Here we are doing the first question on binary search tree
//We will search in the binary search tree for the given node
public class SearchInBinaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    //Here we are displaying the BST
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.val+" -> ");
        System.out.print(root.left!=null?root.left.val +" ," :" n, ");
        System.out.println(root.right!=null?root.right.val:"n");
        display(root.left);
        display(root.right);
    }
    //Here we are Searching the given node in the BST
    public static Boolean searchBinaryTree(Node root,int val){
        if(root==null)return false;
        if(root.val==val)return true;
        if(root.val>val)return searchBinaryTree(root.left,val);
        else return searchBinaryTree(root.right,val);
    }
    //Here we are inserting the new node in the BST
    public static void insertBinarySearchTree(Node root,int val){
        if(root==null){
            Node temp=new Node(val);
            return;
        }
        if(root.val>val){
            if(root.left==null){
                Node temp=new Node(val);
                root.left=temp;
                return;
            }else{
                insertBinarySearchTree(root.left,val);
            }
        }else{
            if(root.right==null){
                Node temp=new Node(val);
                root.right=temp;
                return;
            }else{
                insertBinarySearchTree(root.right,val);
            }
        }
    }
    public static void main(String[]args){
        Node root=new Node(50);
        Node a=new Node(20);
        Node b=new Node(17);
        Node c=new Node(10);
        Node d=new Node(14);
        Node e=new Node(34);
        Node f=new Node(28);
        Node g=new Node(60);
        Node h=new Node(55);
        Node i=new Node(89);
        Node j=new Node(70);
        root.left=a;
        a.left=b;
        b.left=c;
        c.right=d;
        a.right=e;
        e.left=f;
        root.right=g;
        g.left=h;
        g.right=i;
        i.left=j;
        display(root);
        System.out.println(searchBinaryTree(root,14));
        insertBinarySearchTree(root,65);
        display(root);
    }
}
