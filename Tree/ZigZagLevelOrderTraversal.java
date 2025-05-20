package Tree;
//Here we will se the zig-zag level order traversal
public class ZigZagLevelOrderTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public static int height(Node root){
        if(root==null || (root.left==null && root.right==null))return 0;
        int lheight=height(root.left);
        int rheight=height(root.right);
        return 1+Math.max(lheight,rheight);
    }
    public static void LevelOrder(Node root,int n){
        if(root==null)return ;
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        LevelOrder(root.left,n-1);
        LevelOrder(root.right,n-1);
    }
    public static void LevelOrder2(Node root,int n){
        if(root==null)return;
        if(n==1){
            System.out.print(root.val+" ");
            return;
        }
        LevelOrder2(root.right,n-1);
        LevelOrder2(root.left,n-1);
    }
    public static void main(String[]args){
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
        System.out.println("Height of the binary tree is :- "+height(root));
        int height=height(root)+1;
        for(int i=1;i<height+1;i++){
            if(i%2==0) LevelOrder2(root,i);
            else LevelOrder(root,i);
            System.out.println();
        }
    }
}
