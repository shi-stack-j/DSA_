package Tree;
import java.util.ArrayList;
//Here we will se the path sum questions of binary trees
public class PathSum1 {
    public static class Node{
        int val;
        Node right;
        Node left;
        public Node(int val){
            this.val=val;
        }
    }
    public static void pathSum(Node root,int target,int sum){
        if(root==null)return;
        if(root.left==null && root.right==null){
            sum+=root.val;
            if(target==sum){
                System.out.println("Sum is :- "+sum);
                return;
            }
        }
        pathSum(root.left,target,sum+root.val);
        pathSum(root.right,target,sum+root.val);
    }
    public static void pathSum2(Node root,int target,String str,ArrayList<String> lp){
        if(root==null)return;
        if(root.left==null && root.right==null){
            if(target-root.val==0){
                str+=root.val;
                lp.add(str);
            }
        }
        pathSum2(root.left,target-root.val,str+root.val+"->",lp);
        pathSum2(root.right,target-root.val,str+root.val+"->",lp);
    }
    //This function is used to calculate all the paths from the particular node
    public static int RootsPath(Node root,int TargetSum){
        if(root==null)return 0;
        int count=0;
        if(root.val==TargetSum){
            count++;
        }
        int left=RootsPath(root.left,TargetSum-root.val);
        int right=RootsPath(root.right,TargetSum-root.val);
        return count+left+right;

    }
    //This function is used to calculate the path from ech node
    public static int pathSum3(Node root,int TargetSum){
        if(root==null)return 0;
        int count=RootsPath(root,TargetSum);
        int leftCount=pathSum3(root.left,TargetSum);
        int rightCount=pathSum3(root.right,TargetSum);
        return count+leftCount+rightCount;

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
        System.out.println("PathSum 3 :- "+pathSum3(root,4));

    }
}
