package GraphsApna.SortestPathAlgoritms;
import java.util.ArrayList;
import java.util.PriorityQueue;
//DrawBack->It failed to give  correct answer in case of negative weight
//Here we will see the first algorithm
public class Dijkastras {
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
    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node,int wt){
            this.node=node;
            this.dist=wt;
        }
        @Override
        public int compareTo(Pair p){
            return this.dist-p.dist;
        }
    }
    public static void Dijakst(ArrayList<Edge>graph[],int v,int src){
        int[]dist=new int[v];
        //This loop is for making the maximum value at all the indexes acc
        for(int i=0;i<v;i++){
            if(src==i)continue;
            dist[i]=Integer.MAX_VALUE;
        }
        boolean[]vis=new boolean[v];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            if(!vis[cur.node]){
                vis[cur.node]=true;
                for(int i=0;i<graph[cur.node].size();i++){
                    Edge e=graph[cur.node].get(i);
                    int u=e.src;
                    int de=e.des;
                    if(dist[u]+e.wt<dist[de]){
                        dist[de]=dist[u]+e.wt;
                        pq.add(new Pair(de,dist[de]));
                    }
                }
            }
        }
        for(int i=0;i<v;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void CreateGraph(ArrayList<Edge>graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }
    public static void main(String[]args){
        int v=6;
        ArrayList<Edge>[]graph=new ArrayList[v];
        CreateGraph(graph);
        Dijakst(graph,v,0);
    }
}
