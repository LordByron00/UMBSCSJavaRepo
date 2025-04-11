package DataStructure;

class HanoiTower extends AbstractTower {

    public HanoiTower(int numberOfDisks, char sourceTower, char targetTower, char auxiliaryTower) {
        super(numberOfDisks, sourceTower, targetTower, auxiliaryTower);
    }

    @Override
    public void solve() {
        moveDisks(numberOfDisks, sourceTower, targetTower, auxiliaryTower);
    }

    private void moveDisks(int numberOfDisks, char sourceTower, char targetTower, char auxiliaryTower) {
        if (numberOfDisks == 1) {
            System.out.println("Moves disk 1 from " + sourceTower + " to " + targetTower);
            return;
        }
        // Move n-1 disks from source to auxiliary tower using target as auxiliary
        moveDisks(numberOfDisks - 1, sourceTower, auxiliaryTower, targetTower);
        System.out.println("Moves disk " + numberOfDisks + " from " + sourceTower + " to " + targetTower);
        // Move n-1 disks from auxiliary to target using auxiliary as source
        moveDisks(numberOfDisks - 1, auxiliaryTower, targetTower, sourceTower);
    }
}