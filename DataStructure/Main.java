package DataStructure;

public class Main {

    public static void main(String[] args) {
        int numberOfDisks = 3;
        char sourceTower = 'A';
        char targetTower = 'C';
        char auxiliaryTower = 'B';

        HanoiTower solver = new HanoiTower(numberOfDisks, sourceTower, targetTower, auxiliaryTower);
        solver.solve();
    }
}