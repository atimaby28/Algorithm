package pairGraph;

import java.util.Arrays;

public class FloydWarshall {
    public static void floydWarshall(int n, int[][] graph) {
        int[][] dist = new int[n][n];

        // Initialize distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) dist[i][j] = 0; // Distance to self is 0
                else dist[i][j] = (graph[i][j] != 0) ? graph[i][j] : Integer.MAX_VALUE;
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Print the shortest distances
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }
    }

    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int[][] graph = {
                {0, 3, 0, 7},
                {8, 0, 2, 0},
                {5, 0, 0, 1},
                {2, 0, 0, 0}
        };

        floydWarshall(n, graph);
    }
}
