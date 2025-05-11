public class PrototypeDecorator {
    public static void main(String[] args) {
        Coffee myCoffee = new Coffee();
        Caramel caramel = new Caramel(myCoffee);
        Sugar sugar = new Sugar(caramel);

        System.out.println("myCoffee = " + myCoffee.cost());
        System.out.println("Caramel Cost: " + caramel.cost());
        System.out.println("Sugar Cost: " + sugar.cost());


    }
}
