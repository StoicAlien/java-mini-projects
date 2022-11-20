package main;

/**
 *
 * @author rickt
 */
public class Main {

    public static void main(String[] args) {
         Warrior player1 = new Warrior();
         
         player1.attack();
         player1.defend();
         player1.move();
         player1.pray();
         System.out.println("****************************************************************");
         
         Mage player2 = new Mage();
         
         player2.attack();
         player2.defend();
         player2.move();
         System.out.println("****************************************************************");
         
         Rogue player3 = new Rogue();
         
         player3.attack();
         player3.defend();
         player3.move();
         System.out.println("****************************************************************");
         
         Class player4 = new Class();
         
         player4.attack();
         player4.defend();
         player4.move();
         System.out.println("****************************************************************");
    }
    
}
