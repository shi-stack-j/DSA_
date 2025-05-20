package BinarSearchTree;
import java.util.ArrayList;
//Here we are going to see the morish traversal
//This is efficient way of Inorder Traversal of BST
public class MorishTraversal {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public static Node ConstBST(int[]arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node root=new Node(arr[mid]);
        root.left=ConstBST(arr,si,mid-1);
        root.right=ConstBST(arr,mid+1,ei);
        return root;
    }
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.val+"->");
        System.out.print(root.left!=null?root.left.val+",":"n,");
        System.out.println(root.right!=null?root.right.val:"n");
        display(root.left);
        display(root.right);
    }
    public static void InorderTraversal(Node root){
        if(root==null)return;
        InorderTraversal(root.left);
        System.out.print(root.val+" ");
        InorderTraversal(root.right);
    }
    public static void MoreeshTraversal(Node root,ArrayList<Integer>mt){
        if(root==null)return;
        Node curr=root;
        while(curr!=null){
            if(curr.left!=null){
                Node pre=curr.left;
                while(pre.right!=null && pre.right!=curr) pre=pre.right;
                if(pre.right==null){
                    pre.right=curr;
                    curr=curr.left;
                }
                if(pre.right==curr){
                    pre.right=null;
                    mt.add(curr.val);
                    curr=curr.right;
                }
            }else{
                mt.add(curr.val);
                System.out.print("Prev = "+curr.val);
                curr=curr.right;
            }
        }
    }
    public static void main(String[]args){
        int[]arr={1,2,3,4,5,6,7};
        Node root=ConstBST(arr,0, arr.length-1);
        display(root);
        InorderTraversal(root);
        ArrayList<Integer>mt=new ArrayList<>();
        MoreeshTraversal(root,mt);
        System.out.println("\n"+mt);

    }
}
