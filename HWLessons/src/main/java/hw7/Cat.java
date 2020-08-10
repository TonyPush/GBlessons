package hw7;

public class Cat {
    private String name;
    private int appetite;
    private boolean starve;
    int food = 15;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.starve = true;
    }

    public void eat(Plate p) {
        System.out.println("========================================");
        System.out.println( name + " котэ голоден" + "  || starve = " + starve);
        if (p.decreaseFood(appetite)) {

            starve = false;
            System.out.println(name + " поел " + "и в plate теперь: " + p.getFood());
            System.out.println(name + " котэ сыт" + "  || starve = " + starve);
        } else {
            System.out.println(name + " котэ хочет есть" + "  || starve = " + starve);
            System.out.println("Насыпаем еды  в Plate");
            p.addFood(food);
        }
    }

}
