package fr.campus.dunDrag;
import java.util.Scanner;


public class Menu {
private final Scanner scanner;
    public Menu(){
        this.scanner = new Scanner(System.in);
    }

    public Character createCharacter() {
        System.out.println("===== WELCOME TO DUNGEONS & DRAGONS ===");

        System.out.println("Enter your character's name: ");
        String name = scanner.nextLine().trim();

        String type = "";
        while (!type.equalsIgnoreCase("Warrior") && !type.equalsIgnoreCase("Wizard")) {
            System.out.println("Choose your class (Warrior/ Wizard): ");
            type = scanner.nextLine().trim();

            if (!type.equalsIgnoreCase("Warrior") && !type.equalsIgnoreCase("Wizard")) {
                System.out.println("Invalid choice. Please type 'Warrior' or 'Wizard.'");
            }
        }
        String arme;
        int lifepoints;
        int attackpoints;

        if (type.equalsIgnoreCase("Warrior")) {
            arme = null;
            lifepoints = 10;
            attackpoints = 5;

        } else {
            arme = null;
            lifepoints = 6;
            attackpoints = 8;
        }

        System.out.println("/nCharacter created successfully!");
        System.out.println("--> " + name + " the " + type);
        System.out.println("/nYou have " + lifepoints + " life points and " + attackpoints + " attack points, good luck");

        return new Character(type, name, arme, lifepoints, attackpoints);

    }
    public boolean openInGameMenu(Character player) {
        System.out.println("/n--- PAUSE MENU ---");
        System.out.println("1. View Character Stats");
        System.out.println("2. Resume Game");
        System.out.println("3. Quit Game");
        System.out.print("Choose an option: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                displayCharacterStats(player);
                return openInGameMenu(player);
            case "2":
                System.out.println("resuming game....");
                return true;
            case "3":
                return confirmQuit();
            default:
                System.out.println("Invalid option, please choose again");
                return openInGameMenu(player);
        }

    }
    private void displayCharacterStats(Character player) {
        System.out.println("\n=== CHARACTER SHEET ===");
        System.out.println("Name:   " + player.getName());
        System.out.println("Class:  " + player.getType());
        if(player.arme != null){
            System.out.println("Weapon: " + player.getArme());
        } else{
            System.out.println("You do not have an weapon");
        }

        System.out.println("Health: " + player.getLifePoints() + " HP");
        System.out.println("Attack: " + player.getAttackPoints() + " ATK");
        System.out.println("=======================");
    }
    private boolean confirmQuit() {
        System.out.println("Are you sure you want to quit? (y/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("y") || response.equals("yes")) {
            System.out.println("Thanks for playing! Goodbye.");
            return false;
        }
        return true;
    }

}
