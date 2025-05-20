package BinarSearchTree;

import java.sql.Array;
import java.util.ArrayList;

//Here we are going to find the Min and max element in the BST
//Constructing the Sorted array Using BST
public class BasicOperationsMinMax {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    //Here we are finding the maximum value from BST
    public static int maxElemet(Node root){
        if(root==null)return Integer.MIN_VALUE;
        int cur=root.val;
        int left=maxElemet(root.left);
        int right=maxElemet(root.right);
        return Math.max(cur,Math.max(left,right));
    }
    //Here we are finding the minimum value from BST
    public static int minVal(Node root){
        if(root==null)return Integer.MAX_VALUE;
        int cur=root.val;
        int left=minVal(root.left);
        int right=minVal(root.right);
        return Math.min(cur,Math.min(left,right));
    }
    //Here we are creating the sorted array from the BST
    public static void SortedArrayFromBst(Node root, ArrayList<Integer>nal){
        if(root==null)return;
        SortedArrayFromBst(root.left,nal);
        nal.add(root.val);
        SortedArrayFromBst(root.right,nal);
    }
    public static Node LowestCommanAncestor(Node root,int p,int q){
        if(root==null)return root;
        if(root.val==p || root.val==q)return root;
        if(root.val>p && root.val<q)return root;
        if(root.val<p && root.val>q)return root;
        if(root.val<p && root.val<q) return LowestCommanAncestor(root.right,p,q);
        if (root.val>p && root.val>q)return LowestCommanAncestor(root.left,p,q);
        return null;
    }
    public static void predecsorAndScucceor(Node root,int val,ArrayList<Integer>inor){
        if(root==null)return ;
        SortedArrayFromBst(root,inor);
        int pre=0,succ=0;
        for(int i=0;i<inor.size();i++){
            if(inor.get(i)==val){
                pre= inor.get(i-1);
                succ=inor.get(i+1);
                break;
            }
        }
        System.out.println("Predecseor :- "+pre+"\nSuccesor :- "+succ);
    }
    public static Node prede=null;
    public static Boolean flag=false;
    static Node succ=null;
    public static void predAndSucc(Node root,int key){
        if(root==null)return;
        predAndSucc(root.left,key);
        if(flag==true){
            succ=root;
            return;
        }
        if(root.val==key)flag=true;
        if(flag==false)prede=root;
        predAndSucc(root.right,key);
    }
    public static void main(String[]args){
        Node root=new Node(10);
        Node a=new Node(5);
        Node b=new Node(2);
        Node c=new Node(8);
        Node d=new Node(15);
        Node e=new Node(12);
        Node f=new Node(17);
        root.left=a;
        a.left=b;
        a.right=c;
        root.right=d;
        d.left=e;
        d.right=f;
        System.out.println("Maximum value in BST is :- "+maxElemet(root));
        System.out.println("Minimum value in BST is :- "+minVal(root));
        ArrayList<Integer> nal=new ArrayList<>();
        SortedArrayFromBst(root,nal);
        System.out.println(nal);
        ArrayList<Integer>al=new ArrayList<>();
        predecsorAndScucceor(root,12,al);
        predAndSucc(root,12);
        System.out.println("Predesesor :- "+prede.val);
        System.out.println("Succesor :- "+succ.val);
    }
}
