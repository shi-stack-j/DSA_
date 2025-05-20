package GraphsApna;
import java.util.*;
//here we will see the code to check the cycle in the Undirected graph
//The condition for the cycle in the undirected graph is
//The the child of the curr node should be visited and not the parent of current child
public class CycleDetection {
    public static class Edge{
        int src;
        int des;
        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    public static void CreateGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
//        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));

        graph[4].add(new Edge(4,0));
//        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));

    }
    /***
     * This method is used check for the cycle in the undirected graph
     * 1->We will mark the curr as true in visited array
     * 2->We will traverse the each child of the curr
     * 3->We will check for the each child that
     * 4->If child is already visited and is not the parent of the curr then their is cycle in graph
     * 5->If child is not the visited then we will call the function by pass child as curr and return what that call will return
     * @param graph :->The List of ArrayList of Edge
     * @param vis :->The Array Which will mark the visited element as true
     * @param cur :->The Curr element for which we are checking for child and visiting
     * @param par :->The par of th current vertex
     * @return :-> TRUE if cycle otherwise FALSE
     */
    public static boolean DetectCycle(ArrayList<Edge>graph[],boolean[]vis,int cur,int par){
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(vis[e.des] && e.des!=par){
                return true;
            }else if(!vis[e.des]){
                if(DetectCycle(graph,vis,e.des,cur)){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[]args){
        int v=6;
        ArrayList<Edge>[]graph=new ArrayList[v];
        CreateGraph(graph);
        System.out.println(DetectCycle(graph,new boolean[v],0,0));
    }
}
