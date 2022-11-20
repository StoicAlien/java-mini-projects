package main;

/**
 *
 * @author rickt
 */
public class Class {
    private int hp, mp, offense, defense, level;
    private String specialTechnique, theClass, weapon;
    private boolean magic;
    
    public Class(){
        this("Peasant", 10, 0, 5, 5, "None", false, "pitchfork");
    }
    
    public Class(String theClass, int offense, int defense, String specialTechnique, boolean magic, String weapon){
        this(theClass, 100, 100, offense, defense, specialTechnique, magic, weapon);
    }
    
    public Class(String theClass, int hp, int mp, int offense, int defense, String specialTechnique, boolean magic, String weapon) {
        this.theClass = theClass;
        this.hp = hp;
        this.mp = mp;
        this.offense = offense;
        this.defense = defense;
        this.specialTechnique = specialTechnique;
        this.magic = magic;
        this.weapon = weapon;
    }
    
    public void attack(){
        System.out.println("The " + theClass + " attacks!");
    }
    
    public void defend(){
        System.out.println("The " + theClass + " defends!");
    }
    
    public void move(){
        System.out.println("The " + theClass + " moves!");
    }
    
    public void accessTempMagic(){
        this.magic = true;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getOffense() {
        return offense;
    }

    public int getDefense() {
        return defense;
    }

    public int getLevel() {
        return level;
    }

    public String getSpecialTechnique() {
        return specialTechnique;
    }

    public String getTheClass() {
        return theClass;
    }

    public String getWeapon() {
        return weapon;
    }

    public boolean isMagic() {
        return magic;
    }
    
}
