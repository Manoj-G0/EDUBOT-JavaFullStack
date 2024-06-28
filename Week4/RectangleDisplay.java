public class RectangleDisplay {
    public static void main(String[] args) {
        System.out.println(isSilly(10, 5));
        System.out.println(diagonal(3, 4));
        randomRec();
    }

    public static boolean isSilly(int width, int height) {
        return (width == height);
    }

    public static double diagonal(int width, int height) {
        return Math.sqrt(width * width + height * height);
    }

    public static void randomRec() {
        int width = (int) (Math.random() * 100) + 1;
        int height = (int) (Math.random() * 100) + 1;
        System.out.println("Random Rectangle: " + width + "x" + height);
    }
}
