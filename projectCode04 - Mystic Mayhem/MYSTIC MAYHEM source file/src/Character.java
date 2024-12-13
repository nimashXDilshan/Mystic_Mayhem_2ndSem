import java.util.*;

// Define the Character class to represent each character in the game
class Character {
    String name;
    int price;
    double attack;
    double defense;
    double health;
    double speed;
    // Additional attributes for equipment
    Equipment artefact;
    Equipment armour;
    // Constructor
    public Character(String name, int price, double attack, double defense, double health, double speed) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.health = health;
        this.speed = speed;
    }

    // Method to equip artefact
    public void equipArtefact(Equipment artefact) {
        this.artefact = artefact;
    }

    // Method to equip armour
    public void equipArmour(Equipment armour) {
        this.armour = armour;
    }

    // Method to calculate total attack considering equipment
    public double getTotalAttack() {
        double totalAttack = attack;
        if (artefact != null) {
            totalAttack += artefact.attackBonus;
        }
        return totalAttack;
    }

    // Similar methods can be implemented for defense, health, and speed with equipment bonuses
}

