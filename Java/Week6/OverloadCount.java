public class OverloadCount {
    public static void main(String[] args) {
        System.out.println(find(5, 10, 15, 20)); 
        System.out.println(find(10, 5, 15)); 
        System.out.println(find(25)); 
    }

    public static String find(int a, int b, int c, int d) {
        int max = Math.max(Math.max(a, b), Math.max(c, d));
        return "The largest parameter is " + max;
    }

    public static String find(int a, int b, int c) {
        int min = Math.min(Math.min(a, b), c);
        return "The smallest parameter is " + min;
    }

    public static String find(int a) {
        double sqrt = Math.sqrt(a);
        return "The square root of " + a + " is approximately " + String.format("%.1f", sqrt);
    }
}
