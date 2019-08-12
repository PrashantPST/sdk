package string;

import java.util.HashMap;
import java.util.Map;

/*
 * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String a = "ACAB";
        String b = "XCXY";
        System.out.println(isIsomorphic(a, b));
    }
    private static boolean isIsomorphic(String s, String t) {
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
}
