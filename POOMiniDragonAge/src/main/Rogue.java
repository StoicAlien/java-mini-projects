package main;

/**
 *
 * @author rickt
 */
public class Rogue extends Class{
    
    public Rogue() {
        super("Rogue", 8, 6, "Backstab", false, "dagger");
    }
    
    @Override
    public void attack(){
        super.attack();
        System.out.println("The " + getTheClass() + " uses their " + getWeapon() + " to stab an enemy!");
    }
    
    @Override
    public void defend(){
        super.defend();
        this.evade();
    }
    
    @Override
    public void move(){
        super.move();
        this.rogueMove();
    }
    
    private void evade(){
        System.out.println("The " + getTheClass() + " avoids the strike!");
    }
    
    private void rogueMove(){
        System.out.println("The " + getTheClass() + " conceals into the shadows!");
    }
    
}
