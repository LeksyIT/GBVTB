package HW2;

public abstract class Obstacles {
    private String OBSTACLES_NAME = "obstacle";
    private String ACTION = "action";
    private int COMPLEXITY;

    public void setOBSTACLES_NAME(String OBSTACLES_NAME) {
        this.OBSTACLES_NAME = OBSTACLES_NAME;
    }

    public void setACTION(String ACTION) {
        this.ACTION = ACTION;
    }

    public Obstacles(int value) {
        this.COMPLEXITY = value;
    }

    public abstract boolean action(Participant part);

    public boolean check(Participant part) {
        if (action(part)) {
            System.out.println(part.getNAME() + " can " + ACTION + " this " + OBSTACLES_NAME);
            return true;
        } else {
            System.out.println(part.getNAME() + " can't " + ACTION + " this " + OBSTACLES_NAME);
            return false;
        }

    };
}
