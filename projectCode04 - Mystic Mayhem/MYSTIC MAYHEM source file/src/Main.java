import java.util.*;

// Main class
public class Main
{
    private  static List<String> userProfiles = new ArrayList<>();
    public static boolean createUserProfile(Player player,String name, String username)
    {
        // Check if username is already taken
        boolean usernameOK=true;
        for (String profile : userProfiles)
        {
            if (player.getUsername().equals(username))
            {
                System.out.println("Username '" + username + "' is already taken. Please choose a different username.");
                usernameOK=false;
            }
        }
        return usernameOK;}
    public static void main(String[] args)
    {
        int x;
        while(true){
        try{



            Player player1= new Player("GeraltofRivia", "whitewolf", 32,215,"Marshland");
            player1.addCharacter("Archer",new Character("Ranger", 115, 14, 5, 8, 10));
            player1.addCharacter("Knight",new Character("Squire", 85, 8, 9, 7, 8));
            player1.addCharacter("Mage",new Character("Warlock", 100, 12, 7, 10, 12));
            player1.addCharacter("Healer",new Character("Medic", 125, 12, 9, 10, 7));
            player1.addCharacter("MythicalCreature",new Character("Dragon", 120, 12, 14, 15, 8));
            player1.addEquipment("Archer","Ranger",new Equipment("Chainmail", 70, 0, 1, 0, -1, "Armour"));
            player1.addEquipment("Healer","Medic",new Equipment("Amulet", 200, 0, -1, 1, 1, "Artefacts"));

            // Another profile/testing purpose--
            Player player3= new Player("GeraltofRivia", "whitewolf", 32,215,"Marshland");
            player3.addCharacter("Archer",new Character("Saggitarius", 230, 50, 7, 12, 7));
            player3.addCharacter("Knight",new Character("Swiftblade", 250, 50, 20, 17, 13));
            player3.addCharacter("Mage",new Character("Eldritch", 270, 50, 17, 18, 14));
            player3.addCharacter("Healer",new Character("Lightbringer", 260, 50, 15, 19, 12));
            player3.addCharacter("MythicalCreature",new Character("Pegasus", 340, 50, 18, 20, 20));
            player3.addEquipment("Archer","Saggitarius",new Equipment("Chainmail", 70, 0, 1, 0, -1, "Armour"));
            player1.addEquipment("Healer","Lightbringer",new Equipment("Amulet", 200, 0, -1, 1, 1, "Artefacts"));




            System.out.println(" ---------------------------------------------------------------------------------------");
            System.out.println("|                            WELCOME TO MYSTIC MAYHEM                                  |");
            System.out.println(" ---------------------------------------------------------------------------------------");

            Scanner obj_2 = new Scanner(System.in);
            Scanner obj_3 = new Scanner(System.in);
            Scanner obj_8 = new Scanner(System.in);
            Scanner obj_9 = new Scanner(System.in);
            int choice_1;
            System.out.println("                    ALREADY HAVE AN ACCOUNT                         ");
            System.out.println("                 ENTER THE NUM OF YOUR ANSWER                       ");
            Scanner obj_1 = new Scanner(System.in);
            System.out.print("1] YES / 2] NO : ");
            choice_1 = obj_1.nextInt();
            System.out.println("\n");
            if(choice_1 == 1)
            {
                System.out.println("");
            }
            else if(choice_1 == 2)
            {
                System.out.println("---------------------------  CREATE YOUR PLAYER PROFILE ---------------------------------");
                System.out.println("Enter Player Name :");
                String player_name = obj_8.nextLine();
                System.out.println("Enter User Name :");
                String user_name = obj_2.nextLine();
                System.out.println("Choose Your War Ground :");
                System.out.println("1.Hillcrest, 2.Marshland, 3.Desert, 4.Archane \n");
                String war_ground = obj_3.nextLine();
                Player player2= new Player(player_name,user_name,war_ground);
                boolean canCreatedProfile2=createUserProfile(player2, player2.getName(),player2.getUsername());
                if(canCreatedProfile2){
                    userProfiles.add(player1.getUsername());
                }
                else{
                    canCreatedProfile2=createUserProfile(player1,player1.getName(), player1.getUsername());
                    while(!canCreatedProfile2){
                        System.out.println("Give another Username:");
                        Scanner input1=new Scanner(System.in);
                        String username=input1.nextLine();
                        player1.setUsername(username);
                        canCreatedProfile2=createUserProfile(player1,player1.getName(), player1.getUsername());

                    }
                }
                Scanner obj_7 = new Scanner(System.in);

                System.out.println("NEW PLAYER CAN PURCHASE ONLY FOLLOWING CHARACTERS");

                System.out.println("Army Selection Category 1 for New Player: Shooter , Squire , Warlock , Soother , Dragon");

                System.out.println("Name    : Shooter    Squire    Warlock    Soother    Dragon");
                System.out.println("price   :      80        85        100         95       120");
                System.out.println("Attack  :      11         8         12         10        12");
                System.out.println("Defence :      40         9          7          8        14");
                System.out.println("Health  :       6         7         10          9        15");
                System.out.println("Speed   :       9         8         12          6         8");

                System.out.println("Army Selection Category 2 for New Player: Shooter , Squire , Illusionist , Soother , Dragon");

                System.out.println("Name    : Shooter    Squire    Illusionist    Soother    Dragon");
                System.out.println("price   :      80        85           120          95       120");
                System.out.println("Attack  :      11         8            13          10        12");
                System.out.println("Defence :      40         9             8           8        14");
                System.out.println("Health  :       6         7            12           9        15");
                System.out.println("Speed   :       9         8            14           6         8");
                System.out.println("Choose Your Army >>> Press 1 for Category 1.   Press 2 for Category 2.");

                int choice = obj_7.nextInt();

                if(choice==1)
                {
                    player2.addCharacter("Archer",new Character("Shooter", 80, 11, 40, 6, 9));
                    player2.addCharacter("Knight",new Character("Squire", 85, 8, 9, 7, 8));
                    player2.addCharacter("Mage",new Character("Warlock", 100, 12, 7, 10, 12));
                    player2.addCharacter("Healer",new Character("Soother", 95, 10, 8, 9, 6));
                    player2.addCharacter("MythicalCreature",new Character("Dragon", 120, 12, 14, 15, 8));
                    player2.setGoldCoins(20);
                    System.out.println("New Goldcoin count: "+player2.getGoldCoins());

                }
                else if(choice==2)
                {
                    player2.addCharacter("Archer",new Character("Shooter", 80, 11, 40, 6, 9));
                    player2.addCharacter("Knight",new Character("Squire", 85, 8, 9, 7, 8));
                    player2.addCharacter("Mage",new Character("Illusionist", 120, 13, 8, 12, 14));
                    player2.addCharacter("Healer",new Character("Soother", 95, 10, 8, 9, 6));
                    player2.addCharacter("MythicalCreature",new Character("Dragon", 120, 12, 14, 15, 8));
                    player2.setGoldCoins(0);
                    System.out.println("New Goldcoin count: "+ player2.getGoldCoins());
                }

                try {
                    final String os = System.getProperty("os.name");

                    if (os.contains("Windows")) {
                        // For Windows
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else {
                        // For Linux and macOS
                        new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
                    }
                } catch (Exception e) {
                    System.out.println("Error while clearing the console: " + e.getMessage());
                }

                System.out.println(" ---------------------------------------------------------------------------------------");
                System.out.println("|                              Mystic Mayhem                                            |");
                System.out.println(" ---------------------------------------------------------------------------------------");


                System.out.println("What's Next");
                System.out.println("        1. Battle\n" +
                        "        2. Buy Hero\n" +
                        "        3. Sell Hero\n" +
                        "        4. Buy Equipment\n" +
                        "        5. Rename\n" +
                        "        6. Show Heroes\n" +
                        "        7. Show Equipments\n" +
                        "        8. Show Gold Coins\n" +
                        "        9. Exit");
                System.out.println("Choose between -1/2/3/4/5/6/7/8/9-");
                Scanner input=new Scanner(System.in);
                int options=input.nextInt();


                try {
                    final String os = System.getProperty("os.name");

                    if (os.contains("Windows")) {
                        // For Windows
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else {
                        // For Linux and macOS
                        new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
                    }
                } catch (Exception e) {
                    System.out.println("Error while clearing the console: " + e.getMessage());
                }

                System.out.println(" ---------------------------------------------------------------------------------------");
                System.out.println("|                              Mystic Mayhem                                            |");
                System.out.println(" ---------------------------------------------------------------------------------------");


                while (true){
                    try {
                        final String os = System.getProperty("os.name");

                        if (os.contains("Windows")) {
                            // For Windows
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } else {
                            // For Linux and macOS
                            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
                        }
                    } catch (Exception e) {
                        System.out.println("Error while clearing the console: " + e.getMessage());
                    }

                    System.out.println(" ---------------------------------------------------------------------------------------");
                    System.out.println("|                              Mystic Mayhem                                            |");
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("What's Next");
                    System.out.println("        1. Battle\n" +
                            "        2. Buy Hero\n" +
                            "        3. Sell Hero\n" +
                            "        4. Buy Equipment\n" +
                            "        5. Show Heroes\n" +
                            "        6. Show Gold Coins\n");
                    System.out.println("Choose between  1/2/3/4/5/6/7/8/9 ");
                    Scanner input1=new Scanner(System.in);
                    int options1=input.nextInt();


                    try {
                        final String os = System.getProperty("os.name");

                        if (os.contains("Windows")) {
                            // For Windows
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        } else {
                            // For Linux and macOS
                            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
                        }
                    } catch (Exception e) {
                        System.out.println("Error while clearing the console: " + e.getMessage());
                    }
                    if(options==1){
                        System.out.println(" ---------------------------------------------------------------------------------------");
                        System.out.println("|                              Mystic Mayhem                                            |");
                        System.out.println("----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        HashMap<String,Character> playArmy1=player1.army1;
                        HashMap<String,Character> playArmy2=player2.army1;
                        Player.challenge(player1,player2,playArmy1,playArmy2);
                        Battle.performTurn(playArmy1,playArmy2,player1,player2);

                        System.out.println(player2.getName()+"XP: "+player2.getXP()+" GoldCoins: "+player2.getGoldCoins());
                        System.out.println(player1.getName()+"XP: "+player1.getXP()+" GoldCoins: "+player1.getGoldCoins());

                        break;


                    } else if (options==2) {
                        System.out.println(" ---------------------------------------------------------------------------------------");
                        System.out.println("|                              Mystic Mayhem                                            |");
                        System.out.println("----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        System.out.println("You don't have enough money to purchase a new character.");
                        System.out.println("\n");
                        try {
                            for(int i = 3; i > 0; i--) {
                                Thread.sleep(1000);
                            }     // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            // Handle the exception if necessary
                        }
                        continue;
                    } else if (options==3) {
                        System.out.println(" ---------------------------------------------------------------------------------------");
                        System.out.println("|                              Mystic Mayhem                                            |");
                        System.out.println("----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        System.out.println("What character you want to sell? Input Number");
                        System.out.println("1.Archers 2.Knights 3.Mages 4.Healers 5.MythicaCreatures");
                        Scanner input02 = new Scanner(System.in);
                        int sellCharacterOne=input02.nextInt();
                        player2.sellCharacter(sellCharacterOne);
                        System.out.println("\n");
                        try {
                            for(int i = 3; i > 0; i--) {
                                System.out.println(i);
                                Thread.sleep(1000);
                            }     // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            // Handle the exception if necessary
                        }
                        continue;
                    } else if (options==4) {
                        System.out.println(" ---------------------------------------------------------------------------------------");
                        System.out.println("|                              Mystic Mayhem                                            |");
                        System.out.println("----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        player2.buyEquipment();
                        System.out.println("\n");
                        try {
                            for(int i = 3; i > 0; i--) {
                                System.out.println(i);
                                Thread.sleep(1000);
                            }     // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            // Handle the exception if necessary
                        }
                        continue;
                    } else if (options==5) {
                        System.out.println(" ---------------------------------------------------------------------------------------");
                        System.out.println("|                              Mystic Mayhem                                            |");
                        System.out.println("----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        player2.showHeroes();
                        System.out.println("\n");
                        try {
                            for(int i = 3; i > 0; i--) {
                                System.out.println(i);
                                Thread.sleep(1000);
                            }     // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            // Handle the exception if necessary
                        }
                        continue;
                    } else if (options==6) {
                        System.out.println(" ---------------------------------------------------------------------------------------");
                        System.out.println("|                              Mystic Mayhem                                            |");
                        System.out.println("----------------------------------------------------------------------------------------");
                        System.out.println("\n");
                        System.out.println("Goldcoin Count: "+player2.getGoldCoins());
                        System.out.println("\n");
                        try {
                            for(int i = 3; i > 0; i--) {
                                System.out.println(i);
                                Thread.sleep(1000);
                            }     // 1000 milliseconds = 1 second
                        } catch (InterruptedException e) {
                            // Handle the exception if necessary
                        }
                        continue;
                    }
                }

            }
        }catch(InputMismatchException fw){
            System.out.println("INVALID INPUT");
            Scanner in_1 = new Scanner(System.in);
            System.out.println("                PRESS 0 TO EXIT THE GAME / PRESS 1 TO START NEW GAME                ");
            int choice_0=in_1.nextInt();
            if(choice_0==0){
                break;
            }
        }
    }
    }
}

