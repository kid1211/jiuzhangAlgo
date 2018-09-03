class Solution:
    """
    @param time: the given time
    @return: the next closest time
    """

    def nextClosestTime(self, time):
        # write your code here
        digitSet = set()
        # assume time is a string
        for l in time:
            if l is ':':
                continue
            digitSet.add(l)
        # self.distance
        digits = list(digitSet)
        # print(digits)
        self.possibleTime = []
        self.dfs(digits, [])
        print(self.possibleTime)
        return self.timeCal(time, self.possibleTime)

    def dfs(self, digits, curt):
        if len(curt) == 4:
            hr = int(curt[0]) * 10 + int(curt[1])
            mm = int(curt[2]) * 10 + int(curt[3])
            if hr < 24 and mm < 60:
                time = curt[0] + curt[1] + ':' + curt[2] + curt[3]
                self.possibleTime.append(time)

        for i in range(len(digits)):
            if len(curt) > 4:
                continue
            curt.append(digits[i])
            self.dfs(digits, curt)
            curt.pop()

    def timeCal(self, time, timeArray):
        # 24's 60 min
        smDist = 1440
        curtSma = time

        curtMin = self.time2Mins(time)
        # print(curtMin)
        for ts in timeArray:
            tmDist = self.time2Mins(ts) - curtMin
            if tmDist < 0:
                # borrow one day
                tmDist = self.time2Mins(ts) + 1440 - curtMin
            if tmDist == 0:
                continue
            if tmDist <= smDist:
                smDist = tmDist
                curtSma = ts
        return curtSma

    def time2Mins(self, time):
        # skip the ':'
        return (int(time[0]) * 10 + int(time[1])) * 60 + int(time[3]) * 10 + int(time[4])
