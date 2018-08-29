package com.jiuzhang.model;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
	public List<String> startWith;
	public TrieNode[] children;

	TrieNode() {
		startWith = new ArrayList<String>();
		children = new TrieNode[26];
	}
}