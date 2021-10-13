package kiro.javaCore;

public class Main {

    public static void main(String[] args) {

        // Class without encapsulation
        PlayerWithoutEncapsulation player1 = new PlayerWithoutEncapsulation();
        player1.name = "Kiro";          // problem 1: manual (no guaranteed) initialization
        player1.health = 100;           // problem 2: no validation of field values;
        player1.weapon = "Crossbow";    // problem 3: complicated maintenance if field names change;

        int damage = 10;
        player1.loseHealth(damage);
        System.out.println("Remaining health = " + player1.healthRemaining());

        damage = 91;
        player1.health = 100;           // problem 4: no control over access to fields;
        player1.loseHealth(damage);
        System.out.println("Remaining health = " + player1.healthRemaining());

        // Class with encapsulation
        PlayerWithEncapsulation player2 = new PlayerWithEncapsulation("Kiro",
                100, "Staff");

        player2.loseHealth(90);
        System.out.println("Remaining health = " + player2.getHitPoints());

        player2.loseHealth(15);
        System.out.println("Remaining health = " + player2.getHitPoints());
    }
}
