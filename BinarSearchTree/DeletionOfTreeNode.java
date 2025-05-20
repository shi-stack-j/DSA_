package BinarSearchTree;
//Here we are deleting the Node from the BST
//We will see the 3 different Cases
//CASE-1->When Node has 0 child->Easy
//CASE-2->When Node has 1 child->Easy
//CASE-3->When Node has 2 child->Medium
public class DeletionOfTreeNode {
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
        System.out.print(root.left!=null?root.left.val +" ," :" n, ");
        System.out.println(root.right!=null?root.right.val:"n");
        display(root.left);
        display(root.right);
    }
    //Here we are deleting the node that has 0 Child
    public static void DeleteNode1(Node root,int val){
        if(root==null)return;
        if(root.val>val){
            if(root.left!=null && root.left.val==val)root.left=null;
            else if (root.left==null)return;
            else DeleteNode1(root.left,val);
        }
        if(root.val<val){
            if(root.right!=null && root.right.val==val)root.right=null;
            else if (root.right==null)return;
            else DeleteNode1(root.right,val);
        }
    }
    //Here we are deleting the node that has 1 Child
    public static void DeleteNode2(Node root,int val){
        if(root==null)return;
        if(root.val>val){
            if(root.left!=null && root.left.val==val){
                if(root.left.left!=null){
                    Node temp=root.left.left;
                    root.left=temp;
                }else if(root.left.right!=null){
                    Node temp=root.left.right;
                    root.left=temp;
                }else{
                    root.left=null;
                }
            }
            else if (root.left==null)return;
            else DeleteNode2(root.left,val);
        }
        if(root.val<val){
            if(root.right!=null && root.right.val==val){
                if(root.right.left!=null){
                    Node temp=root.right.left;
                    root.right=temp;
                }else if(root.right.right!=null){
                    Node temp=root.right.right;
                    root.right=temp;
                }else{
                    root.right=null;
                }
            }
            else if (root.right==null)return;
            else DeleteNode2(root.right,val);
        }
    }
    public static Node getLast(Node root){
        Node temp=root;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }
    //Here we are deleting the node that has 2 Child
    public static void DeleteNode3(Node root,int val){
        if(root==null)return;
        if(root.val==val){
            Node left=root.left!=null?root.left:null;
            Node right=root.right!=null?root.right:null;
            if(right!=null){
                Node lastNode=getLast(right);
                lastNode.left=left;
            }
            root.val=right.val;
            root.left=right.left;
            root.right=right.right;
        }
        if(root.val>val){
            if(root.left!=null && root.left.val==val){
                Node left=root.left.left!=null?root.left.left:null;
                Node right=root.left.right!=null?root.left.right:null;
                if(right!=null){
                    Node lastNode=getLast(right);
                    lastNode.left=left;
                }
                root.left=right;
            }else{
                DeleteNode3(root.left,val);
            }
        }if(root.val<val){
            if(root.right!=null && root.right.val==val){
                Node left=root.right.left!=null?root.right.left:null;
                Node right=root.right.right!=null?root.left.right:null;
                if(right!=null){
                    Node lastNode=getLast(right);
                    lastNode.left=left;
                }
                root.right=right;
            }else{
                DeleteNode3(root.right,val);
            }
        }
    }
    public static void main(String[]args){
        Node root=new Node(50);
        Node a=new Node(20);
        Node b=new Node(17);
        Node c=new Node(10);
        Node d=new Node(14);
        Node e=new Node(34);
        Node f=new Node(28);
        Node g=new Node(60);
        Node h=new Node(55);
        Node i=new Node(89);
        Node j=new Node(70);
        root.left=a;
        a.left=b;
        b.left=c;
        c.right=d;
        a.right=e;
        e.left=f;
        root.right=g;
        g.left=h;
        g.right=i;
        i.left=j;
        System.out.println("Before Deleting......");
        display(root);
//        DeleteNode1(root,28);
//        DeleteNode2(root,34);
        DeleteNode3(root,50);
        System.out.println("After Deleting........");
        display(root);
    }
}
