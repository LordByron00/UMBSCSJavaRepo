public class ReviewerTesting {
    int x = 25;
    public static void main(String[] args) {
        ReviewerTesting first = new ReviewerTesting(1);
        {
            int x = 5;
        } 
        {
            int x = 10;
        }
            int x = 100;
        System.out.println(x);
        System.out.println(first.x);
    }
    public ReviewerTesting(int y) 
    {
        x = y;
        System.out.println(x);
    }
}
