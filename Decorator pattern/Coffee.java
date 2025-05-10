public class Coffee extends Beverage {
    Beverage beverage;
    int price;
    public Coffee(Beverage beverage) {
        this.beverage = beverage;
        price = 10;
    }


    @Override
    public  int cost() {
        return  price;
    }
}
