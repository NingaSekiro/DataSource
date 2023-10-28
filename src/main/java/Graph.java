import java.util.*;

/**
 * 2022-04-02
 */
class Graph {
    private int V;
    private LinkedList<Integer> adjListArray[];

    Graph(int V) {
        this.V = V;
        adjListArray = new LinkedList[V];
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
    }

    void printAllPaths(int s, int d) {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(s);
        printAllPathsUtil(s, d, isVisited, pathList);
    }

    private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {
        isVisited[u] = true;
        if (u.equals(d)) {
            System.out.println(localPathList);
        }
        for (Integer i : adjListArray[u]) {
            if (!isVisited[i]) {
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList);
                localPathList.remove(i);
            }
        }
        isVisited[u] = false;
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        System.out.println("Following are all different paths from " + 2 + " to " + 3);
        g.printAllPaths(2, 3);
    }
}
