package algorithms.greedy;

import javafx.util.Pair;

import java.util.*;


public class ActivitySelection {

    private static Set<Integer> selectActivity(List<Pair<Integer, Integer>> activities) {
        // k keeps track of the index of the last selected activity
        int k = 0;

        // set to store the selected activities index
        Set<Integer> out = new HashSet<>();

        // select 0 as first activity
        out.add(0);

        // start iterating from the second element of
        // vector up to its last element
        for (int i = 1; i < activities.size(); i++) {
            // if start time of i'th activity is is greater or equal
            // to the finish time of the last selected activity, it
            // can be included in activities list
            if (activities.get(k).getValue() <= activities.get(i).getKey()) {
                out.add(i);
                k = i;	// update i as last selected activity
            }
        }

        return out;
    }

    public static void main(String[] args) {

        int[] start = new int[] {1, 3, 2, 5, 8, 5};
        int[] end = new int[] {2, 4, 6, 7, 9, 9};
        List<Pair<Integer, Integer>> activities = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            activities.add(new Pair<>(start[i], end[i]));
        }

        // Sort the activities according to their finishing time
        activities.sort(Comparator.comparingInt(pair -> (int) pair.getValue()));

        Set<Integer> res = selectActivity(activities);

        for (Integer i: res) {
            System.out.print(activities.get(i)+" ");
        }
    }
}
