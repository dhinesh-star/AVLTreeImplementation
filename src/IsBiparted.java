import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
public class IsBiparted {
    public static void displayGraph(ArrayList<Integer>[] graph){
        System.out.println("Graph Display");
        System.out.println("----------------------------------");
        int idx=0;
        for(ArrayList<Integer> list:graph){
            System.out.println(idx+++"->"+list);
        }
        System.out.println("----------------------------------");
    }
    static class Pair{
        int node;
        int color;
        Pair(int node,int color){
            this.node=node;
            this.color=color;
        }
    }
    public static boolean isBiparted2(ArrayList<Integer>[] graph, int[] visited, int src){
        Queue<Pair> que=new LinkedList<>();
        que.add(new Pair(src,1));
        while(que.size()>0){
            //Remove
            Pair curr=que.remove();
            //Mark
            if(visited[curr.node]!=0){
                continue;
            }
            visited[curr.node]=curr.color;
            //Work
            int oppositeColor=(curr.color==1?2:1);
            //Visit unvisited node
            for(int nbr:graph[curr.node]){
                if(visited[nbr]==0){
                    que.add(new Pair(nbr,oppositeColor));
                }
                else if(visited[nbr]==curr.color){
                    return false;
                }
            }
        }
        return true;
    }
    public static void isBiparted(ArrayList<Integer>[] graph,int vertex){
        int[] visited=new int[vertex+1];
        /**0 -> Means uncolored
         * 1 -> Means Red
         * 2 -> Means Blue*/
        for(int i=1;i<=vertex;i++){
            if(visited[i]==0) {
                boolean checkIsBiparted = isBiparted2(graph, visited, i);
                if(checkIsBiparted==false){
                    System.out.println("Bipartition is not possible in this graph");
                    return ;
                }
            }
        }
        System.out.println("Bipartition is possible in this graph");
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of vertex:- ");
        int vertex=sc.nextInt();
        System.out.print("Enter the number of edges:- ");
        int noOfEdges=sc.nextInt();
        int[][] edges=new int[noOfEdges][2];
        System.out.println("Enter all connection");
        for(int i=0;i<noOfEdges;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        ArrayList<Integer>[] graph=new ArrayList[vertex+1];
        for(int i=1;i<=vertex;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            //Creating undirected graph
            graph[u].add(v);
            graph[v].add(u);
        }
        displayGraph(graph);
        isBiparted(graph,vertex);
    }
}
