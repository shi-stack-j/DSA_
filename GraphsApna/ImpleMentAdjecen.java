package GraphsApna;
import java.util.ArrayList;
//Here we will see the implementation of graph Data Structure using Adjency List
//Here we will store the vertex with their all connection using
//List of Arraylist of DataType Edge
public class ImpleMentAdjecen {
    //This class is for unwighted graph
    public static class Edge{
        int src;
        int des;
        public Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }
    public static void CreateGraph(ArrayList<Edge>graph[]){
        //At this time list contains null value at every index and in java
        //we can not place items in place of null so we will first
        //Create the empty ArrayList<Edge> at every place
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
    }
    public static void main(String[]args){
        int Number_vertex=4;
        //Here we have created the list of arrayList of datatype Edge
        ArrayList<Edge> graph[] =new ArrayList[Number_vertex];
        CreateGraph(graph);
        for(int i=0;i<graph[1].size();i++){
            System.out.println("Des :- "+graph[1].get(i).des);
        }
    }
}
