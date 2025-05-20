package BinarSearchTree;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

//Here we will solve the Problem where two BST given and we have to create the array from these two arrays
//And return the sorted array
public class JoiningTwoBST {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    //This method is used to construct BST using sorted array
    public static Node constructBST(int[]arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node root=new Node(arr[mid]);
        root.left=constructBST(arr,si,mid-1);
        root.right=constructBST(arr,mid+1,ei);
        return root;
    }
    //This method is used to display BST
    public static void display(Node root){
        if(root==null)return;
        System.out.print(root.val+"->");
        System.out.print(root.left!=null?root.left.val+",":"n,");
        System.out.println(root.right!=null?root.right.val:"n");
        display(root.left);
        display(root.right);
    }
    public static void MoshInorder(Node root,ArrayList<Integer>sal){
        Node curr=root;
        while(curr!=null){
            if(curr.left!=null){//Find pred
                Node pred=root.left;
                while(pred.right!=null && pred.right!=curr)pred=pred.right;
                if(pred.right==null){//Linking pred right to curr
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right==curr){
                    pred.right=null;
                    System.out.print(curr.val);
                    curr=curr.right;
                }
            }else{
                System.out.print(curr.val);
                curr=curr.right;
            }
        }
    }
    public static void InorderTraversal(Node root){
        if(root==null)return;
        InorderTraversal(root.left);
        System.out.print(root.val+" ");
        InorderTraversal(root.right);
    }
    public static void main(String[]args){
        int[]arr={1,2,3,4,5,6,7};
        ArrayList<Integer>sal=new ArrayList<>();
        Node root=constructBST(arr,0,arr.length-1);
        display(root);
        InorderTraversal(root);
        MoshInorder(root,sal);
//        MoshInorder(root,sal);
//        System.out.println(sal);

    }
}
