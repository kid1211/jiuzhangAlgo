package com.jiuzhang.model;

import com.jiuzhang.basic.Bag;

public class Graph {

	private final int V; // node number
	private int E; // edge number;
	private Bag<Integer>[] adj; // edge list

	public Graph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<>();
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void daddEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
