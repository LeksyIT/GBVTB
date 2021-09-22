package hw6;

public class Main {

    float[] arr;

    public static void main(String[] args) throws InterruptedException {
        func();
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = 1.0f;
            arr2[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        Main e1 = new Main();
        Thread trd1 = new Thread(() -> e1.method1(arr1));
        Thread trd2 = new Thread(() -> e1.method2(arr2,HALF));
        trd1.start();
        trd2.start();
        trd1.join();
        trd2.join();
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void func() {
        final int SIZE = 10000000;
        final int HALF = SIZE / 2;
        float[] arr = new float[SIZE];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long a = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public synchronized void method1(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
        System.arraycopy(arr, 0, arr, 0, arr.length);
    }
    public synchronized void method2(float[] arr, int HALF) {
        for (int i = HALF; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) * Math.cos(0.4f + i / 2.0f));
        }
        System.arraycopy(arr, 0, arr, 0, arr.length);
    }
}
