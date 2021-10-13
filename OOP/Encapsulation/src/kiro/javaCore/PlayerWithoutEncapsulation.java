package kiro.javaCore;

public class PlayerWithoutEncapsulation {

    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <=0) {
            System.out.println("Player is dead");
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}
