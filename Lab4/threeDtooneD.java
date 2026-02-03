public class threeDtooneD {

    private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final int DEPTH = 5;

    public static void main(String[] args) {

        int[] oneDArray = new int[WIDTH * HEIGHT * DEPTH];

        set(99, 1, 2, 3, oneDArray);

        int value = get(1, 2, 3, oneDArray);
        System.out.println("Value at (1,2,3): " + value);
    }

    public static void set(int value, int indexX, int indexY, int indexZ, int[] array1D) {
        int index = (indexZ * WIDTH * HEIGHT) + (indexY * WIDTH) + indexX;
        array1D[index] = value;
    }

    public static int get(int indexX, int indexY, int indexZ, int[] array1D) {
        int index = (indexZ * WIDTH * HEIGHT) + (indexY * WIDTH) + indexX;

        if (index >= 0 && index < array1D.length) {
            return array1D[index];
        }
        return -1;
    }
}