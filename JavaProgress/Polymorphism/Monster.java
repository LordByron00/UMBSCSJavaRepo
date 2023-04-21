package JavaProgress.Polymorphism;

public class Monster {
    protected double attack;
    protected String creature;
    protected double max_Health;
    protected double defense;
    protected double current_Health;

    public Monster(String creature, Double attack, Double max_Health, Double defense, double current_Health) {
        this.attack = attack;
        this.defense = defense;
        this.max_Health = max_Health;
        this.creature = creature;
        this.current_Health = current_Health;
    }

    protected void attack(Monster target_Monster) {

        target_Monster.current_Health = Math.ceil((target_Monster.current_Health * target_Monster.defense - this.attack) / (target_Monster.max_Health * target_Monster.defense) * target_Monster.max_Health);

        System.out.println(this.creature + " has attacked " + target_Monster.creature + ".\nHealth: " + target_Monster.current_Health + "/" + target_Monster.max_Health);
    }
}
