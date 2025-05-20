package BinarSearchTree;
//Here we will construct BST using Sorted Array
public class ConstructBSTusingSortedArray {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.val+" -> ");
        System.out.print(root.left!=null?root.left.val+",":" ,n ");
        System.out.println(root.right!=null?root.right.val:"n");
        display(root.left);
        display(root.right);
    }
    public static Node constructBST(int[]arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node temp=new Node(arr[mid]);
        temp.left=constructBST(arr,si,mid-1);
        temp.right=constructBST(arr,mid+1,ei);
        return temp;
    }
    public static int ele=Integer.MAX_VALUE;
    public static int k=2;
    public static void KtheSmallest(Node root){
        if(root==null)return ;
        KtheSmallest(root.left);
        ele=root.val;
        if(k<=1)return;
        k=k-1;
        KtheSmallest(root.right);
    }
    public static void main(String[]args){
        int[]arr={1,2,3,4,5,6,7};
        Node root=constructBST(arr,0,arr.length-1);
        display(root);
        KtheSmallest(root);
        System.out.println("Kth Smallest Element is :- "+ele);

    }
}
