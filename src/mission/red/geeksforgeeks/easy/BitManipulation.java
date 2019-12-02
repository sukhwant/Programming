package mission.red.geeksforgeeks.easy;

public class BitManipulation {

    private static boolean getBit(int number, int index) {
        System.out.println(Integer.toBinaryString(1 << index));
        System.out.println(Integer.toBinaryString((number & (1 << index))));
        return ((number & (1 << index)) != 0);
    }

    public static int setBit(int number, int index) {
        System.out.println(Integer.toBinaryString(1 << index));
        System.out.println(Integer.toBinaryString((number | (1 << index))));
        return (number | (1 << index));
    }

    public static int clearBit(int number, int index) {
        System.out.println(Integer.toBinaryString(~(1 << index)));
        System.out.println(Integer.toBinaryString((number & (~(1 << index)))));
        return (number & (~(1 << index)));
    }

    public static int mostSignificantBit(int number) {
        // TODO:-
        return 0;
    }

    public static int leastSignificantBit(int number) {
        // TODO:-
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(26));
        System.out.println(clearBit(26, 1));
    }
}
