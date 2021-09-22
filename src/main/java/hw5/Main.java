package hw5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> testArr = new ArrayList<>();
        testArr.add("1");
        testArr.add("1");
        testArr.add("1");
        testArr.add("1");
        testArr.add("2");
        testArr.add("2");
        testArr.add("2");
        testArr.add("3");
        testArr.add("4");
        testArr.add("5");
        testArr.add("9");
        testArr.add("9");
        testArr.add("9");
        testArr.add("9");
        testArr.add("9");
        testArr.add("9");
        testArr.add("9");
        findUnique(testArr);

    }

    public static Map<String, Integer> countElements(List<String> arr) {
        HashMap<String, Integer> countElements = new HashMap<>();
        for (String el : arr) {
            if (countElements.containsKey(el)) {
                countElements.put(el, countElements.get(el) + 1);

            } else {
                countElements.put(el, 1);
            }
        }
        System.out.println(countElements);
        return countElements;
    }

    public static void findUnique(List<String> arr) {
        Map<String, Integer> map = countElements(arr);
        Set<String> uniqueArr = new HashSet<>(map.keySet());
        System.out.println(uniqueArr);
    }
}
