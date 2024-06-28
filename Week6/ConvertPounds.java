public class ConvertPounds {
    public static void main(String[] args) {
        double pounds = 10;
        double kilograms = convertIt(pounds);
        System.out.println(pounds + " pounds is equal to " + kilograms + " kilograms.");
    }
    public static double convertIt(double pounds) {
        return pounds * 0.453592;
    }
}
