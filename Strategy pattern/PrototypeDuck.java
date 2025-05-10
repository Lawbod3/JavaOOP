public class PrototypeDuck {
    public static void main(String[] args) {

        Duck myDuck = new Duck(new SwimmingLikeSeals(), new HelicopterFly(), new WalkLikeFrog());
        myDuck.fly();
        myDuck.walk();
        myDuck.swim();

        System.out.println();

        Duck myDuck2 = new Duck(new SwimmingLikeFish(), new AeroplaneFly(), new WalkLikeFowl());
        myDuck2.fly();
        myDuck2.walk();
        myDuck2.swim();

    }
}
