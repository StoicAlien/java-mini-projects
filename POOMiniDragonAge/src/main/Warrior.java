package main;

/**
 *
 * @author rickt
 */
public class Warrior extends Class {
    private String protection;

    public Warrior() {
        super("Warrior", 30, 15, "Pure Rage", false, "sword");
        this.protection = "Shield";
    }
    
    public void pray(){
        System.out.println("The " + getTheClass() + " starts to pray to their Goddess!");
        accessTempMagic();
        System.out.println("The " + getTheClass() + " is glowing with the righteous magic of the Goddess!");
    }
    
    @Override
    public void attack(){
        super.attack();
        System.out.println("The " + getTheClass() + " uses their " + getWeapon() + " to cut down the enemy!");
    }
    
    @Override
    public void defend(){
        super.defend();
        System.out.println("The " + getTheClass() + " uses their " + protection + " to defend!");
    }
    
    @Override
    public void move(){
        super.move();
        System.out.println("The " + getTheClass() + " starts to run!");
    }
    
}
