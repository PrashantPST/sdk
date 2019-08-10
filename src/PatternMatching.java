public class PatternMatching {
    private final static int d = 256;
    private static void search(String pattern, String text, int q) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int patternHash = 0;
        int windowHash = 0;
        int h = 1;
        for (i = 0; i < m - 1; i++)
            h = (h * d) % q;
        for (i = 0; i < m; i++) {
            patternHash = (d * patternHash + pattern.charAt(i)) % q;
            windowHash = (d * windowHash + text.charAt(i)) % q;
        }
        for (i = 0; i <= n - m; i++) {
            if (patternHash == windowHash) {
                for (j = 0; j < m; j++) {
                    if (text.charAt(i+j) != pattern.charAt(j))
                        break;
                }
                if (j == m)
                    System.out.println("Pattern found at index " + i);
            }
            if (i < n - m) {
                windowHash = (d * (windowHash - text.charAt(i) * h) + text.charAt(i+m)) % q;
                if (windowHash < 0)
                    windowHash += q;
            }
        }
    }
    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEK";
        int q = 101;
        search(pattern, text, q);
    }
}