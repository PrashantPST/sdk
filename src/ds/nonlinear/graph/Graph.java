package ds.nonlinear.graph;

import java.util.LinkedList;
class Graph {
    private int V;
    private LinkedList<Integer>[] adjListArray;

    private static int[] rowNbr = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static int[] colNbr = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    private Graph(int V) {
        this.V = V;
        // define the size of array as
        // number of vertices
        adjListArray = new LinkedList[V];

        for(int i = 0; i < V ; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    // Adds an edge to an undirected graph
    private void addEdge(int src, int dest) {
        // Add an edge from src to dest.
        adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest to src also
        adjListArray[dest].add(src);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+" ");

        for (int x : adjListArray[v]) {
            if(!visited[x]) {
                DFSUtil(x, visited);
            }
        }
    }

    /**
     * Counting the number of connected components in an undirected graph
     */
    private int connectedComponents() {
        int count = 0;
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; ++v) {
            if(!visited[v]) {
                DFSUtil(v, visited);
                // The number of calls to DFSUtil() = number of connected components.
                count++;
                System.out.println();
            }
        }
        return count;
    }

    private static boolean isSafe(int[][] M, int row, int col, boolean[][] visited, int ROW, int COL) {

        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }

    private static void DFS(int[][] M, int row, int col, boolean[][] visited, int ROW, int COL) {

        visited[row][col] = true;

        for (int k = 0; k < 8; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
            }
        }
    }

    private static int countIslands(int[][] M, int ROW, int COL) {

        boolean[][] visited = new boolean[ROW][COL];
        int count = 0;

        for (int i = 0; i < ROW; ++i) {
            for (int j = 0; j < COL; ++j) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    DFS(M, i, j, visited, ROW, COL);
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] M = new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };

        Graph g = new Graph(5); // 5 vertices numbered from 0 to 4

        g.addEdge(1, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        System.out.println("Following are connected components");
        System.out.println("Count of connected components = "+g.connectedComponents());

        System.out.println("Number of islands = "+countIslands(M, 5, 5));
    }
}

