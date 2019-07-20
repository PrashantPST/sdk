/*
 * PS:-> A celebrity is person that is known by every other person, but (s)he does not know any of them.
 *
 */
public class CelebrityIdentification {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 1, 0, 0}
        };
        System.out.println("Celebrity ID = "+identifyCelebrity(arr));
    }

    private static int identifyCelebrity(int[][] arr) {
        int a = 0;
        int b = arr.length - 1;
        while (a < b) {
           if(arr[a][b] == 1)
               a++;
           else
               b--;
        }
        for(int i = 0; i < arr.length; i++) {
            if ((i != a) && (arr[i][a] == 0 || arr[a][i] == 1)) {
                return -1;
            }
        }
        return a;
    }
}
