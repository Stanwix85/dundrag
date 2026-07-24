package fr.campus.dunDrag.function;
import fr.campus.dunDrag.DbQuery.PlayerDAO;
import fr.campus.dunDrag.People.Character;


public class Menu {
    public fr.campus.dunDrag.People.Character createCharacter() {
        System.out.println("===== WELCOME TO DUNGEONS & DRAGONS ===");

        String name = askForName();
        String type = askForClass();

        PlayerDAO playerDAO = new PlayerDAO();
        Character player = playerDAO.createPlayerFromTemplate(name, type);
        if (player == null){
            System.out.println("\nFailed to load character template from database. using default character.");
            return new Character(0,name, type, 10, 5);
        }

        System.out.println("\nCharacter created successfully!");
        System.out.println("--> " + player.getName() + " the " + player.getType());
        System.out.println("\n"+ player.getName() + " has " + player.getLifePoints() + " life points and " + player.getAttackPoints() + " attack points, good luck");

       //return new fr.campus.dunDrag.People.Character(name, type, lifepoints, attackpoints);
        return player;
    }
    public boolean openInGameMenu(fr.campus.dunDrag.People.Character player) {
        System.out.println("\n--- PAUSE MENU ---");
        System.out.println("1. View Character Stats");
        System.out.println("2. Resume Game");
        System.out.println("3. Quit Game");
        System.out.print("Choose an option: ");

        String choice = ConsoleUtils.readLine();

        return switch (choice) {
            case "1" -> {
                displayCharacterStats(player);
                yield openInGameMenu(player);
            }
            case "2" -> {
                System.out.println("resuming game....");
                yield true;
            }
            case "3" -> confirmQuit();
            default -> {
                System.out.println("Invalid option, please choose again");
                yield openInGameMenu(player);
            }
        };

    }
    private void displayCharacterStats(Character player) {
        System.out.println("\n=== CHARACTER SHEET ===");
        System.out.println("Name:   " + player.getName());
        System.out.println("Class:  " + player.getType());
        if(player.getArmeAttack() != null){
            System.out.println("Weapon: " + player.getArmeAttack().getName());
        } else{
            System.out.println("You do not have an weapon");
        }
        if(player.getArmeDefense() != null){
            System.out.println("Defence weapon: " + player.getArmeDefense().getName());
        } else{
            System.out.println("You do not have an defence weapon");
        }

        System.out.println("Health: " + player.getLifePoints() + " HP");
        System.out.println("Attack: " + player.getAttackPoints() + " ATK");
        System.out.println("=======================");
    }
    private boolean confirmQuit() {
        System.out.println("Are you sure you want to quit? (y/n): ");
        String response = ConsoleUtils.readLine();
        if (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes")) {
            System.out.println("Thanks for playing! Goodbye.");
            return false;
        }
        return true;
    }
    public boolean turnPromt(Character player){
        System.out.println("\n Press return key to roll the dice or enter 'm' for menu: ");
        String input = ConsoleUtils.readLine();
        if (input.equalsIgnoreCase("m")) {
            return openInGameMenu(player);
        } return true;
    }
    public boolean askToplayAgain() {
        System.out.println("\n -------------------------------------");
        System.out.println("\nWould you like to play again? (y/n): ");
        String choice = ConsoleUtils.readLine();
        if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("yes")) {
            System.out.println("\nThank you for playing, Goodbye");
            return false;
        }
        return true;
    }
    //input functions to keep the menu cleaner

    private String askForName(){
        String name = "";
        while(name.equalsIgnoreCase("")){
            System.out.println("Enter your character's name: ");
            name = ConsoleUtils.readLine();
            if (name.equalsIgnoreCase("")) {
                System.out.println("\nAn adventure must have a name: ");
            }
        }
        return name;
    }
    private String askForClass() {
        String type = "";
        while (!type.equalsIgnoreCase("Warrior") && !type.equalsIgnoreCase("Wizard")) {
            System.out.println("Choose your class (Warrior/ Wizard): ");
            type = ConsoleUtils.readLine();

            if (!type.equalsIgnoreCase("Warrior") && !type.equalsIgnoreCase("Wizard")) {
                System.out.println("Invalid choice. Please type 'Warrior' or 'Wizard.'");
            }
        }
        return type;
    }

}
