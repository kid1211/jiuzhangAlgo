import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	/**
	 * @param: A String
	 * @param: A set of Word
	 * @retrun: the number of possible sentences
	 */
	public int wordBreak3(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
			return 0;
		}
		String lowerString = s.toLowerCase();
		Set<String> lowerDict = new HashSet();
		for (String word : dict) {
			lowerDict.add(word.toLowerCase());
		}
		List<String> results = new ArrayList();
		dfsHelper(lowerString, lowerDict, 0, new ArrayList<String>(), results);
		return results.size();
	}

	private void dfsHelper(String lowerString, Set<String> lowerDict, int i, ArrayList<String> strings, List<String> results) {

	}


}
