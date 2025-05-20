package GraphsApna;
import java.util.*;
//Here we are going to see the topological sorting in topological
//This can only we used in DirectedAcyclicGraph
//DAG->The graph that are directed but do not contains cycle
//It is used to show the dependency
//Example ->
//Action-1->Buy A Laptop
//Action-2->Install Os
//Action-3->Install Code Editor
//Action-4->Install Java
//Action-5->Write The Code
//Here in this example we cann not directly insatll the os without buing the laptop
//We cannot install the code Editor without installing the os
//We cannot wirte the code without isnalling code editor
//So the topological sorted order of this example is ->
/*
        1->2->3->4->5
            or
        1->2->4->3->5
 */
//We implement the topological sort using the DFS approch  by just chaging few lines in code
public class TopologicalSorting {
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
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    public static void topoSortUtil(ArrayList<Edge>graph[],boolean[]vis,int cur,Stack<Integer>st){
        vis[cur]=true;

        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.des]){
                topoSortUtil(graph,vis,e.des,st);
            }
        }
        st.push(cur);
    }
    public static void topoSort(ArrayList<Edge>graph[],int v){
        Stack<Integer>st=new Stack<>();
        boolean[]vis=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                topoSortUtil(graph,vis,i,st);
            }
        }

        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }
    public static void main(String[]args){
        int v=6;
        ArrayList<Edge>[]graph=new ArrayList[v];
        CreateGraph(graph);
        topoSort(graph,v);
    }
}
