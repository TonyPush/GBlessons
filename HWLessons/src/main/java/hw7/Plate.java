package hw7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public  boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        }
        else {
            System.out.println("plate: " + food);
            System.out.println("Недостаточно еды, чтобы насытиться");
            return false;
        }
    }

    void addFood(int food) {
        this.food += food;
    }


    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
