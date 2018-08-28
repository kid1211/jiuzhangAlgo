public class WildCardMatch {

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		boolean[][] memo = new boolean[s.length()][p.length()];
		boolean[][] visited = new boolean[s.length()][p.length()];
		return isMatchHelper(s, 0, p, 0, memo, visited);
	}

	private boolean isMatchHelper(String s, int sIndex, String p, int pIndex,
								  boolean[][] memo, boolean[][] visited) {
		if (pIndex == p.length()) {
			return sIndex == s.length();
		}

		if (sIndex == s.length()) {
			return allStar(p, pIndex);
		}

		if (visited[sIndex][pIndex]) {
			return memo[sIndex][pIndex];
		}

		char sChar = s.charAt(sIndex);
		char pChar = p.charAt(pIndex);

		boolean match;
		if (pChar == '*') {
			match = isMatchHelper(s, sIndex, p, pIndex + 1, memo, visited) ||
					isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
		} else {
			match = charMatch(sChar, pChar) && isMatchHelper(s, sIndex + 1, p,
															 pIndex + 1, memo,
															 visited);
		}
		visited[sIndex][pIndex] = true;
		memo[sIndex][pIndex] = match;
		return match;
	}

	private boolean charMatch(char sChar, char pChar) {
		return (sChar == pChar || pChar == '?');
	}

	private boolean allStar(String p, int pIndex) {
		for (int i = pIndex; i < p.length(); i++) {
			if (p.charAt(i) != '*') {
				return false;
			}
		}
		return true;
	}

	public boolean isMatchRegular(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		boolean[][] memo = new boolean[s.length()][p.length()];
		boolean[][] visited = new boolean[s.length()][p.length()];

		return isMatchHelper(s, 0, p, 0, memo, visited);
	}

	private boolean isMatchHelperRegular(String s, int sIndex,
								  String p, int pIndex,
								  boolean[][] memo,
								  boolean[][] visited) {
		// "" == ""
		if (pIndex == p.length()) {
			return sIndex == s.length();
		}

		if (sIndex == s.length()) {
			return isEmpty(p, pIndex);
		}

		if (visited[sIndex][pIndex]) {
			return memo[sIndex][pIndex];
		}

		char sChar = s.charAt(sIndex);
		char pChar = p.charAt(pIndex);
		boolean match;

		// consider a* as a bundle
		if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
			match = isMatchHelperRegular(s, sIndex, p, pIndex + 2, memo, visited) ||
					charMatchRegular(sChar, pChar) && isMatchHelperRegular(s, sIndex + 1, p, pIndex, memo, visited);
		} else {
			match = charMatchRegular(sChar, pChar) &&
					isMatchHelperRegular(s, sIndex + 1, p, pIndex + 1, memo, visited);
		}

		visited[sIndex][pIndex] = true;
		memo[sIndex][pIndex] = match;
		return match;
	}

	private boolean charMatchRegular(char sChar, char pChar) {
		return sChar == pChar || pChar == '.';
	}

	private boolean isEmpty(String p, int pIndex) {
		for (int i = pIndex; i < p.length(); i += 2) {
			if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
				return false;
			}
		}
		return true;
	}
}

