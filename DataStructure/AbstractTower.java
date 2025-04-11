package DataStructure;

public abstract class AbstractTower {

    protected int numberOfDisks;
    protected char sourceTower;
    protected char targetTower;
    protected char auxiliaryTower;

    public AbstractTower(int numberOfDisks, char sourceTower, char targetTower, char auxiliaryTower) {
        this.numberOfDisks = numberOfDisks;
        this.sourceTower = sourceTower;
        this.targetTower = targetTower;
        this.auxiliaryTower = auxiliaryTower;
    }

    public abstract void solve();
}