package ds.linear.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * Give an array of N integers and another integer k ≤ N.
 * The task is to find the maximum element of every sub-array of size k.
 * TC: O(n) && SC: O(k)
 */
public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 6, 12, 21, 5, 6 };
        int k = 4;
        System.out.println(Arrays.toString(maximumOfAllSubarrays(arr, k)));
    }

    private static int[] maximumOfAllSubarrays(int[] nums, int k) {
        int[] temp = new int[nums.length - k + 1];
        int itr = -1;
        Deque<Integer> deque = new LinkedList<>();
        int idx = 0;
        for (int i = 1; i < k ; i++) {
            if(nums[idx] < nums[i])
                idx = i;
        }
        deque.offerLast(idx);

        for (int i = k; i < nums.length ; i++) {
            temp[++itr] = nums[deque.peekFirst()];
            while(!deque.isEmpty() && deque.peekFirst() <= i - k)
                deque.pollFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            deque.offerLast(i);
        }

        temp[++itr] = nums[deque.peekFirst()];
        return temp;
    }
}
