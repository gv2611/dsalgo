package breaker;

import java.util.*;

class Graph {
	private int num_nodes;
	private Map<Integer, ArrayList<Integer>> adj;
	boolean visited[];
	int parent[];
	int component[];
	int c;
	
	Graph(int num_nodes) {
		this.num_nodes = num_nodes;
		adj = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < this.num_nodes; i++) {
			adj.put(i, new ArrayList<Integer>());
		}
		c = 0;
		this.reset();
	}
	
	void reset() {
		visited = new boolean[num_nodes];
		parent = new int[num_nodes];
		component = new int[num_nodes];
		for (int i = 0; i < this.num_nodes; i++) {
			visited[i] = false;
			parent[i] = 0;
			component[i] = 0;
		}
	}
	
	void add_edge(int u, int v) {
		ArrayList<Integer> edges_u = adj.get(u);
		ArrayList<Integer> edges_v = adj.get(v);
		edges_u.add(v);
		edges_v.add(u);
	}
	
	boolean has_edge(int u, int v) {
		return adj.get(u).contains(v);
	}
	
	void bfs(int start) {
		if (this.visited[start]) {
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int u = q.poll();
			if (visited[u]) {
				continue;
			}
			System.out.println(u);
			visited[u] = true;
			component[u] = start;
			
			for (int child: this.adj.get(u)) {
				if (!visited[child]) {
					q.add(child);
					parent[child] = u;
				}
			}
		}	
	}	
	
	void dfs(int u, int c) {
		if (visited[u]) {
			return;
		}
		visited[u] = true;
		component[u] = c;
		System.out.println(u);
		for (int child: this.adj.get(u)) {
			if (!visited[child]) {
				parent[child] = u;
				this.dfs(child, c);
			}
		}
	}
	
	void print(int[] arr) {
		for (int x: arr) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}
	void print(boolean[] arr) {
		for (boolean x: arr) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}
	void debug() {
		this.print(this.parent);
		this.print(this.component);
		this.print(this.visited);
	}
}

public class Test {
	public static void main(String[] args) {
		int num_nodes = 10;
		Graph g = new Graph(num_nodes);
		g.add_edge(1, 5);
		g.add_edge(1, 2);
		g.add_edge(2, 5);
		g.add_edge(2, 3);
		g.add_edge(3, 4);
		g.add_edge(4, 5);
		g.add_edge(4, 6);
		g.add_edge(7, 8);
		g.add_edge(7, 9);
		
		for (int i = 1; i < num_nodes; i++) {
			g.bfs(i);
			g.debug();
		}
		g.reset();
		
		System.out.println("-----------------");
		
		int component = 1;
		for (int i = 1; i < num_nodes; i++) {
			g.dfs(i, component);
			component++;
			g.debug();
		}
		g.reset();
	}
}
