public class Coffee extends Beverage {
    Beverage beverage;
    int price;
    public Coffee() {
        price = 10;
    }


    @Override
    public  int cost() {
        return  price;
    }
}
