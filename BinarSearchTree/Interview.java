package BinarSearchTree;
import java.util.Stack;
//Here we are goning to see all interview questions on BST
public class Interview {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
        }
    }
    public static Node consturctBST(int[]arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node temp=new Node(arr[mid]);
        temp.left=consturctBST(arr,si,mid-1);
        temp.right=consturctBST(arr,mid+1,ei);
        return temp;
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
    public static void GreatestSumTree(Node root,Stack<Integer>st){
        if(root==null)return;
        GreatestSumTree(root.right,st);
        if(st.isEmpty())st.push(root.val);
        else {
            root.val=st.pop()+root.val;
            System.out.print(root.val+" ");
            st.push(root.val);
        }
        GreatestSumTree(root.left,st);
    }
    //Here we will se the morish traversal of inorder of BST
    public static void MorishTraversal(Node root){
        Node curr=root;
        while(curr!=null ){
            if(curr.left!=null){//find pred
                Node pred=root.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if (pred.right==null){//connect pred with curr
                    pred.right=curr;
                    curr=curr.left;
                }
                if (pred.right==curr){//unlink pred and curr
                    pred.right=null;
                    System.out.print(curr.val+" ");
                    curr=curr.right;
                }
            }
            else {//curr.left = null, no pred
                System.out.print(curr.val+" ");
                curr=curr.right;
            }
        }
    }
    //Here we will trim the BST
    //The All the nodes that are less then lo
    //The all the nodes that are greator then hi
    public static void TrimBST(Node root,int lo,int hi){
        if(root==null) return;
        while(root.left!=null){
            if(root.left.val<lo)root.left=root.left.right;
            else if(root.left.val>hi)root.left=root.left.left;
            else break;
        }
        while(root.right!=null){
            if(root.right.val<lo)root.right=root.right.right;
            else if(root.right.val>hi)root.right=root.right.left;
            else break;
        }
        TrimBST(root.left,lo,hi);
        TrimBST(root.right,lo,hi);
    }
    public static void main(String[]args){
        int[]arr={1,2,3,4,5,6,7,8};
        Node root=consturctBST(arr,0,arr.length-1);
        display(root);
//        System.out.println("Printing the Reverse Order...");
//        Stack<Integer>st=new Stack<>();
//        GreatestSumTree(root,st);
//        System.out.println();
//        display(root);
//        for(var i:st){
//            System.out.println(i);
//        }
        MorishTraversal(root);
    }
}
