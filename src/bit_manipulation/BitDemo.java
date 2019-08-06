package bit_manipulation;

public class BitDemo {
    public static void main(String[] args) {
        System.out.println(testBitSet(7, 0));
        System.out.println(testBitSet(23, 4));
        System.out.println(setBit(16, 3));
        System.out.println(clearBit(27, 2));
        System.out.println(toggleBit(27, 2));
        System.out.println(singleBitSet(35));
        System.out.println(singleBitSet(64));
    }
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
