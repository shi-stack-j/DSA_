package Tree;
//Here we will se the tree questions to check for invert tree ,symmetric tree, is Same tree
public class Symmetric {
    public static class Node{
        int val;
        Node right;
        Node left;
        public Node(int val){
            this.val=val;
        }
    }
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.val+"->");
        System.out.print(root.left==null?"n,":root.left.val+",");
        System.out.println(root.right==null?"n":root.right.val);
        display(root.left);
        display(root.right);
    }
    public static boolean isSametree(Node p,Node q){
        //IF both trees are emmpty then they are same
        if(p==null && q==null)return true;
        //If any of the tree node is empty and another is not empty then they are not same
        if(p==null || q==null)return false;
        //Here we are checking for the right tree
        boolean left=isSametree(p.left,q.left);
        //Here we are checking for the left tree
        boolean right=isSametree(p.right,q.right);
        //This will return the and operation of both left and right
        return left && right;
    }
    //Here we will check for the tree is invert or not
    //Invert Tree->Convert the tree to its mirror image
    public static Node inVertTree(Node root){
        if(root==null)return null;
        Node left=inVertTree(root.left);
        Node right=inVertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
    //Here we will check wheather two trees are symmentric or not
    //Symmetric trees are trees whoes mirror image is same as tree
    public static boolean isSymmetric(Node root){
        if(root==null)return true;
        root.left=inVertTree(root.left);
        return isSametree(root.left,root.right);

    }
    public static void main(String[]args){
        Node root=new Node(1);
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
        display(inVertTree(root));
        System.out.println("Symmetric tree is :- "+isSymmetric(root));
//        Node root2=new Node(1);
//        Node a2=new Node(2);
//        Node c2=new Node(3);
//        Node d2=new Node(4);
//        Node e2=new Node(5);
//        Node f2=new Node(6);
//        Node g2=new Node(7);
//        Node h2=new Node(8);
//        root2.left=a2;
//        root2.right=c2;
//        a2.left=d2;
//        a2.right=e2;
//        c2.right=g2;
//        c2.left=f2;

//        System.out.println("Two trees are "+(isSametree(root,root2)?"Same":"Not Same"));
    }
}