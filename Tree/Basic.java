package Tree;
import java.util.Queue;
import java.util.LinkedList;
//Here we will se the basic implement of tree structure
public class Basic {
    public static class Node{
        int val;
        Node right;
        Node left;
        public Node(int val){
            this.val=val;
        }
    }
    //Here we are creating the method to print the tree
    //The printing of the binary tree is done by
    public static void display(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" -> ");
        System.out.print(root.left==null?"n,":root.left.val+",");
        System.out.println(root.right==null?"n ":root.right.val);
        display(root.left);
        display(root.right);
    }
    public static int SumOfNodes(Node root){
        if(root==null)return 0;
        int left=SumOfNodes(root.left);
        int right=SumOfNodes(root.right);
        int sum=right+left;
        return sum+root.val;
    }
    public static int size(Node root){
        if(root==null)return 0;
        int left=size(root.left);
        int right=size(root.right);
        int total=left+right;
        return 1+total;
    }
    public static int maxVal(Node root){
        if(root==null) return Integer.MIN_VALUE;
        int left=maxVal(root.left);
        int right=maxVal(root.right);
        return Math.max(root.val,Math.max(left,right));
    }
    public static int minVal(Node root){
        if(root==null) return Integer.MAX_VALUE;
        int left=minVal(root.left);
        int right=minVal(root.right);
        int curr=root.val;
        return Math.min(curr,Math.min(left,right));
    }
    public static int productOfNodes(Node root){
        if(root==null)return 1;
        int left=productOfNodes(root.left);
        int right=productOfNodes(root.right);
        return root.val*left*right;
    }
    public static int height(Node root){
        if(root==null)return 0;
        //If the node is leaf node then its height is 0
        if(root.left==null && root.right==null)return 0;
        //This will calculate the left height of the tree
        int left_height=height(root.left);
        //This will calculate the right height of the tree
        int right_height=height(root.right);
        //This will calculate the max height b/w left and right and add 1
        return 1+Math.max(left_height,right_height);
    }
    public static void preOrder(Node root){
        if(root==null)return;
        System.out.print(root.val+"->");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void InOrder(Node root){
        if(root==null)return;
        InOrder(root.left);
        System.out.print(root.val+"->");
        InOrder(root.right);
    }
    public static void PostOrder(Node root){
        if(root==null)return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.val+"->");
    }
    public static void nThLevel(Node root,int n){
        if(root==null)return;
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        nThLevel(root.left,n-1);
        nThLevel(root.right,n-1);
    }
    public static void bfs(Node root){
        if(root==null)return;
        //Here we will se the printing of tree using B First Search
        //we have to create the queue of Node
        Queue<Node> qu=new LinkedList<>();
        qu.add(root);
        while(!(qu.isEmpty())){
            Node temp=qu.peek();
            if(temp.right!=null)qu.add(temp.right);
            if(temp.left!=null)qu.add(temp.left);
            System.out.print(temp.val+" ");
            qu.remove();
        }
    }
    public static void main(String[]args){
        //Here we have created the whole tree
        //Here we have created  the root node
        Node root=new Node(1);
        //Creating more nodes
        Node a=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        Node g=new Node(7);
        root.left=a;
        root.right=c;
        a.left=d;
        a.right=e;
        c.right=g;
        c.left=f;
        display(root);
        System.out.println(SumOfNodes(root));
        System.out.println("The size of tree is :- "+size(root));
//        System.out.println("Printing preOrder tree");
//        preOrder(root);
//        System.out.println();
//        System.out.println("Printing inorder tree");
//        InOrder(root);
//        System.out.println();
//        System.out.println("Printing the post order tree");
//        PostOrder(root);
//        System.out.println();
//        System.out.println("Maximum value of root is :-"+maxVal(root));
//        System.out.println("Product of nodes is :- "+productOfNodes(root));
        System.out.println("Height of the tree is :- "+height(root));
//        System.out.println("Minimum value is :- "+minVal(root));
//        nThLevel(root,2);
//        System.out.println();
//        bfs(root);
    }
}

