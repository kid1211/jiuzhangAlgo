import com.jiuzhang.model.Trie;

public class WordSearch {

	/**
	 * @param board: A list of lists of character
	 * @param word:  A string
	 * @return: A boolean
	 */
	public boolean exist(char[][] board, String word) {
		// write your code here
		if (board == null || board.length == 0 || word == null) {
			return false;
		}

		if (word == null) {
			return false;
		}

		if (word.length() == 0) {
			return true;
		}

		int n = board.length;
		int m = board[0].length;

		Trie root = new Trie();
		Trie.addWord(root, word);

		boolean[][] isVisited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!root.childs.containsKey(board[i][j])) {
					continue;
				}

				isVisited[i][j] = true;
				if (dfs(i, j, isVisited, root.childs.get(board[i][j]), board)) {
					return true;
				}
				isVisited[i][j] = false;
			}
		}
		return false;
	}

	private boolean dfs(int x, int y, boolean[][] isVisited, Trie root, char[][] board) {
		int[] deltaX = {0, 0, 1, -1};
		int[] deltaY = {1, -1, 0, 0};

		if (root.isWord) {
			return true;
		}

		for (int i = 0; i < 4; i++) {
			int new_x = x + deltaX[i];
			int new_y = y + deltaY[i];
			if (!valid(new_x, new_y, board)) {
				continue;
			}
			if (isVisited[new_x][new_y]) {
				continue;
			}
			if (!root.childs.containsKey(board[new_x][new_y])) {
				continue;
			}

			isVisited[new_x][new_y] = true;
			if (dfs(new_x, new_y, isVisited, root.childs.get(board[new_x][new_y]), board)) {
				return true;
			}
			isVisited[new_x][new_y] = false;

		}
		return false;

	}

	private boolean valid(int x, int y, char[][] board) {
		return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
	}


}
