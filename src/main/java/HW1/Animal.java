package HW1;

public abstract class Animal {
    final String NAME;
    final int LIMIT_LENGTH_SWIM;
    final int LIMIT_LENGTH_RUN;
    static int counter = 0;

    public Animal(String name, int limitlengtswim, int limitlengtrun) {
        LIMIT_LENGTH_SWIM = limitlengtswim;
        LIMIT_LENGTH_RUN = limitlengtrun;
        NAME = name;
        counter += 1;
    }

    public void swim(int length) {
        if (LIMIT_LENGTH_SWIM < length) {
            System.out.println(NAME + " не может проплыть " + length + "м");
        } else {
            System.out.println(NAME + " проплыл " + length + "м");
        }
    }

    public void run(int length) {
        if (LIMIT_LENGTH_RUN < length) {
            System.out.println(NAME + " не может пробежать " + length + "м");
        } else {
            System.out.println(NAME + " пробежал " + length + "м");
        }
    }
}
