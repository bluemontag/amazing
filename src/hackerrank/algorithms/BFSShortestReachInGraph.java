/**
 * 
 */
package hackerrank.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BFSShortestReachInGraph {
	public static class Graph {

		int[][] graph;
		int n = 0;
		
		public Graph(int n) {

			graph = new int[n][n];
			this.n = n;
			
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (i==j) 
						graph[i][j]=0;
					else
						graph[i][j]=-1;
				}
			}
			
		}

		public void addEdge(int first, int second) {
			graph[first][second] = 6;
			graph[second][first] = 6;
		}

		private List<Integer> adjacent(int s) {
			List<Integer> res = new ArrayList<Integer>();
			
			for (int i=0; i<n; i++) {
				if (s!=i && graph[s][i]>0)
					res.add(i);
			}
			return res;
		}
		
		public int[] shortestReach(int s) { // 0 indexed
			List<Integer> nextToVisit = new ArrayList<Integer>();
			List<Integer> visited = new ArrayList<Integer>();
			
			int[] minDistFromS = new int[n];
			
			for (int i=0; i<n; i++) {
				if (graph[s][i]==-1) {
					minDistFromS[i] = -1;
				} else {
					minDistFromS[i] = graph[s][i];//0, 6 or -1 depending on the case
				}
			}
			
			nextToVisit.add(s);
			
			while (!nextToVisit.isEmpty()) {
				
				int node = nextToVisit.remove(0);
				
				if (visited.contains(node)) {
					continue;
				}
				visited.add(node);//mark as visited
				
				List<Integer> adjs = this.adjacent(node);
				
				for (int adj : adjs) {
					int temp = minDistFromS[adj]==-1?Integer.MAX_VALUE:minDistFromS[adj];
					
					if (graph[node][adj]+minDistFromS[node]<temp) {
						minDistFromS[adj] = graph[node][adj]+minDistFromS[node];
					}
					if (!visited.contains(adj)) {
						nextToVisit.add(adj);
					}
				}
			}
			
			return minDistFromS;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int queries = scanner.nextInt();

		for (int t = 0; t < queries; t++) {

			// Create a graph of size n where each edge weight is 6:
			Graph graph = new Graph(scanner.nextInt());
			int m = scanner.nextInt();

			// read and set edges
			for (int i = 0; i < m; i++) {
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;

				// add each edge to the graph
				graph.addEdge(u, v);
			}

			// Find shortest reach from node s
			int startId = scanner.nextInt() - 1;
			int[] distances = graph.shortestReach(startId);

			for (int i = 0; i < distances.length; i++) {
				if (i != startId) {
					System.out.print(distances[i]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		scanner.close();
	}
}