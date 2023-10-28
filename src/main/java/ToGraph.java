import java.util.*;

class ToGraph {
    private int V;
    private LinkedList<Integer> adjListArray[];

    ToGraph(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
        adjListArray[dest].add(src);
    }

    void printToGraph() {
        for(int v = 0; v < V; v++) {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: adjListArray[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
    }

    static ToGraph convertAdjacencyMatrixToAdjacencyList(int[][] adjacencyMatrix) {
        int V = adjacencyMatrix.length;
        ToGraph ToGraph = new ToGraph(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    ToGraph.addEdge(i, j);
                }
            }
        }
        return ToGraph;
    }

    public static void main(String args[]) {
        int[][] adjacencyMatrix = {
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        
        ToGraph ToGraph = convertAdjacencyMatrixToAdjacencyList(adjacencyMatrix);
        ToGraph.printToGraph();
    }
}
