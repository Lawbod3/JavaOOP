import javax.swing.*;
import java.util.Scanner;

public class DiaryPrototype {
     static Scanner input = new Scanner(System.in);
     static Diaries diaries = new Diaries();

    public static void main(String[] args) {

       System.out.println("Welcome to Diary prototype");
        mainMenu();


    }
    private static void menu() {
        String menu = """
                1-> Create your diary account.
                2-> Create an Entry.
                3-> delete an Entry.
                4-> find an Entry by id.
                5-> Update an Entry.
                6-> Delete your account.
                7-> Exit.
                """;
        System.out.println(menu);

    }
    private static void createAccount() {
        System.out.println("Please enter Username: ");
        String username = input.nextLine();
        while(!diaries.isValidUsername(username) || !isValidRegistration(username)) {
            System.out.println("Username already exists or it wrong Input, try again.");
            System.out.print("Please enter Username: ");
            username = input.nextLine();
        }
        System.out.println("Please enter Password: ");
        String password = input.nextLine();
        while(!isValidRegistration(password)) {
            System.out.print("Wrong password, try again: ");
            password = input.nextLine();
        }
        PersonalDiary personalDiary = new PersonalDiary(username, password);
        diaries.add(username, password);
    }
    private static void createEntry() {
        while(true) {
            System.out.print("Please enter Username: ");
            String username = input.nextLine();
            if(diaries.isValidUsername(username)) {
                System.out.println("Username Does Not Exist, exiting");
                break;
            }
           PersonalDiary user =  diaries.findByUsername(username);
            System.out.print("Please enter your Entry title: ");
            String entryTitle = input.nextLine();
            System.out.print("Please enter your Entry Body: ");
            String entryBody = input.nextLine();
            System.out.print("Please enter Password to Create an Entry: ");
            String password = input.nextLine();
            user.unlockDiary(password);
            if(user.isLocked() == true) {
                System.out.println("User is locked , Wrong Password");
                break;
            }
            System.out.println("Your entry Id: " + user.numberOfEntries());
            user.createEntry(entryTitle, entryBody);
            System.out.println("Entry created successfully");
            break;
        }
    }
    private static void deleteEntry() {}
    private static void findEntryWithId() {}
    private static void updateEntry() {}
    private static void deleteAccount() {}
    private static void mainMenu() {
       loop: while(true) {
           menu();
           int choice = getInput();
           switch (choice) {
               case 1 -> createAccount();
               case 2 -> createEntry();
               case 3 -> deleteEntry();
               case 4 -> findEntryWithId();
               case 5 -> updateEntry();
               case 6 -> deleteEntry();
               case 7 -> {
                   break loop;
               }
               default -> System.out.println("Wrong choice, Try again");
           }
         }
       }
    private static int getInput() {
      System.out.print("Enter your choice: ");
      String choiceInput = input.nextLine();
      while(!validateInput(choiceInput)) {
          System.out.print("Wrong choice try again, Enter your choice: ");
          choiceInput = input.nextLine();
      }
        return Integer.parseInt(choiceInput);
    }
    private static boolean validateInput(String input) {
        boolean validInput = input.matches("^[0-9]+$") && Integer.parseInt(input) > 0 ;
        if(!validInput) return false;
        return true;
    }
    private static boolean isValidRegistration(String user) {
        boolean validInput = user.matches("^[A-z0-9]+$");
        if(!validInput) return false;
        return true;
    }
}

