import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

// Define Player class
public class Player {
    private String name;
    private String username;
    private String userID;
    private int goldCoins;
    private int XP;

    public String setUser_ID(String username)
    {
        int len_name = username.length();
        int unique_sum=0;
        for(int x=0;x<len_name;x++)
        {
            unique_sum =+x;
        }
        String partname = Integer.toString(unique_sum);
        return (username+partname);
    }
    String homeGround;
    HashMap<String, Character> army1 = new HashMap<>();


    private static List<String> userProfiles = new ArrayList<>();

    public Player(String name, String username, String playGround) {
        this.name = name;
        this.username = username;
        this.userID = setUser_ID(username);
        this.XP = 0;
        this.goldCoins = 500;
        this.homeGround=playGround;
    }
    public Player(String name, String username,int XP, int goldCoins, String playGround) {
        this.name = name;
        this.username = username;
        this.userID =setUser_ID(username);
        this.XP = XP;
        this.goldCoins = goldCoins;
        this.homeGround=playGround;

    }
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getUserID() {
        return userID;
    }
    public void setUsername(String username){
        this.username=username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public void setXP(int XP) {
        this.XP = XP;
    }
    public int getGoldCoins(){
        return goldCoins;
    }
    public int getXP(){
        return XP;
    }

    // Method to buy character
    public void addCharacter(String characterType, Character character) {
        army1.put(characterType, character);
    }

    public void addEquipment(String characterType, String character, Equipment equipment) {
        for (Character c : army1.values()) {
            if (c.name == character) {
                c.price = (int) (c.price + (equipment.price * 0.2));
                c.attack = c.attack + equipment.attackBonus;
                c.defense = c.defense + equipment.defenseBonus;
                c.health = c.health + equipment.healthBonus;
                c.speed = c.speed + equipment.speedBonus;

            }
        }

    }
    public void showHeroes(){
        System.out.println("Archers : Shooter");
        System.out.println("Knights : Squire");
        if(army1.get("Mage").price==100){
            System.out.println("Mages : Warlock");
        }else {
            System.out.println("Mages : Illusionist");
        }
        System.out.println("Healers : Soother");
        System.out.println("Mythical Creatures : Dragon");
    }
    public void buyCharacter(Character character){
        // Check if the player has enough gold coins
        if (goldCoins >= character.price){
            goldCoins -= character.price;
            army1.put(character.name, character);
            System.out.println(character.name + " bought successfully ! ");
        } else {
            System.out.println("Not enough gold coins to buy " + character.name);
        }
    }
    public void sellCharacter(int Car){
        if(Car==3){
            if(army1.get("Mage").price==100){
                System.out.println("You can't sell this moment bcz of low of goldcoin");
            }else {
                army1.get("Mage").price=100;
                army1.get("Mage").attack=12;
                army1.get("Mage").defense=7;
                army1.get("Mage").health=10;
                army1.get("Mage").speed=12;
                setGoldCoins(8);
                System.out.println("You sell Illusionist and got Warlock");
                System.out.println("Now available goldcoin count: "+getGoldCoins());
            }
        }else{
            System.out.println("You can't sell this moment bcz of low of goldcoin ");
        }
    }
    public void  buyEquipment(){
        System.out.println("You can't buy Equipment this moment bcz of low of goldcoin");

    }
    public static void challenge(Player player1,Player player2,HashMap<String,Character> playArmy1,HashMap<String,Character> playArmy2){
        List<String> Highlanders= Arrays.asList("Shooter", "Ranger","Cavalier", "Zoro", "Enchanter", "Conjurer", "Medic");
        List<String> Marshlanders=Arrays.asList("Squire","Swiftblade","Warlock","Alchemist","Basilisk","Hydra");
        List<String> Sunchildren=Arrays.asList("Sunfire", "Zing", "Templar", "Soother", "Lightbringer", "Dragon", "Phoenix");
        List<String> Mystics=Arrays.asList("Saggitarius", "Illusionist", "Eldritch", "Saint", "Pegasus");
        if (player1.homeGround.equals("Marshland")){
            for(int i=0;i<Marshlanders.size();i++){
                String selectedWarrior=Marshlanders.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshlandersPropertiesBeacuseOfMarshLand(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshlandersPropertiesBeacuseOfMarshLand(c);
                    }
                }
            }
            for(int i=0;i<Sunchildren.size();i++){
                String selectedWarrior=Sunchildren.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeSunchildrenPropertiesBeacuseOfMarshLand(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeSunchildrenPropertiesBeacuseOfMarshLand(c);
                    }
                }
            }
            for(int i=0;i<Mystics.size();i++){
                String selectedWarrior=Mystics.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMysticsPropertiesBeacuseOfMarshLand(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMysticsPropertiesBeacuseOfMarshLand(c);
                    }
                }
            }
        }
        if (player1.homeGround.equals("Desert")){
            for(int i=0;i<Marshlanders.size();i++){
                String selectedWarrior=Marshlanders.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshlandersPropertiesBeacuseOfDesert(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshlandersPropertiesBeacuseOfDesert(c);
                    }
                }
            }
            for(int i=0;i<Sunchildren.size();i++){
                String selectedWarrior=Sunchildren.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeSunchildrenPropertiesBeacuseOfDesert(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeSunchildrenPropertiesBeacuseOfDesert(c);
                    }
                }
            }
        }
        if(player1.homeGround.equals("Hillcrest")){
            for(int i=0;i<Highlanders.size();i++){
                String selectedWarrior=Highlanders.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeHighlanderPropertiesBeacuseOfHillcreat(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeHighlanderPropertiesBeacuseOfHillcreat(c);
                    }
                }
            }
            for(int i=0;i<Marshlanders.size();i++){
                String selectedWarrior=Marshlanders.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshLanderPropertiesBeacuseOfHillcrest(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshLanderPropertiesBeacuseOfHillcrest(c);
                    }
                }
            }
            for(int i=0;i<Sunchildren.size();i++){
                String selectedWarrior=Sunchildren.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeSunchildreenPropertiesBeacuseOfHillcrest(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeSunchildreenPropertiesBeacuseOfHillcrest(c);
                    }
                }
            }
        }
        if(player1.homeGround.equals("Archane")){
            for(int i=0;i<Mystics.size();i++){
                String selectedWarrior=Mystics.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMysticsPropertiesBeacuseOfArchane(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMysticsPropertiesBeacuseOfArchane(c);
                    }
                }
            }
            for(int i=0;i<Highlanders.size();i++){
                String selectedWarrior=Highlanders.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeHighlanderPropertiesBeacuseOfArchane(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeHighlanderPropertiesBeacuseOfArchane(c);
                    }
                }
            }
            for(int i=0;i<Marshlanders.size();i++){
                String selectedWarrior=Marshlanders.get(i);
                for(Character c:playArmy1.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshLanderPropertiesBeacuseOfArchane(c);
                    }
                }
                for(Character c:playArmy2.values()) {
                    if (c.name.equals(selectedWarrior)) {
                        changeMarshLanderPropertiesBeacuseOfArchane(c);
                    }
                }
            }

        }
    }
    public static void  changeMarshlandersPropertiesBeacuseOfMarshLand(Character character){
        character.defense+=2;
    }
    public static void  changeSunchildrenPropertiesBeacuseOfMarshLand(Character character){
        character.attack-=1;
    }
    public static void  changeMysticsPropertiesBeacuseOfMarshLand(Character character){
        character.speed-=1;
    }
    public static void changeMarshlandersPropertiesBeacuseOfDesert(Character character){
        character.health-=1;
    }
    public static void changeSunchildrenPropertiesBeacuseOfDesert(Character character){
        character.attack+=1;
    }
    public static void changeHighlanderPropertiesBeacuseOfHillcreat(Character character){
        character.attack+=1;
        character.defense+=1;
    }
    public static void changeMarshLanderPropertiesBeacuseOfHillcrest(Character character){
        character.speed-=1;
    }
    public static void changeSunchildreenPropertiesBeacuseOfHillcrest(Character character){
        character.speed-=1;
    }
    public static void  changeMysticsPropertiesBeacuseOfArchane(Character character){
        character.attack+=2;
    }
    public static void changeHighlanderPropertiesBeacuseOfArchane(Character character){
        character.speed-=1;
        character.defense-=1;
    }
    public static void changeMarshLanderPropertiesBeacuseOfArchane(Character character){
        character.speed-=1;
        character.defense-=1;
    }


//    public  void inBattle
}