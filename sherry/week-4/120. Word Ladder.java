public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        // level bfs
        // convert it to graph -> start -> dict diff == 1 as set -> return -1 for fail
        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        HashSet<String> set = new HashSet<String>();
        Queue<String> dictQueue = new LinkedList<String>();
        dictQueue.offer(start);
        set.add(start);

        int length = 1;
        while(!dictQueue.isEmpty()) {
            length++;
            int size = dictQueue.size();
            for (int i = 0; i < size; i++) {
                String word = dictQueue.poll();
                //O((25*L)*L)
                for (String nextWord: getNeighbors(word, dict)) {
                    //O(L)
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    set.add(nextWord);
                    dictQueue.offer(nextWord);
                }
            }
        }
        return 0;
    }


    // replace character of a string at given index to a given character
     // return a new string
     private String replace(String s, int index, char c) {
         char[] chars = s.toCharArray();
         chars[index] = c;
         return new String(chars);
     }

     // get connections with given word.
     // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
     // it will return ['hit', 'hog']
     // time complex = o(25*L)
    private List<String> getNeighbors(String word, Set<String> dict) {
      ArrayList<String> nextWords = new ArrayList<String>();
      for (char c = 'a'; c <= 'z'; c++) {
          for (int i = 0; i < word.length(); i++) {
              if (c == word.charAt(i)) {
                  continue;
              }
              String nextWord = replace(word, i, c);
              if (dict.contains(nextWord)) {
                  nextWords.add(nextWord);
              }
          }
      }
      return nextWords;
  }

}
