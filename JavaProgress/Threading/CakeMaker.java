package JavaProgress.Threading;

public class CakeMaker {

    /* Instance Variables */
    private boolean whiskInUse = false;
    private boolean ovenInUse = false;
    private boolean mixingBowlInUse = false;

    /* Main Method */
    public static void main(String[] args) {

        CakeMaker c = new CakeMaker();
        try {

            Thread preheatOven = new Thread(c::preheatOven, "preheatOven");
            Thread mixDryIngredients = new Thread(c::mixDryIngredients, "mixDryIngredients");
            Thread mixWetIngredients = new Thread(c::mixWetIngredients, "mixWetIngredients");
            Thread combineIngredients = new Thread(c::combineIngredients, "combineIngredients");
            Thread bakeCake = new Thread(c::bakeCake, "bakeCake");
            Thread makeFrosting = new Thread(c::makeFrosting, "makeFrosting");
            Thread frostCake = new Thread(c::frostCake, "frostCake");

            preheatOven.start();
            mixDryIngredients.start();
            mixWetIngredients.start();
            makeFrosting.start();
            mixDryIngredients.join();
            mixWetIngredients.join();
            combineIngredients.start();
            combineIngredients.join();
            preheatOven.join();
            bakeCake.start();
            makeFrosting.join();
            bakeCake.join();
            frostCake.start();
            frostCake.join();

            System.out.println("Cake complete!");
        } catch (Exception e) {
            System.out.println(e);
        }
    } // End of Main

    /* Instance Methods */
    public void preheatOven() {
        try {
            printTask("Oven pre-heating...");
            ovenInUse = true;
            Thread.sleep(10000);
            ovenInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void mixDryIngredients() {
        try {
            printTask("Mixing dry ingredients...");
            synchronized (this) {
                while (mixingBowlInUse) {
                    printTask("Waiting for the mixing bowl...");
                    wait();
                }
                mixingBowlInUse = true;
                printTask("Using mixing bowl!");
            }
            Thread.sleep(200);
            printTask("Adding cake flour");
            Thread.sleep(200);
            printTask("Adding salt");
            Thread.sleep(200);
            printTask("Adding baking powder");
            Thread.sleep(200);
            printTask("Adding baking soda");
            Thread.sleep(200);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(200);
            whiskInUse = false;
            synchronized (this) {
                printTask("Releasing mixing bowl!");
                mixingBowlInUse = false;
                notifyAll();
            }
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


    public void mixWetIngredients() {
        try {
            printTask("Mixing wet ingredients...");
            synchronized (this) {
                while (mixingBowlInUse) {
                    printTask("Waiting for mixing bowl...");
                    wait();
                }
                printTask("Using mixing bowl!");
                mixingBowlInUse = true;
            }

            Thread.sleep(1000);
            printTask("Adding butter...");
            Thread.sleep(500);
            printTask("Adding eggs...");
            Thread.sleep(500);
            printTask("Adding vanilla extract...");
            Thread.sleep(500);
            printTask("Adding buttermilk...");
            Thread.sleep(500);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(1500);
            whiskInUse = false;
            synchronized (this) {
                printTask("Releasing mixing bowl!");
                mixingBowlInUse = false;
                notifyAll();
            }
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


    public void combineIngredients() {
        try {
            printTask("Combining ingredients...");
            mixingBowlInUse = true;
            Thread.sleep(1000);
            printTask("Adding dry mix to wet mix...");
            Thread.sleep(1500);
            whiskInUse = true;
            printTask("Mixing...");
            Thread.sleep(1500);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }


    public void bakeCake() {
        try {
            printTask("Baking cake...");
            ovenInUse = true;
            Thread.sleep(10000);
            ovenInUse = false;
            printTask("Done!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void makeFrosting() {
        try {
            printTask("Making frosting...");
            whiskInUse = true;
            mixingBowlInUse = true;
            printTask("Adding butter...");
            Thread.sleep(200);
            printTask("Adding milk...");
            Thread.sleep(200);
            printTask("Adding sugar...");
            Thread.sleep(200);
            printTask("Adding vanilla extract...");
            Thread.sleep(200);
            printTask("Adding salt...");
            Thread.sleep(200);
            whiskInUse = false;
            mixingBowlInUse = false;
            printTask("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void frostCake() {
        try {
            printTask("Frosting cake...");
            Thread.sleep(1500);
            printTask("Done!");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    private void printTask(String task) {
        System.out.println(Thread.currentThread().getName() + " " + " - " + task);
    }
} // End of CakeMaker