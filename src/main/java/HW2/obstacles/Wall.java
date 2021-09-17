package HW2.obstacles;

import HW2.Obstacles;
import HW2.Participant;

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
