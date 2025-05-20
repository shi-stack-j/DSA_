package GraphsApna;
import java.util.ArrayList;
//Here we are going to see  the questions of Graph
public class QuestionsOnGraph {
    public static class Edge{
        int src;
        int des;
        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    public static void DFS(ArrayList<Edge>graph[],int curr,boolean[]vis){
        if(curr==5){
            System.out.println(5);
            return;
        }
        System.out.println(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.des]==false){
                DFS(graph,e.des,vis);

            }
        }
    }
    //TimeComplexity->O(V^V)
    public static void PrintPathSrDes(ArrayList<Edge>graph[],int curr,boolean[]vis,String st,int des){
        if(curr==des){
            System.out.println(st);
            return;
        }
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[curr]==false){
                vis[curr]=true;
                PrintPathSrDes(graph,e.des,vis,st+e.des,des);
                vis[curr]=false;
            }
//
        }
    }
    public static boolean DetectCycleInDirectedGraph(ArrayList<Edge>graph[],int curr,boolean[]vis,boolean[]rec){
          vis[curr]=true;
          rec[curr]=true;
          for(int i=0;i<graph[curr].size();i++){
              Edge e=graph[curr].get(i);
              if(rec[e.des]){
                  return true;//Cycle deteced
              }else if(!vis[e.des]){
                  if(DetectCycleInDirectedGraph(graph,e.des,vis,rec)){
                      return true;
                  }
              }
          }
          rec[curr]=false;
          return false;
    }
    public static void CreateGraph(ArrayList<Edge>graph[]){
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
    public static void main(String[]args){
        int v=7;
        ArrayList<Edge>[]graph=new ArrayList[v];
        CreateGraph(graph);
        boolean[]vis=new boolean[v];
//        DFS(graph,0,vis);
        PrintPathSrDes(graph,0,vis,"0",5);
        
    }
}
