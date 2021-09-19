package HW3;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try {
            toIntArr(arr);
        } catch (MyArraySizeException ex) {
            System.out.println("Make the dimension of the array 4 by 4");
        } catch (MyArrayDataException ex) {
            System.out.println("Make sure that all the elements can be converted to int");
        }
    }

    public static boolean checkArr(String[][] arr) throws MyArraySizeException {
        if (arr.length == 4 && countArr(arr)) {
            return true;
        } else {
            throw new MyArraySizeException("This arr is`t String[4][4]");
        }
    }

    public static boolean countArr(String[][] arr) {
        for (String[] x : arr) {
            for (String y : x) {
                if(y.length() != 4){
                    return false;
                }
            }
        }
        return true;
    }

    public static void toIntArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (!checkArr(arr)) {
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
}
