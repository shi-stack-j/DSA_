package Tree;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
//Here we will see the question where will find the total time taken to infect the full binary tree
public class MinimumTimeToInfectTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val=val;
        }
    }
    //This method is used to return the node given that is already infected
    public static Node getNode(Node root,int Target){
        if(root==null)return null;
        if(root.val==Target)return root;
        Node left=getNode(root.left,Target);
        Node right=getNode(root.right,Target);
        if(left!=null)return left;
        else return right;
    }
    //This method is used to create the hashmap of the each node with their parent maped in the hashmap
    public static void ParentMap(Node root,Map<Node,Node>parentMap){
        if(root==null)return;
        if(root.left!=null)parentMap.put(root.left,root);
        if(root.right!=null)parentMap.put(root.right,root);
        ParentMap(root.left,parentMap);
        ParentMap(root.right,parentMap);
    }
    public static int infectTree(Node root,int Target){
        if(root==null)return 0;
        Map<Node,Node>parentMap=new HashMap<>();
        //This will create the parent HashMap
        ParentMap(root,parentMap);
        Node get=getNode(root,Target);//This method will return the infected node given in the starting
        Map<Node,Integer>LevelMap=new HashMap<>();//This will store the node and the level of node
        LevelMap.put(root,0);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            Node temp=q.peek();
            int level=LevelMap.get(temp);//This is the level of the current node
            if(temp.right!=null && !(LevelMap.containsKey(temp.right))){
                LevelMap.put(root.right,level+1);
                q.add(root.right);
            }
            if(temp.left!=null && !(LevelMap.containsKey(temp.left))){
                LevelMap.put(root.left,level+1);
                q.add(root.left);
            }
            if(parentMap.containsKey(root) && !(LevelMap.containsKey(parentMap.get(root)))){
                LevelMap.put(parentMap.get(root),level+1);
                q.add(parentMap.get(root));
            }
            q.remove();
        }
        int max=-1;
        for(var i:LevelMap.values()){
            if(i>=max){
                max=i;
            }
        }
        return max;
    }
    public static void main(String[]args){

    }
}
