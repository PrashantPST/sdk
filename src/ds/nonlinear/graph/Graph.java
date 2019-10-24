package ds.nonlinear.graph;

import java.util.ArrayList;

class Graph {
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    private static int vertices;

    private static ArrayList<Integer>[] graph = new ArrayList[vertices];

    private Graph(int[][] edges) {
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            addEdge(graph, u, v);
        }
    }




    private static int[] rowNbr = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static int[] colNbr = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    // Adds an edge to an undirected graph
    private void addEdge(ArrayList<Integer>[] graph, int src, int dest) {
        // Add an edge from src to dest.
        graph[src].add(dest);

        // If the given graph is undirected one, add an edge from dest to src also
        graph[dest].add(src);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v+" ");

        for (int x : graph[v]) {
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
        boolean[] visited = new boolean[vertices];
        for(int v = 0; v < vertices; ++v) {
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

    private static boolean DFSUtil(int u, int[] color) {
        color[u] = GRAY;

        for (Integer in : graph[u]) {
            if (color[in] == GRAY)
                return true;
            if (color[in] == WHITE && DFSUtil(in, color))
                return true;
        }
        color[u] = BLACK;
        return false;
    }

    static boolean isCyclic(Graph g) {

        int[] color = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            if (color[i] == WHITE) {
                if(DFSUtil(i, color))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] M = new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
    }
}

