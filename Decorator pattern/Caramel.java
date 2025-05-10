public class Caramel extends Decorator{
    int price;
    Beverage beverage;
    public Caramel(Beverage beverage) {
        this.beverage = beverage;
        price = 5;
    }
    @Override
    public int cost() {
        return this.beverage.cost() + price;
    }


}
