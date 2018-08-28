import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	public ArrayList<String> wordBreakII(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused
		// by each test case.
		Map<String, ArrayList<String>> memo = new HashMap<String,
				ArrayList<String>>();
		return wordBreakHelper(s, dict, memo);
	}

	private ArrayList<String> wordBreakHelper(String s,
	                                         Set<String> dict,
	                                         Map<String, ArrayList<String>> memo) {
		if (memo.containsKey(s)) {
			return memo.get(s);
		}

		ArrayList<String> results = new ArrayList<String>();

		if (s.length() == 0) {
			return results;
		}

		if (dict.contains(s)) {
			results.add(s);
		}

		for (int len = 1; len < s.length(); ++len) {
			String word = s.substring(0, len);
			if (!dict.contains(word)) {
				continue;
			}

			String suffix = s.substring(len);
			ArrayList<String> segmentations = wordBreakHelper(suffix, dict,
			                                                  memo);

			for (String segmentation : segmentations) {
				results.add(word + " " + segmentation);
			}
		}

		memo.put(s, results);
		return results;
	}

	private int getMaxLength(Set<String> dict) {
		int maxLength = 0;
		for (String word : dict) {
			maxLength = Math.max(maxLength, word.length());
		}
		return maxLength;
	}

	//DP
	public boolean wordBreakI(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		int maxLen = getMaxLength(dict);
		//? why this is s.length + 1
		boolean[] canSegment = new boolean[s.length() + 1];
		//[l i n t c o d e] -> s.length() -> 9
		//[] -> true
		//what's the meanning of canSegment[]

		canSegment[0] = true;
		//what's i
		//canSegment[1] -> false
		//canSegment[2] -> false
		//canSegment[3] -> false
		//canSegment[4] -> i = 4, lastWordLength ->
		for (int i = 1; i < s.length(); i++) {
			canSegment[i] = false;
			// i = 2, lastWordLength = 1 ->
			for (int lastWordLength = 1;
			     lastWordLength <= maxLen && lastWordLength <= i;
			     lastWordLength++) {
				//canSegment[0] -> true
				//canSegment[2-1 = 1] -> false
				//lastWordLength -> 2 -> canSegment -> []

				if (!canSegment[i - lastWordLength]) {
					continue;
				}
				//i = 1 -> lastwordLength -> 1 -> word = l
				//i = 2, lastwordLength -> 2 -> li
				String word = s.substring(i - lastWordLength, i);
				if (dict.contains(word)) {
					canSegment[i] = true;
					break;
				}
			}
		}
		return canSegment[s.length()];
	}
}
