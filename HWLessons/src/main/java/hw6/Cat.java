package hw6;

public class Cat extends Animal {

    protected int maxRun = 200;
    protected int maxSwim = 0;
    protected float maxJump = 2;


    void run(int length) {
        if ((length >= 0) && (length <= maxRun)) System.out.println("run: true");
        else System.out.println("run: false");
    }

    @Override
    void swim(int length) {
        System.out.println("swim: false");
    }

    @Override
    void jump(float height) {
        if ((height >= 0) && (height <= maxJump)) System.out.println("jump: true");
        else System.out.println("jump: false");
    }


}
