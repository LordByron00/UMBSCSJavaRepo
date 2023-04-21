package JavaProgress.Polymorphism;

public class MonsterGame {
    public static void main(String[] args) {
        Monster Skeleton_King = new Vampire();
        Monster Lycan = new Wolf();
        while (Skeleton_King.current_Health > 0 && Lycan.current_Health > 0) {
            Lycan.attack(Skeleton_King);
            Skeleton_King.attack(Lycan);
        }

    }
}
