public class Solution {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    private static int sourceOriLength = -1;

    public static int strStr(String source, String target) {
        // write your code here
        if(source == null || target == null)
            return -1;
        int srcLength = source.length();
        int tarLength = target.length();
        source = source.toLowerCase();
        target = target.toLowerCase();

        if(sourceOriLength == -1 ) {
            sourceOriLength = srcLength;
        }

        if(target.equals(""))
            return 0;

        if(srcLength < tarLength)
            return -1;

        int skipValue = 0;
        for(int i =0; i < tarLength; i++) {

            if (source.charAt(i) == target.charAt(i)) {
                skipValue++;
                if(skipValue == tarLength) {
                    return sourceOriLength - srcLength;
                }
            }
        }

        skipValue = skipValue == 0 ? 1 : skipValue;

        return strStr(source.substring(skipValue),target);
    }

    public static void main(String[] args) {

        sourceOriLength = -1;
        System.out.println("0 "+strStr("",""));
        sourceOriLength = -1;
        System.out.println("0 "+strStr("up","up"));
        sourceOriLength = -1;
        System.out.println("1 "+strStr("uup","up"));
        sourceOriLength = -1;
        System.out.println("2 "+strStr("11up","up"));
        sourceOriLength = -1;
        System.out.println("-1 "+strStr("11u2p1","up"));
        sourceOriLength = -1;
        System.out.println("2 "+strStr("11up1","up"));
        sourceOriLength = -1;
        System.out.println("-1 "+strStr("source","target"));
        sourceOriLength = -1;
        System.out.println("3 "+strStr("11uup1","up"));
        sourceOriLength = -1;
        System.out.println("2 "+strStr("11upup1","up"));
        sourceOriLength = -1;
        System.out.println("4 "+strStr("11uuup1","up"));
    }
}