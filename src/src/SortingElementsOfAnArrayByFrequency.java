import java.util.*;

public class SortingElementsOfAnArrayByFrequency {
    public static void main(String[] args) {
        int[] arr = {2, 12, 12, 3, 2, 5, 4, 4, 12, 2, 3, 3, 3, 12, 4, 5, 8, 9};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> sorted;
        List<Integer> l = new ArrayList<>();
        for (int element : arr) {
            int value = map.getOrDefault(element, 0);
            map.put(element, ++value);
            l.add(element);
        }
        System.out.println(map);
        SortComparator sortComparator = new SortComparator(map);
        l.sort(sortComparator);
        System.out.println(l);
    }
}
class SortComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> freqMap;
    SortComparator(Map<Integer, Integer> tFreqMap) {
        this.freqMap = tFreqMap;
    }
    @Override
    public int compare(Integer k1, Integer k2) {
        int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));
        int keyCompare = k1.compareTo(k2);
        if (freqCompare == 0)
            return keyCompare;
        else
            return freqCompare;
    }
}
