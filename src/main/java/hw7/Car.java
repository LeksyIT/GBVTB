package hw7;

import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    CyclicBarrier cyclicBarrier;
    static Object monitor =new Object();

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    static boolean haveWinner = false;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb) {
        cyclicBarrier = cb;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
            cyclicBarrier.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            System.out.println(this.name + " Закончил гонку");
            synchronized (monitor){
                if (!haveWinner){
                    haveWinner = true;
                    System.out.println(name + "- WIN");
                }
            }
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

