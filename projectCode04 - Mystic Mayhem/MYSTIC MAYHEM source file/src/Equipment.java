class Equipment {
    String name;
    int price;
    double attackBonus;
    double defenseBonus;
    double healthBonus;
    double speedBonus;
    String equipmentType;

    // Constructor
    public Equipment(String name, int price, double attackBonus, double defenseBonus, double healthBonus, double speedBonus,String equipmentType) {
        this.name = name;
        this.price = price;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.healthBonus = healthBonus;
        this.speedBonus = speedBonus;
        this.equipmentType = equipmentType;
    }
}