class Solution:
    """
    @param: source: source string to be scanned.
    @param: target: target string containing the sequence of characters to match
    @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
    """

    def strStr(self, source, target):
        # write your code here
        if source == None or target == None:
            return -1

        srcLen = len(source)
        tarLen = len(target)

        if tarLen == 0:
            return 0

        if srcLen < tarLen:
            return -1

        srcIndex, tarIndex = 0, 0
        resetLength = 0
        while srcIndex < srcLen:
            while srcIndex < srcLen and source[srcIndex] == target[tarIndex]:
                print(srcIndex)
                print(tarIndex)
                srcIndex += 1
                tarIndex += 1
                resetLength += 1
                if tarIndex == tarLen:
                    # print( tarIndex )
                    return srcIndex - tarLen
            # if break out reset tarIndex
            tarIndex -= resetLength
            srcIndex -= resetLength
            resetLength = 0
            srcIndex += 1

        return -1

# ["abcdabcdefg", "bcd"]
# ["lintcode", "lintcode"]
# ["tartarget", "target"]
