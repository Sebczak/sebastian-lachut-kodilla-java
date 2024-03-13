import java.util.Arrays;

public class MinAndMax {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        int min = returnMin(array);
        int max = returnMax(array);
        System.out.println("Min " + min + "\nMax: " + max);
    }

    public static int returnMin(Integer[] arr) {
        int min = arr[0];
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
        }
        return min;
    }

    public static int returnMax(Integer[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}
