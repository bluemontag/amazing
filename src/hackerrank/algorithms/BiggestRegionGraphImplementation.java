package hackerrank.algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Graph {
	private Map<Integer, Node> lookUpNode = new HashMap<Integer, Node>();

	static class Node {
		int id;
		List<Node> adjacent = new LinkedList<Node>();

		public Node(int data) {
			this.id = data;
		}
	}

	public Node addNode(int id) {
		Node result = getNode(id);
		if (result == null) {
			result = new Node(id);
			this.lookUpNode.put(new Integer(id), result);
		}

		return result;
	}

	public Node getNode(int id) {
		Node result = this.lookUpNode.get(new Integer(id));

		return result;
	}

	public void addEdge(int source, int destination) {
		Node a = addNode(source);
		Node b = addNode(destination);

		a.adjacent.add(b);
		b.adjacent.add(a);
	}

	public int largestPath(int source) {
		Node s = getNode(source);

		Set<Integer> visited = new HashSet<Integer>();
		Integer curSize = new Integer(0);
		return largestPath(s, visited, curSize);
	}

	private int largestPath(Node s, Set<Integer> visited, Integer curSize) {
		if (visited.contains(s.id))
			return 0;

		visited.add(s.id);

		for (Node child : s.adjacent) {

			int fromChild = largestPath(child, visited, new Integer(curSize + 1));

			if (fromChild > curSize) {
				curSize = new Integer(fromChild);
			}
		}
		return curSize;
	}
}

public class BiggestRegionGraphImplementation {

	public static int getBiggestRegion(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		Graph g = new Graph();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					g.addEdge(i, j);
				}
			}
		}

		for (int i = 0; i<rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (g.getNode(i)!=null) {
				
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		System.out.println(getBiggestRegion(grid));

//		Graph g = new Graph();
//		g.addEdge(1, 2);
//
//		g.addEdge(2, 3);
//
//		g.addEdge(3, 4);
//
//		g.addEdge(2, 4);
//		
//		g.addEdge(4, 5);
//
//		System.out.println(g.largestPath(1));
		 in.close();
	}

}
