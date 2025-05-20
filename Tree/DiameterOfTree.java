package Tree;
public class DiameterOfTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
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
    public static int height(Node root){
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        return 1+Math.max(left,right);
    }
    public static int diameter(Node root){
        if(root==null || (root.left==null && root.right==null)){
            return 0;
        }
        int left=diameter(root.left);
        int right=diameter(root.right);
        int lheight=height(root.left);
        int rheight=height(root.right);
        int count=lheight+rheight;
        if(root.left!=null)count++;
        if(root.right!=null)count++;
        return Math.max(count,Math.max(left,right));
    }
    public static boolean isBalanced(Node root){
        if(root==null) return true;
        int lh=height(root.left);
        if(root.left!=null) lh++;
        int rh=height(root.right);
        if(root.right!=null) rh++;
        int d=lh-rh;
        if(d<0) d=-d;
        if(d>1)return false;
        return (isBalanced(root.right) && isBalanced(root.left));
    }
    public static void treePath(Node root,String str){
        if(root==null)return ;
        if(root.left==null && root.right==null){
            str+=root.val;
            System.out.println(str);
            return;
        }
        treePath(root.left,str+root.val+"->");
        treePath(root.right,str+root.val+"->  ");
    }
    public static boolean contains(Node root,Node op){
        if(root==null)return false;
        if(root==op)return true;
        return contains(root.left,op) || contains(root.right,op);
    }
    public static Node LowestCommanAncestor(Node root,Node p,Node q){
        if(p==root || q==root)return root;
        if(p==q)return q;
        boolean leftcontain=contains(root.left,p);
        boolean rightcontain=contains(root.right,q);
        if(leftcontain && rightcontain || (!leftcontain && !rightcontain))return root;
        if(!leftcontain && rightcontain) LowestCommanAncestor(root.right,p,q);
        if(leftcontain && !rightcontain)LowestCommanAncestor(root.left,p,q);
        return null;
    }
    public static void main(String[]args){
        Node root=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(5);
        Node e=new Node(6);
        Node f=new Node(7);
        root.left=b;
        root.right=c;
        b.right=d;
        b.left=e;
        c.right=f;
        display(root);
        System.out.println("Height is :- "+height(root));
        System.out.println("Diameter of tree is :- "+diameter(root));
//        System.out.println("isBalanced :- "+isBalanced(root));
        treePath(root,"");
        System.out.println(LowestCommanAncestor(root,e,f).val);
    }
}
