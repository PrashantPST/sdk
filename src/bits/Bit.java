package bits;

public class Bit {

    /**
     * @return true or false whether index bit is set or not.
     */
    private static boolean testBitSet(int number, int index) {
        int mask = 1 << index;
        return (number & mask) != 0;
    }

    /**
     * @return number after setting index bit of given number
     */
    private static int setBit(int number, int index) {
        int mask = 1 << index;
        return number | mask;
    }

    /**
     * @return number after reset the index bit of given number
     */
    private static int clearBit(int number, int index) {
        int mask = ~(1 << index);
        return number & mask;
    }
    private static int toggleBit(int number, int index) {
        int mask = (1 << index);
        return number ^ mask;
    }
    private static boolean singleBitSet(int number) {
        return number != 0 && (number & number - 1) == 0;
    }

    /**
     * @return whether given number is power of two or not.
     */
    private static boolean isPowerOfTwo(long number) {
        return number != 0 && ((number & (number - 1)) == 0);
    }

    /**
     * Brian Kernighan’s Algorithm:->
     * The beauty of this solution is the number of times it loops is equal to the number of set bits in a given integer.
     * @return the number of set bits for a given number
     */
    private static int countSetBits(int number) {
        int count = 0;
        while (number > 0) {
            number &= (number - 1) ;
            count++;
        }
        return count;
    }
}
