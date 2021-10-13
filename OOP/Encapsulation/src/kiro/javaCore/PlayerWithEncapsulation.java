package kiro.javaCore;

public class PlayerWithEncapsulation {

    private String name;        // not directly accessible (good thing!)
    private int hitPoints;
    private String weapon;

    public PlayerWithEncapsulation(String name, int health, String weapon) {
        // guaranteed initialization
        this.name = name;
        this.weapon = weapon;
        if (health > 0 && health <= 100)        // validation
            this.hitPoints = health;
        else
            this.hitPoints = 100;      // default
    }

    public void loseHealth(int damage) {
        if (damage < 0)
            damage = 0;
        this.hitPoints = this.hitPoints - damage;
        if (this.hitPoints <=0) {
            System.out.println("Player is dead");
            hitPoints = 0;
        }
    }

    public int getHitPoints() {
        return hitPoints;          // getters and setters solve the problem of complicated maintenance
    }
}
