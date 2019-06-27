import java.util.*;

class FindAllSubarrayWithGivenSum {
    private static <K,V> void insert(Map<K, List<V>> hashMap, K key, V value) {
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }
        hashMap.get(key).add(value);
    }
    private static void printSubarray(int[] A, int i, int j)
    {
        System.out.println(Arrays.toString(Arrays.copyOfRange(A, i, j + 1)));
    }
    private static void printallSubarrays(int[] A, int sum) {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);

        int sum_so_far = 0;
        for (int index = 0; index < A.length; index++) {
            sum_so_far += A[index];
            if (hashMap.containsKey(sum_so_far - sum)) {
                List<Integer> list = hashMap.get(sum_so_far - sum);
                for (Integer value: list) {
                    printSubarray(A, value + 1, index);
                }
            }
            insert(hashMap, sum_so_far, index);
        }
    }
    public static void main (String[] args) {
        int[] A = { 1, -1, -1, 1, -1, 1, 1 };
        int sum = 0;
        printallSubarrays(A, sum);
    }
}