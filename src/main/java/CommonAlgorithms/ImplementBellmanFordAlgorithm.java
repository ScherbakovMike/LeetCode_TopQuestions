package CommonAlgorithms;

import java.util.Arrays;

public class ImplementBellmanFordAlgorithm {

  // The main function that finds shortest
  // distances from src to all other vertices
  // using Bellman-Ford algorithm. The function
  // also detects negative weight cycle
  // The row graph[i] represents i-th edge with
  // three values u, v and w.
  static void BellmanFord(int[][] graph, int nodes, int edges, int src) {
    // Initialize distance of all vertices as infinite.
    var distance = new int[nodes];
    Arrays.fill(distance, Integer.MAX_VALUE);

    // initialize distance of source as 0
    distance[src] = 0;

    // Relax all edges |V| - 1 times. A simple
    // shortest path from src to any other
    // vertex can have at-most |V| - 1 edges
    for (var i = 0; i < nodes - 1; i++) {
      for (var j = 0; j < edges; j++) {
        var node1 = graph[j][0];
        var node2 = graph[j][1];
        var weight12 = graph[j][2];
        if (distance[node1] != Integer.MAX_VALUE
            && (distance[node1] + weight12 < distance[node2])) {

          distance[node2] = distance[node1] + weight12;
        }
      }
    }

    // check for negative-weight cycles.
    // The above step guarantees shortest
    // distances if graph doesn't contain
    // negative weight cycle. If we get a
    // shorter path, then there is a cycle.
    for (var i = 0; i < edges; i++) {
      var node1 = graph[i][0];
      var node2 = graph[i][1];
      var weight12 = graph[i][2];
      if (distance[node1] != Integer.MAX_VALUE && distance[node1] + weight12 < distance[node2]) {
        System.out.println("Graph contains negative weight cycle");
        break;
      }
    }

    System.out.println("Vertex Distance from Source");
    for (var i = 0; i < nodes; i++) {
      System.out.println(i + "\t\t" + distance[i]);
    }
  }

  // Driver code
  public static void main(String[] args) {
    var vertices = 5; // Number of vertices in graph
    var edges = 8; // Number of edges in graph

    // Every edge has three values (u, v, w) where
    // the edge is from vertex u to v. And weight
    // of the edge is w.
    var graph =
        new int[][] {
          {0, 1, -1},
          {0, 2, 4},
          {1, 2, 3},
          {1, 3, 2},
          {1, 4, 2},
          {3, 2, 5},
          {3, 1, 1},
          {4, 3, -3}
        };

    BellmanFord(graph, vertices, edges, 0);
  }
}
