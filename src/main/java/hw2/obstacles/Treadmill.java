package hw2.obstacles;

import hw2.Obstacles;
import hw2.Participant;

public class Treadmill extends Obstacles {
    private final int length;

    public Treadmill(int complexity ) {
        length = complexity;
        setOBSTACLES_NAME("treadmill");
        setACTION("run");
    }

    @Override
    public boolean action(Participant part) {
        return part.running(length);
    }
}
