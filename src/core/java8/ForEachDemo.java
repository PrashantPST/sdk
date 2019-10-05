package core.java8;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        // create a list of integers
        List<Integer> number = Arrays.asList(2,3,4,5);

        // demonstration of reduce method
        int even = number.stream().filter(x -> (x % 2 == 0)).reduce(0, Integer::sum);
    }
}
