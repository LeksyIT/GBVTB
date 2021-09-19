package HW3;

public class Main {
    public static void main(String[] args){
        String[][] arr = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        try{Main.toIntArr(arr);}
        catch (MyArraySizeException ex){
            System.out.println("Change String[][] -> String[4][4]");
        }
        catch (MyArrayDataException ex){
            System.out.println("Make sure that all the elements can be converted to int");
        }
    }

    public static boolean checkArr(String[][] arr) throws MyArraySizeException {
        if (arr.length == 4 && countArr(arr) == 16) {
            return true;
        } else {
            throw new MyArraySizeException("This arr is`t String[4][4]");
        }
    }

    public static int countArr(String[][] arr) {
        int counter = 0;
        for (String[] x : arr) {
            for (String y : x) {
                counter += 1;
            }
        }
        return counter;
    }

    public static void toIntArr(String[][] arr) throws MyArraySizeException,MyArrayDataException {
        if (checkArr(arr)) {
            int sum = 0;
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    try {
                        sum+=Integer.parseInt(arr[x][y]);
                    } catch (NumberFormatException exception) {
                        throw new MyArrayDataException("String[" + x + "][" + y + "] cannot be converted to int ");
                    }
                }
            }
            System.out.println("Sum = " + sum);
        }
    }
}
