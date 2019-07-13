public class MinimumWindowSubstring {
    private static final int nChars = 256;
    private static String findSubString(String str, String pat) {
        int sLen = str.length();
        int pLen = pat.length();
        if (sLen < pLen)
            return "-1";
        int[] patHash = new int[nChars];
        int[] strHash = new int[nChars];
        for (int i = 0; i < pLen; i++)
            patHash[pat.charAt(i)]++;
        int start = 0, startIndex = -1, minLen = sLen + 1;
        int count = 0;
        for (int j = 0; j < sLen ; j++) {
            strHash[str.charAt(j)]++;
            if (patHash[str.charAt(j)] != 0 && strHash[str.charAt(j)] <= patHash[str.charAt(j)] )
                count++;
            if (count == pLen) {
                while (strHash[str.charAt(start)] > patHash[str.charAt(start)] || patHash[str.charAt(start)] == 0) {
                    if (strHash[str.charAt(start)] > patHash[str.charAt(start)])
                        strHash[str.charAt(start)]--;
                    start++;
                }
                int windowLen = j - start + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = start;
                }
            }
        }
        if (startIndex == -1)
            return "-1";
        System.out.println(minLen);
        return str.substring(startIndex, startIndex + minLen);
    }
    public static void main(String[] args)
    {
        String str = "this is a test string";
        String pat = "tist";
        System.out.print("Smallest window is : " +findSubString(str, pat));
        System.out.println();
    }
}
