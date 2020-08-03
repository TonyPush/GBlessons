package hw6;

public class Dog extends Animal {
    protected int maxRun = 500;
    protected int maxSwim = 10;
    protected float maxJump = 0.5f;

    void run(int length) {
        if ((length >= 0) && (length <= maxRun)) System.out.println("run: true");
        else System.out.println("run: false");
    }

    @Override
    void swim(int length) {
        if ((length >= 0) && (length <= maxSwim)) System.out.println("swim: true");
        else System.out.println("swim: false");
    }

    @Override
    void jump(float height) {
        if ((height >= 0) && (height <= maxJump)) System.out.println("jump: true");
        else System.out.println("jump: false");
    }

}
