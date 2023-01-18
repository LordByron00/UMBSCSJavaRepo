
public class ProductInventory {
    public static void main(String[] args) {
        String[][] products = new String[][]{{"Corned Beef", "Tuna", "Beef loaf"},
                                             {"Condensed Milk", "Evap Milk", "Kremdensada"},
                                             {"Sprite", "Coke Zero", "Pepsi"}};
        System.out.println("PRODUCTS:");
        for (int i = 0; i < products.length; i++) {
            if (i == 0) {
                System.out.print(i + 1 + ". Canned food - ");  
            } else if (i == 1) {
                System.out.print(i + 1 + ". Canned milk - ");  
            } else if (i == 2) {
                System.out.print(i + 1 + ". Canned drink - ");  
            }

            for (int j = 0; j < products[i].length; j++) {
                if (j == products[i].length - 1) {
                    System.out.print(products[i][j] + ".");
                } else {
                    System.out.print(products[i][j] + ", ");
                }
                
            }
            System.out.println();
            // Another solution
            //System.out.println(Arrays.toString(products[i]));

        }
    }

}
