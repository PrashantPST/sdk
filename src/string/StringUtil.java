package string;

import java.util.HashMap;
import java.util.Map;

class StringUtil {

    public static void main(String[] args) {
        System.out.println(areAnagram("aa", "bb"));
        System.out.println(areAnagram("listen", "silent"));
        System.out.println(areAnagram("triangle", "integral"));
    }

    private static boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int[] count = new int[256];
        for(int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)] += 1;
            count[str2.charAt(i)] -= 1;
        }
        for (int e: count) {
            if (e != 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
     */
    static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if(map.containsKey(c1)) {
                if(c2 != map.get(c1))
                    return false;
            }
            else
                map.put(c1, c2);
        }
        return true;
    }

    static boolean uniqueCharacters(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int bitAtIndex = str.charAt(i) - 'a';
            if ((checker & (1 << bitAtIndex)) > 0)
                return false;
            checker |= (1 << bitAtIndex);
        }
        return true;
    }

    /**
     * Efficiently find first repeated character in a string without using any additional ds in a single traversal.
     * @param str input string
     * @return first repeated character
     */
    static int firstRepeatedCharacter(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); ++i) {
            int val = (str.charAt(i)-'a');
            if ((checker & (1 << val)) > 0)
                return i;
            checker |= (1 << val);
        }
        // all characters are non repeated
        return -1;
    }

    /**
     * Find The First Non Repeated Character In A String
     * @return index of the first non repeated character in string
     */
    public static int firstNotRepeatedCharacter(String input) {

        // assuming extended ascii characters as well.
        int[] flags = new int[256];

        for (int i = 0; i < input.length(); i++) {
            flags[input.charAt(i)]++ ;
        }

        for (int i = 0; i < input.length(); i++) {
            if(flags[input.charAt(i)] == 1)
                return i;
        }
        // all characters are repeated
        return -1;
    }
}
