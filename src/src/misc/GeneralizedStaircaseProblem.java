package misc;

public class GeneralizedStaircaseProblem {
    private static final int MAX_STEPS = 2;
    public static void main(String[] args) {
        int staircaseLength = 4;
        System.out.println(ways(staircaseLength));
    }
    private static int ways(int staircaseLength) {
        int[] res = new int[staircaseLength + 1];
        res[0] = 1; res[1] = 1; res[2] = 2;
        for (int i = 3; i <= staircaseLength; i++) {
            for (int j = 1; j <= MAX_STEPS; j++)
                res[i] += res[i - j];
        }
        return res[staircaseLength];
    }
}
