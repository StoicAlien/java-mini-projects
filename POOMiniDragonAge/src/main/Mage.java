package main;

/**
 *
 * @author rickt
 */
public class Mage extends Class{
    
    public Mage() {
        super("Mage", 15, 15, "Devil's Tornado", true, "staff");
    }
    
    @Override
    public void attack(){
        super.attack();
        System.out.println("The " + getTheClass() + " uses their " + getWeapon() + " to cast an offense spell!");
    }
    
    @Override
    public void defend(){
        super.defend();
        System.out.println("The " + getTheClass() + " casts a ward to defend!");
    }
    
    @Override
    public void move(){
        super.move();
        this.mageMove();
    }
    
    private void mageMove(){
        System.out.println("The " + getTheClass() + " starts to walk with caution!");
    }
    
}
