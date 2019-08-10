package strings;

public class CheckAStringContainsDistinctCharacters {
    public static void main(String[] args) {
        String input = "bB";
        if (uniqueCharacters(input))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
    private static boolean uniqueCharacters(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int bitAtIndex = str.charAt(i) - 'a';
            if ((checker & (1 << bitAtIndex)) > 0)
                return false;
            checker |= (1 << bitAtIndex);
        }
        return true;
    }
}
