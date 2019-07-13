import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseSorting {
    public static void main(String[] args) {
        String str = "defRTSersUXI";
        System.out.println(str);
        System.out.println(caseSort(str));
    }
    private static String caseSort(String str) {
        List<Character> v1 = new ArrayList<>();
        List<Character> v2 = new ArrayList<>();
        List<Character> v3 = new ArrayList<>();
        for (char c: str.toCharArray()) {
            if (c >= 'a' && c <= 'z')
                v1.add(c);
            else
                v2.add(c);
        }
        Collections.sort(v1);
        Collections.sort(v2);

        System.out.println(v1);
        System.out.println(v2);
        int i = 0;
        int j = 0;
        for (char c: str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                v3.add(v1.get(i));
                i += 1;
            }
            else {
                v3.add(v2.get(j));
                j += 1;
            }
        }
        return v3.stream().map(String::valueOf).collect(java.util.stream.Collectors.joining());
    }
}
