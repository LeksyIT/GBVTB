package HW2;

import HW2.obstacles.Treadmill;
import HW2.obstacles.Wall;
import HW2.participants.Cat;
import HW2.participants.People;
import HW2.participants.Robot;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = {
                new Cat(3, 1000, "Barsik"),
                new People(1, 3000, "Ilia Krytoi"),
                new Robot(2, 20000, "R2D2"),
        };
        Obstacles[] obstacles = {
                new Treadmill(500),
                new Wall(1),
                new Treadmill(3500),
                new Wall(1),
        };
        for (Participant participant : participants) {
            for (Obstacles obstacle : obstacles) {
                if (!obstacle.check(participant)) {
                    break;
                };
            }
        }
    }
}
