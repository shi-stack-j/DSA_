package Tree;
//Here we will solve the question where preorder and inorder of the tree is given
//We have to construct the tree from the preorder and inorder array
public class PreInToTree {
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
    public static Node helper(int[]preorder,int prelo,int prehi,int[]inorder,int inlo,int inhi){
        if(prelo>prehi)return null;
        Node root=new Node(preorder[prelo]);
        int i=inlo;
        while(inorder[i]!=preorder[prelo])i++;
        int leftsize=i-inlo;
        root.left=helper(preorder,prelo+1,prelo+leftsize,inorder,inlo,i-1);
        root.right=helper(preorder,prelo+leftsize+1,prehi,inorder,i+1,inhi);
        return root;
    }
    public static Node buildTree(int[]preorder,int[]inorder){
        int n=preorder.length;
        return helper(preorder,0,n-1,inorder,0,n-1);
    }
    public static void main(String[]args){
        int[]preorder={1,2,4,5,3,6};
        int[]inorder={4,2,5,1,3,6};
        System.out.println(buildTree(preorder,inorder).val);
        display(buildTree(preorder,inorder));
    }
}
