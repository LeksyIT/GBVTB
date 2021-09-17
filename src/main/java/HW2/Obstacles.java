package HW2;

public abstract class Obstacles {
    private String obstaclesName = "obstacle";
    private String action = "action";

    public void setOBSTACLES_NAME(String obstaclesName) {
        this.obstaclesName = obstaclesName;
    }

    public void setACTION(String action) {
        this.action = action;
    }

    public abstract boolean action(Participant part);

    public boolean check(Participant part) {
        if (action(part)) {
            System.out.println(part.getNAME() + " can " + action + " this " + obstaclesName);
            return true;
        } else {
            System.out.println(part.getNAME() + " can't " + action + " this " + obstaclesName);
            return false;
        }

    }
}
