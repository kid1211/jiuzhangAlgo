package com.jiuzhang.model;

import java.util.ArrayList;
import java.util.List;

public class TrieII {

	TrieNode root;

	public  TrieII(String[] words) {
		root = new TrieNode();
		for (String w : words) {
			TrieNode cur = root;
			for (char c : w.toCharArray()) {
				int idx = c - 'a';
				if (cur.children[idx] == null) {
					cur.children[idx] = new TrieNode();
				}
				cur.children[idx].startWith.add(w);
				cur = cur.children[idx];
			}
		}
	}

	public List<String> findByPrefix(String prefix) {
		List<String> ans = new ArrayList<>();
		TrieNode cur = root;
		for (char c : prefix.toCharArray()) {
			int idx = c - 'a';
			if (cur.children[idx] == null) {
				return ans;
			}
			cur = cur.children[idx];
		}
		ans.addAll(cur.startWith);
		return ans;
	}
}

