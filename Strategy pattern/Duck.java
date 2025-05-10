public class Duck {
    ISwimBehaviour swimBehaviour;
    IFlyBehavior flyBehaviour;
    IWalk walk;

    public Duck(ISwimBehaviour swimBehaviour, IFlyBehavior flyBehaviour, IWalk walk) {
        this.swimBehaviour = swimBehaviour;
        this.flyBehaviour = flyBehaviour;
        this.walk = walk;
    }
    public void swim() {
        swimBehaviour.swim();
    }
    public void fly() {
        flyBehaviour.fly();
    }
    public void walk() {
        walk.walk();
    }
}
