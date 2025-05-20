package GraphsApna;
import java.util.ArrayList;
import java.util.PriorityQueue;
//Here we will se the minimum spanning tree using prims algorithm
public class MST {
    public static class Edge{
        int dest;
        int src;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    /***
     * This is the Pair class which is used to store node and cost
     * We make this class comparable because we will store this class object in priority queue
     * To get the minimum cost element every time we used Priority Queue because it sort on the bases of Cost
     * Node :- The curr node on which we are
     * Cost :- The cost taken to reach the node
     */
    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;
        public Pair(int node,int cost){
            this.cost=cost;
            this.node=node;
        }
        @Override
        public int compareTo(Pair p){
            return this.cost-p.cost;
        }
    }
    public static void CreateGraph(ArrayList<Edge>[]graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }
    /***
     *  Here we will add the element pairs with their node and cost in the priority queue
     *  Then we will romve the first univisted and minimum cost node
     *  Then we will add the node int the mstCost
     */
    public static void PrimsAlgo(ArrayList<Edge>[]graph,int src,int v){
        boolean[]vis=new boolean[v];
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
        pq.add(new Pair(0,0));
        int mstcost=0;
        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            if(!vis[cur.node]){
                vis[cur.node]=true;
                mstcost+=cur.cost;
                for(int i=0;i<graph[cur.node].size();i++){
                    Edge e=graph[cur.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println("Min cost od mst = "+mstcost);
    }
    public static void main(String[]args){
        int V=4;
        ArrayList<Edge>[]graph=new ArrayList[V];
        CreateGraph(graph);
        PrimsAlgo(graph,0,V);
    }
}
