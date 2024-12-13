import java.util.*;
import java.util.function.DoubleUnaryOperator;
class Battle {
    static int j=0;
    static int k=0;
    private static  int turns=10;

    public static String speedTest(HashMap<String,Character> army) {
        List<String> armyChara = Arrays.asList("Archer", "Knight", "Mage", "Healer", "MythicalCreature");
        double max=0;
        String maxSpeedCharacter=null;
        for(int i = 0; i < armyChara.size(); i++) {
            String warCharacter;
            warCharacter = armyChara.get(i);
            if(army.get(warCharacter).health<=0){
                continue;
            }
            if(max<=army.get(warCharacter).speed){
                max=army.get(warCharacter).speed;
            }
        }

        List<String> prioritySpeed= Arrays.asList("Healer","Mage","MythicalCreature","Knight","Archer");
        String speedCharacterFinal=null;
        for(int i = 0; i < prioritySpeed.size(); i++){

            String temCharacter2=null;
            temCharacter2 = prioritySpeed.get(i);
            if(max==army.get(temCharacter2).speed){
                speedCharacterFinal=temCharacter2;
                break;
            }

        }
        return speedCharacterFinal;
    }
    public static String defenceTest(HashMap<String, Character> army) {
        List<String> armyChara = Arrays.asList("Archer", "Knight", "Mage", "Healer", "MythicalCreature");
        double min=1000;
        String minDefenceCharacter=null;
        for(int i = 0; i < armyChara.size(); i++) {
            String warCharacter;
            warCharacter = armyChara.get(i);
            if(army.get(warCharacter).health<=0){
                continue;
            }
            if(min>=army.get(warCharacter).defense){
                min=army.get(warCharacter).defense;
            }
        }

        List<String> priorityDefence = Arrays.asList("Mage","Knight","Archer","MythicalCreature","Healer");
        String defenceCharacterFinal=null;
        for(int i = 0; i < priorityDefence.size(); i++){

            String temCharacter2=null;
            temCharacter2 = priorityDefence.get(i);
            if(min==army.get(temCharacter2).defense){
                defenceCharacterFinal=temCharacter2;
                break;
            }

        }
        return defenceCharacterFinal;
    }
    public static String healthTest(HashMap<String, Character> army) {
        List<String> armyChara = Arrays.asList("Archer", "Knight", "Mage", "Healer", "MythicalCreature");

        double min=1000;
        String minHealthCharacter=null;
        for(int i = 0; i < armyChara.size(); i++) {
            String warCharacter;
            warCharacter = armyChara.get(i);
            if(army.get(warCharacter).health<=0){
                continue;
            }
            if(min>=army.get(warCharacter).health){
                min=army.get(warCharacter).health;
                minHealthCharacter=warCharacter;
            }
        }
        return minHealthCharacter;
    }
    // Perform a turn in the battle
    public static void performTurn(HashMap<String,Character> characterset1,HashMap<String,Character> characterset2,Player player1,Player player2){ //characterset1=defult
        System.out.println(" ----------------------------------------");
        System.out.println("|        "+player2.getName()+" vs "+player1.getName()+"        |");
        System.out.println(" ----------------------------------------");
        DoubleUnaryOperator handleNegativeHealth = health -> health < 0 ? 0 : health;

        int count=1;
        while (count <= 10) {
            System.out.println("Turn "+count+": "+player2.getName());
            String firstAttackerArmy2=speedTest(characterset2);
            if(firstAttackerArmy2!="Healer"){
                String firstDefencerArmy2=defenceTest(characterset1);
                System.out.println(firstDefencerArmy2);
                System.out.println(characterset2.get(firstAttackerArmy2).name+" attacks "+ characterset1.get(firstDefencerArmy2).name );
                characterset1.get(firstDefencerArmy2).health-=((0.5*characterset2.get(firstAttackerArmy2).attack)-(0.1*characterset1.get(firstDefencerArmy2).defense));
                System.out.println( characterset1.get(firstDefencerArmy2).name +"'s health: "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset1.get(firstDefencerArmy2).health)));
                System.out.println( characterset2.get(firstAttackerArmy2).name+"'s health: "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset2.get(firstAttackerArmy2).health)));
                if(characterset1.get(firstDefencerArmy2).health<=0){
                    System.out.println(characterset1.get(firstDefencerArmy2).name+" died!");
                }
            }
            else if(firstAttackerArmy2=="Healer"){
                String firstHealwant2=healthTest(characterset2);
                System.out.println(characterset2.get(firstAttackerArmy2)+" heal "+ characterset2.get(firstHealwant2).name);
                characterset2.get(firstHealwant2).health+=(0.1*characterset2.get(firstAttackerArmy2).attack);
                System.out.println(characterset2.get(firstHealwant2).name +"’s health : "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset2.get(firstHealwant2).health)));
                System.out.println(characterset2.get(firstAttackerArmy2).name +"’s health : "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset2.get(firstAttackerArmy2).health)));
            }

            System.out.println("--");
            try {
                for(int i = 3; i > 0; i--) {
                    Thread.sleep(500);
                }     // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                // Handle the exception if necessary
            }
            System.out.println("Turn "+(count)+": GeraltofRivia");
            String firstAttackerArmy1=speedTest(characterset1);
            if(firstAttackerArmy1!="Healer"){
                String firstDefencerArmy1=defenceTest(characterset2);
                System.out.println(characterset1.get(firstAttackerArmy1).name+" attacks "+ characterset2.get(firstDefencerArmy1).name);
                characterset2.get(firstDefencerArmy1).health-=(0.5*characterset1.get(firstAttackerArmy1).attack)-(0.1*characterset2.get(firstDefencerArmy1).defense);
                System.out.println(characterset2.get(firstDefencerArmy1).name +"'s health: "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset2.get(firstDefencerArmy1).health)));
                System.out.println( characterset1.get(firstAttackerArmy1).name+"'s health: "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset1.get(firstAttackerArmy1).health)));
                if(characterset2.get(firstDefencerArmy1).health<=0){
                    System.out.println(characterset2.get(firstDefencerArmy1).name+" died!");
                }
            }else if(firstAttackerArmy1=="Healer") {
                String firstHealwant1=healthTest(characterset1);
                System.out.println(characterset1.get(firstAttackerArmy1)+" heal "+ characterset1.get(firstHealwant1).name );
                characterset1.get(firstHealwant1).health+=(0.1*characterset1.get(firstAttackerArmy1).attack);
                System.out.println(characterset1.get(firstHealwant1).name +"'s health : "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset1.get(firstHealwant1).health)));
                System.out.println(characterset1.get(firstAttackerArmy1).name +"'s health : "+String.format("%.1f",handleNegativeHealth.applyAsDouble(characterset1.get(firstAttackerArmy1).health)));
            }
            System.out.println("---------------------");
            try {
                for(int i = 3; i > 0; i--) {
                    Thread.sleep(500);
                }     // 1000 milliseconds = 1 second
            } catch (InterruptedException e) {
                // Handle the exception if necessary
            }
            count++;
        }
        Battle.getOutcome(characterset1,characterset2,player1,player2);

    }


    public static void getOutcome(HashMap<String,Character> characterset1,HashMap<String,Character> characterset2,Player player1,Player player2){
        String winner=null;
        List<String> armyChara = Arrays.asList("Archer", "Knight", "Mage", "Healer", "MythicalCreature");
        int numDied1=0;
        for(int i=0;i<armyChara.size();i++){
            String character=armyChara.get(i);
            if(characterset1.get(character).health<=0){
                numDied1++;
            }
        }
        if(numDied1==5){
            System.out.println(player2.getName()+" won!");
            player2.setGoldCoins(player2.getGoldCoins()+(int)(player1.getGoldCoins()*0.1));
            player2.setXP(player2.getXP()+1);

        }
        int numDied2=0;
        for(int i=0;i<armyChara.size();i++){
            String character=armyChara.get(i);
            if(characterset2.get(character).health<=0){
                numDied1++;
            }
        }
        if(numDied2==5){
            System.out.println(player1.getName()+" won!");
            player1.setGoldCoins(player1.getGoldCoins()+(int)(player2.getGoldCoins()*0.1));
            player1.setXP(player1.getXP()+1);
        }
        if(numDied1!=5 & numDied2!=5){
            System.out.println("draw");


        }

    }
}
