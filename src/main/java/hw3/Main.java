package hw3;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            toIntArr(arr);
        } catch (MyArraySizeException ex) {
            System.out.println(ex.getMessage());
        } catch (MyArrayDataException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void checkArr(String[][] arr) throws MyArraySizeException {
        if (!countArr(arr)) {
            throw new MyArraySizeException("Make the dimension of the array 4 by 4");
        }
    }

    public static boolean countArr(String[][] arr) {
        if (arr.length != 4) {
            return false;
        }
        for (String[] i : arr) {
            if (i.length != 4) {
                return false;
            }
        }
        return true;
    }

    public static void toIntArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        checkArr(arr);
        int sum = 0;
        for (int x = 0; x < arr.length; x++) {
            for (int y = 0; y < arr.length; y++) {
                try {
                    sum += Integer.parseInt(arr[x][y]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException("String[" + x + "][" + y + "] cannot be converted to int ");
                }
            }
        }
        System.out.println("Sum = " + sum);
    }
}
