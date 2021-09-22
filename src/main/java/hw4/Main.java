package hw4;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        swapIndex(arr,1,2);
        Integer[] arr1 = new Integer[]{11, 22, 33, 44};
        swapElement(arr1,11,22);
        for (Integer el: arr) {
            System.out.println(el);
        }
    }

    public static <T> void swapIndex(T[] arr, int firstIndex, int secondIndex) {
        T temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static <T> void swapElement(T[] arr, T firstElement, T secondElement) {
        int firstArrIndex = 0;
        int secondArrIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(firstElement)) {
                firstArrIndex = i;
            }
            if (arr[i].equals(secondElement)) {
                secondArrIndex = i;
            }
        }
        T temp = arr[firstArrIndex];
        arr[firstArrIndex] = arr[secondArrIndex];
        arr[secondArrIndex] = temp;
    }

    public static <T> List<T> toArrayList(T[] arr){
        return Arrays.asList(arr);
    }
}
