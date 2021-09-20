package hw2.obstacles;

import hw2.Obstacles;
import hw2.Participant;

public class Wall extends Obstacles {
    private final int height;

    public Wall(int complexity) {
        height = complexity;
        setOBSTACLES_NAME("wall");
        setACTION("jump");
    }

    @Override
    public boolean action(Participant part) {
        return part.jumping(height);
    }
}
