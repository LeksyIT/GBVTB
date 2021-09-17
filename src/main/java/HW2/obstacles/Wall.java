package HW2.obstacles;

import HW2.Obstacles;
import HW2.Participant;

public class Wall extends Obstacles {
    private int HEIGHT;

    public Wall(int COMPLEXITY) {
        super(COMPLEXITY);
        HEIGHT = COMPLEXITY;
        setOBSTACLES_NAME("wall");
        setACTION("jump");
    }

    @Override
    public boolean action(Participant part) {
        return part.jumping(HEIGHT);
    }
}
