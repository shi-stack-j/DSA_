package BinarSearchTree;
import java.util.Stack;
//Here we will swap the nodes that are changed BY Mistake OF BST
public class SwapTheUnsortedNodes {
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
        System.out.print(root.left!=null?root.left.val+",":"n,");
        System.out.println(root.right!=null?root.right.val+",":"n");
        display(root.left);
        display(root.right);
    }
    public static Node ConstBST(int[]arr,int si,int ei){
        if(si>ei)return null;
        int mid=(si+ei)/2;
        Node root=new Node(arr[mid]);
        root.left=ConstBST(arr,si,mid-1);
        root.right=ConstBST(arr,mid+1,ei);
        return root;
    }
    public static void InOrderTra(Node root){
        if(root==null)return;
        InOrderTra(root.left);
        System.out.print(root.val+" ");
        InOrderTra(root.right);
    }
    public static void ReservingBST(Node root,Stack<Node>st){
        if(root==null)return;
        ReservingBST(root.left,st);
        if(st.isEmpty())st.push(root);
        else if(st.peek().val>root.val){
            int temp=root.val;
            root.val=st.peek().val;
            st.peek().val=temp;
        }
        st.pop();
        st.push(root);
        ReservingBST(root.right,st);
    }
    public static void ReservingBSTMoTra(Node root){
        if(root==null)return;
        Node prevNode=null;
        Node curr=root;
        while(curr!=null){
            if(curr.left!=null){
                Node pred=curr.left;
                while(pred.right!=null && pred.right!=curr)pred=pred.right;
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                if(pred.right==curr){
                    pred.right=null;
                    System.out.print("Prev = "+prevNode.val+" ");
                    System.out.print("Curr = "+ curr.val+" ");
                    curr=curr.right;
                }
            }else{
                prevNode=curr;
                curr=curr.right;
            }
        }
    }
    public static void main(String[]args){
        int[]arr={1,2,3,5,4,6,7};
        Node root=ConstBST(arr,0, arr.length-1);
        display(root);
        System.out.println();
//        InOrderTra(root);
//        Stack<Node>st=new Stack<>();
//        ReservingBST(root,st);
//        System.out.println();
        ReservingBSTMoTra(root);
        System.out.println();
        display(root);
    }
}