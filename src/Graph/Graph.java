package Graph;

import java.util.List;

public interface Graph {
   enum GRAPHTYPE{
        DIRECTED, UNDIRECTED;
    }
    void addEdge(int v1, int v2);
    List<Integer> getAdjacentVertices(int v1);
}
