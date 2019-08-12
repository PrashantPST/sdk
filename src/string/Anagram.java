package string;

public class Anagram {

    private static boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int value = 0;
        for (int i = 0; i < str1.length(); i++) {
            value ^= str1.charAt(i);
            value ^= str2.charAt(i);
        }
        return value == 0;
    }
}
