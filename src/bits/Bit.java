package bits;

public class Bit {

    private static boolean testBitSet(int number, int index) {
        int mask = 1 << index;
        return (number & mask) != 0;
    }
    private static int setBit(int number, int index) {
        int mask = 1 << index;
        return number | mask;
    }
    private static int clearBit(int number, int index) {
        int mask = ~(1 << index);
        return number & mask;
    }
    private static int toggleBit(int number, int index) {
        int mask = (1 << index);
        return number ^ mask;
    }
    private static boolean singleBitSet(int number) {
        if (number == 0)
            return false;
        return (number & number - 1) == 0;
    }
}
