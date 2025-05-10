import java.util.Scanner;

public class GeoPoliticalZonePrototype {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("App to get your Geo-political zone through sate");
        System.out.println("Enter the name of your state: ");
        String nameOfState = keyboard.nextLine();

        String result = String.valueOf(GeoPoliticalZone.fromState(nameOfState.toLowerCase()));
        if(result == null){
            System.out.println("The State does not exist");
        }
        else{
            System.out.println("The name of your Geo-political zone is " + result);
        }

    }
}
