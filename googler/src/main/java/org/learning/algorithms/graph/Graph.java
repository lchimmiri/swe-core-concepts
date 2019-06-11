package org.learning.algorithms.graph;

import java.util.LinkedList;

public class Graph {

	private int v;
	private LinkedList<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// Time Complexity: O(V+E)
	public void BFS(int s) {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);

		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(s + " ");

			for (int i : adj[s]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}

		}
	}

	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		for (int n : adj[v]) {
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	// Time Complexity: O(V+E)
	void DFS(int s) {
		boolean[] visited = new boolean[v];
		DFSUtil(s, visited);
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.DFS(2);
	}
}
