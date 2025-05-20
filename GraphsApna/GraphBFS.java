package GraphsApna;
import java.util.*;
//Here we are going to see the BFS algorithm to traverse in Graph
public class GraphBFS {
    public static class Edge{
        int src;
        int des;
        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    //Here we are creating the graph
    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));
    }
    //Here we are doing BFS to travers Graph
    /**
     * Here we have created the function for BFS
     * BFS->Breadth First Search
     * TimeComplexity->O(V+K)
     * here first we create the queue of the element of graph
     * First we store the first element in the queue and then we will start the loop
     * Till the queue dosenot get empty and we will also take the Array Visited which will mark
     * The each element which is visited as true
     * @param graph :- Array of the Graph
     * @param v :- Vertices(Single node of graph) of graph
     */
    public static void BFS(ArrayList<Edge>graph[],int v){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[v];
        q.add(0);
        while(!q.isEmpty()){
            int cur=q.remove();
            if(vis[cur]==false){
                System.out.print(cur+" ");
                vis[cur]=true;

                for(int i=0;i<graph[cur].size();i++){
                    Edge e=graph[cur].get(i);
                    q.add(e.des);
                }
            }
        }
    }
    /**
     * Here we have created the function for DFS
     * DFS->Depth First Search
     * Here we will first traverse the each child of every node
     * Mark the visitied node as true
     * @param graph :- Array Of Graph
     * @param curr :- The current node which currently we are
     * @param vis :- The array which will mark the visited elemts as true
     */
    public static void DFS(ArrayList<Edge>graph[],int curr,boolean[]vis){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            int des=e.des;
            if(vis[des]==false){
                DFS(graph,des,vis);
            }
        }

    }
    public static void main(String[]args){
        int v=7;
        ArrayList<Edge>graph[]=new ArrayList[v];
        createGraph(graph);
        BFS(graph,v);
        System.out.println();
        boolean[]vis=new boolean[v];
        DFS(graph,0,vis);

    }
}
