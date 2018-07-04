// 13. Implement strStr()
// For a given source string and a target string, you should output the first index(from 0) of target string in source string.
//
// If target does not exist in source, just return -1.
//
// Example
// If source = "source" and target = "target", return -1.
//
// If source = "abcdabcdefg" and target = "bcd", return 1.
//
// Challenge
// O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)

//TODO: using hashcode to immplement it -> check in new file
//TODO: review hashCode logic
public class Solution {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        // write your code here
        // if tar > sor, return -1
        int index = -1;
        if(source == null || target == null){
            return index;
        }
        int sourceLen = source.length();
        int tarLen = target.length();

        if(tarLen == 0){
            return 0;
        }

        if(tarLen > sourceLen){
            return index;
        }

        for(int i =0; i <= sourceLen-tarLen; i++) {
            index = i;
            for(int j = 0; j < tarLen; j++){
                if(source.charAt(i+j) != target.charAt(j)){
                    index = -1;
                    break;
                }
            }
            if(index != -1){
                break;
            }
        }
        return index;

    }
}
