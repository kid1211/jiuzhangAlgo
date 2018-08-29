package com.jiuzhang.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
	public Map<Character, Trie> childs;
	public boolean isWord;

	public Trie() {
		childs = new HashMap<>();
		isWord = false;
	}

	public static void addWord(Trie root, String word) {
		Trie curr = root;
		for (char c : word.toCharArray()) {
			if (!curr.childs.containsKey(c)) {
				curr.childs.put(c, new Trie());
			}
			curr = curr.childs.get(c);
		}
		curr.isWord = true;
	}

}
