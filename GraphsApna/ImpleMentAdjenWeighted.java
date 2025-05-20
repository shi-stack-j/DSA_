package GraphsApna;
import java.util.ArrayList;
//Here we will see the wighted graph
public class ImpleMentAdjenWeighted {
    public static class Edge{
        int src;
        int des;
        int weight;
        public Edge(int src,int des,int weight){
            this.src=src;
            this.des=des;
            this.weight=weight;
        }
    }
    public static void CreateWightedGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));
    }
    public static void main(String[]args){
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        CreateWightedGraph(graph);

        for(int i=0;i<graph[2].size();i++){
            System.out.println("Src :- "+graph[2].get(i).src+" | Des :- "+graph[2].get(i).des+" | Weight :- "+graph[2].get(i).weight);
        }
    }
}
