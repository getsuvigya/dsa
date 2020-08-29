package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphImpl implements Graph{
    int [][] adjacentMatrix;
    int vertices;
    int [] visited = new int[vertices];
    Graph.GRAPHTYPE graphtype = Graph.GRAPHTYPE.DIRECTED;

    public GraphImpl(int vertices, Graph.GRAPHTYPE graphtype){
        this.vertices = vertices+1;
        this.graphtype = graphtype;
        adjacentMatrix = new int[this.vertices][this.vertices];
        visited = new int[this.vertices];
    }

    public static void main(String[] args) {
        GraphImpl graph = new GraphImpl(7,GRAPHTYPE.UNDIRECTED);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(3,7);
        graph.addEdge(3,6);
        graph.addEdge(6,5);
        graph.addEdge(6,4);
        graph.addEdge(4,5);
        graph.bfs(graph.visited,graph,1);
        System.out.println("===================");
        graph.visited = new int[graph.vertices];
        graph.dfs(graph.visited,graph,1);
    }

    @Override
    public void addEdge(int v1, int v2) {
        if(v1<0 || v1>=vertices || v2<0 || v2>=vertices){
            throw new IllegalArgumentException("Number of vertices incorrect");
        }
        adjacentMatrix[v1][v2]=1;
        if(this.graphtype.equals(GRAPHTYPE.UNDIRECTED)){
            adjacentMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int v1) {
        if(v1<0 || v1>=vertices){
            throw new IllegalArgumentException("Vertes is incorrect");
        }
        List<Integer> adjacentVertices = new ArrayList<>();
        for(int i=1; i<vertices; i++){
            if(adjacentMatrix[v1][i]==1){
                adjacentVertices.add(i);
            }
        }
        return adjacentVertices;
    }

    public void bfs(int visited[], Graph graph, int currentVertex){

        if(currentVertex<0 || currentVertex>vertices){
            throw new IllegalArgumentException("Vertes is incorrect");
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(currentVertex);
        while(!q.isEmpty()){
            int k = q.remove();
            if(visited[k]==1){
                continue;
            }
            visited[k]=1;
            System.out.println(k);
            List<Integer> adjacencyList = graph.getAdjacentVertices(k);
            for (Integer neighbor:adjacencyList) {
                q.add(neighbor);
            }
        }
    }

    public void dfs(int visited[], Graph graph, int currentVertex){
        if(visited[currentVertex]==1){
            return;
        }
        visited[currentVertex]=1;
        System.out.println(currentVertex);
        List<Integer> adjacencyList = graph.getAdjacentVertices(currentVertex);
        for(int vertex: adjacencyList){
            dfs(visited,graph,vertex);
        }
    }
}
