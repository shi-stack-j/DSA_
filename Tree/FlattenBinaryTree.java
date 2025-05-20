package Tree;
import java.util.ArrayList;

public class FlattenBinaryTree {
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
    public static void flattenTree(Node root,ArrayList<Node>po){
        if(root==null)return;
        po.add(root);
        flattenTree(root.left,po);
        flattenTree(root.right,po);
    }
    public static Node Flat(ArrayList<Node>po){
        if(po.isEmpty())return null;
        Node ro=new Node(po.getFirst().val);
        Node tem=ro;
        po.removeFirst();
        while(!po.isEmpty()){
            Node temp=new Node(po.getFirst().val);
            tem.right=temp;
            tem=temp;
            po.removeFirst();
        }
        return ro;
    }
    public static Node falttre(Node root){
        if(root==null )return null;
        if((root.left==null && root.right==null))return root;
        falttre(root.left);
        falttre(root.right);
        if(root.left!=null && root.right!=null){
            Node temp=root.right;
            if(root.left.right!=null){
                Node nlr=root.left.right;
                while(nlr.right!=null) {
                    nlr = nlr.right;
                }
                nlr.right=temp;
            }else{
                root.left.right=temp;
            }
            root.right=root.left;
            root.left=null;
        }else if(root.left!=null && root.right==null){
            root.right=root.left;
            root.left=null;
        }else if(root.left==null && root.right!=null){
            return root;
        }
        return root;
    }
    public static void FlattenTreeMethod2(Node root){
        if(root==null)return;
        Node cn=root;
        while(cn!=null){
            if(cn.left!=null){
                Node predec=cn.left;
                while(predec.right!=null){
                    predec=predec.right;
                }
                predec.right=cn.right;
                cn.right=cn.left;
                cn.left=null;
            }
            cn=cn.right;
        }
    }
    public static void FlattenTreeSir(Node root){
        if(root==null)return;
        Node left=root.left;
        Node right=root.right;
        root.left=null;
        FlattenTreeSir(left);
        FlattenTreeSir(right);
        root.right=left;
        Node temp=root.right;
        while(temp!=null && temp.right!=null){
            temp=temp.right;
        }
        if(temp!=null)temp.right=right;
        else root.right=right;
        return;
    }
    public static void main(String[]args){
        Node root=new Node(1);
        //Creating more nodes
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
//        ArrayList<Node> po=new ArrayList<>();
        display(root);
//        flattenTree(root,po);
//        for(var i :po){
//            System.out.print(i.val+" -> ");
//        }
//        System.out.println();
//        display(Flat(po));
//        falttre(root);
//        FlattenTreeSir(root);
        FlattenTreeMethod2(root);
        display(root);
    }
}
