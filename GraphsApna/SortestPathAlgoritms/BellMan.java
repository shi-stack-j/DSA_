package GraphsApna.SortestPathAlgoritms;

import java.util.ArrayList;

//Here we will se the bellman sortest algorithm
//TC->O(V*E)
//Its TC is greator then
//IT failed in case of Negative Weight Cycle
public class BellMan {
    public static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.des = des;
            this.src = src;
            this.wt = wt;
        }
    }
    public static void CreateGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));
//        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }
    public static void bellmanFord(ArrayList<Edge>[]graph,int src,int v){
        int[]dist=new int[v];
        for(int i=0;i<v;i++){
            if(i==src)continue;
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<v-1;i++){
            for(int j=0;j<v;j++){
                for(int k=0;k<graph[i].size();k++){
                    Edge e=graph[i].get(k);
                    int u=e.src;
                    int V=e.des;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[V]){
                        dist[V]=dist[u]+e.wt;
                    }
                }
            }
        }
        for(var i:dist){
            System.out.print(i+" ");
        }
    }
    public static void main(String[]args){
        int v=5;
        ArrayList<Edge>[]graph=new ArrayList[v];
        CreateGraph(graph);
        bellmanFord(graph,0,v);
    }
}
