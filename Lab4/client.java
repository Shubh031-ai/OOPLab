interface Function {
    int evaluate(int x);
}

class Half implements Function {
    @Override
    public int evaluate(int x) {
        return x / 2;
    }
}

public class client {
    public static void main(String[] args) {
        int[] inputNumbers = { 10, 25, 4, 100, 7 };

        int[] result = halveArray(inputNumbers);

        System.out.println("Original: " + java.util.Arrays.toString(inputNumbers));
        System.out.println("Halved:   " + java.util.Arrays.toString(result));
    }

    public static int[] halveArray(int[] numbers) {

        int[] newArray = new int[numbers.length];

        Function halver = new Half();

        for (int i = 0; i < numbers.length; i++) {

            newArray[i] = halver.evaluate(numbers[i]);
        }

        return newArray;
    }
}
