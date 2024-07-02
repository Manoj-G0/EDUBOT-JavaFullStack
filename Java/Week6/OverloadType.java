public class OverloadType {
    public static void main(String[] args) {
        System.out.println(sum(5, 2.5f)); 
        System.out.println(sum("SampleString", 3)); 
    }
    public static float sum(int a, float b) {
        return Math.round(a + b);
    }

    public static String sum(String str, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(str).append(" ");
        }
        return result.toString().trim();
    }
}
