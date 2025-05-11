public class Sugar extends  Decorator{
    Beverage beverage;
    int price;

    public Sugar(Beverage beverage) {
        this.beverage = beverage;
        price = 4;

    }
    @Override
    public int cost() {
        return this.beverage.cost() + price;
    }
}
