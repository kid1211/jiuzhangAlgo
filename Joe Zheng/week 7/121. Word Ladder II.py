class Solution:
    """
    @param: start: a string
    @param: end: a string
    @param: dict: a set of string
    @return: a list of lists of string
    """

    def findLadders(self, start, end, dict):
        # write your code here
        dict.add(start)
        dict.add(end)
        self.memo = {}
        self.distant = {}
        # bfs to construct the graph and calculate the path
        self.bfs(start, end, dict)
        self.result = []
        self.dfs(end, [start])
        return self.result

    def dfs(self, end, curt):
        lastWord = curt[-1]
        if lastWord == end:
            self.result.append(curt[:])
            return
        # memo is all the possible words for next step
        for words in self.memo[lastWord]:
            # go to the next level, no need to check for loop, because it is
            # denied when adding into distant
            if self.distant[words] > self.distant[lastWord]:
                curt.append(words)
                self.dfs(end, curt)
                curt.pop()

    def bfs(self, start, end, dict):
        q = collections.deque()
        q.append(start)
        self.distant[start] = 0

        while q:
            size = len(q)
            for _ in range(size):
                curt = q.popleft()
                if curt == end:
                    break

                newWords = self.nextWords(curt, dict)
                validWords = []
                if curt not in self.memo:
                    self.memo[curt] = newWords

                # print(newWords)
                for word in newWords:
                    if word in self.distant:
                        # new need to check, because the length will be longer
                        continue
                    self.distant[word] = self.distant[curt] + 1
                    q.append(word)

    def nextWords(self, word, dict):
        words = set()
        alphabet = 'abcdefghijklmnopqrstuvwxyz'
        # change every letter in the word
        for idx in range(len(word)):
            for l in alphabet:
                newWord = word[:idx] + l + word[idx + 1:]
                if newWord not in dict:
                    continue
                words.add(newWord)
        return list(words)
