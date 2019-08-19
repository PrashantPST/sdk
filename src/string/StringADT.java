package string;

import java.util.HashMap;
import java.util.Map;

class StringADT {

    static boolean areAnagram(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        int value = 0;
        for (int i = 0; i < str1.length(); i++) {
            value ^= str1.charAt(i);
            value ^= str2.charAt(i);
        }
        return value == 0;
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
}
