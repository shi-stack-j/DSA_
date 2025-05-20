package BinarSearchTree;
//Here we are going to see the different types of traversals in the BST
public class TraversalsInBST {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public static void preOrder(Node root){
        if(root==null)return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    //Inorder Traversal of BST is always gives sorted array
    public static void inorder(Node root){
        if(root==null)return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    //Here we will se the question to validate the binary tree
    //For that first we are going to store the pre value in public variable and check with the current variable
    //If the pre value is greator then or equal to current value then tree is not balanced
    //Creating the gloabal variable
    static Node pre=null;
    public static Boolean flag=true;
    //validating binary Search tree using global variable
    public static void validateBinaryTree(Node root){
        if(root==null)return;
        validateBinaryTree(root.left);
        if (pre==null)pre=root;
        else if(root.val<=pre.val)flag=false;
        else pre=root;
        validateBinaryTree(root.right);
    }
    //Validating Binary Search Tree Without using global Variable
    public static boolean valiDateBST(Node root){
        if(root==null)return true;
        boolean rl=valiDateBST(root.left);
        boolean rr=valiDateBST(root.right);
        boolean left=true,right=true;
        if(root.left!=null && root.left.val>=root.val)left=false;
        if(root.right!=null && root.right.val<=root.val)right=false;
        return left&&right&&rl&&rr;
    }
    public static void main(String[]args){
        Node root=new Node(10);
        Node a=new Node(5);
        Node b=new Node(2);
        Node c=new Node(8);
        Node d=new Node(15);
        Node e=new Node(12);
        Node f=new Node(17);
        Node g=new Node(6);
        root.left=a;
        a.left=b;
        a.right=c;
        root.right=d;
        d.left=e;
        d.right=f;
//        f.right=g;
        System.out.println("Printing the PreOrder :- ");
        preOrder(root);
        System.out.println();
        System.out.println("Printing the PostOrder :- ");
        postOrder(root);
        System.out.println();
        System.out.println("Printing the InOrder :- ");
        inorder(root);
        flag=true;
        validateBinaryTree(root);
        System.out.println(flag);
        System.out.println("\nValidate Binary tree result is :- "+(flag?"Binary Tree Is Correct ":"Binary Tree is Not correct"));
        System.out.println(valiDateBST(root));
    }
}
