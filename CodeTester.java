public class CodeTester {
    public static void main (String [] args)
    {
        int x = 0;
        int y = 0;
        for (int z = 0; z < 5; z++)
        {
            if((++y > 2) || (++x > 2))   // 2 > 2 = false 2 3 > 2
            {
                System.out.println(z + " " + x + " " + y);
                x++;
            }
        }
        System.out.println(x + " " + y);
    }
}