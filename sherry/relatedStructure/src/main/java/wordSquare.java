import com.jiuzhang.model.TrieII;

import java.util.ArrayList;
import java.util.List;

public class wordSquare {

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> ans = new ArrayList<>();

		if (words == null || words.length == 0) {
			return ans;
		}
		int len = words[0].length();
		TrieII trie = new TrieII(words);
		List<String> ansBuilder = new ArrayList<>();
		for (String w : words) {
			ansBuilder.add(w);
			search(len, trie, ans, ansBuilder);
			ansBuilder.remove(ansBuilder.size() - 1);
		}
		return ans;
	}

	private void search(int len, TrieII trie, List<List<String>> ans, List<String> ansBuilder) {
		if (ansBuilder.size() == len) {
			ans.add(new ArrayList<>(ansBuilder));
			return;
		}
		//[ball, area] -> idx = 2 -> prefix = le -> find all word start with le -> [lead]
		int idx = ansBuilder.size();// the size of current combination
		StringBuilder prefixBuilder = new StringBuilder();
		for (String s : ansBuilder) {
			prefixBuilder.append(s.charAt(idx));
		}
		//find the word start with next index -> le -> [lead]
		List<String> startWith = trie.findByPrefix(prefixBuilder.toString());
		for (String sw : startWith) {
			//[ball, area, lead]
			ansBuilder.add(sw);
			//lad -> [lady] -> len = 4, -> find the combination
			search(len, trie, ans, ansBuilder);
			ansBuilder.remove(ansBuilder.size() - 1);
		}
	}
}
