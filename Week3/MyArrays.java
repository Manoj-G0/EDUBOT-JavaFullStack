import java.util.Arrays;

public class MyArrays {
    public static void main(String[] args) {
        String[] bollywood = {"Amitabh Bachchan", "Shah Rukh Khan", "Aamir Khan", "Salman Khan"};
        System.out.println(bollywood[0]);
        System.out.println(bollywood[1]);
        System.out.println(bollywood[2]);
        System.out.println(bollywood[3]);

        for (int i = 0; i < bollywood.length; i++) {
            System.out.println(bollywood[i]);
        }
        bollywood = Arrays.copyOf(bollywood, bollywood.length + 1);
        bollywood[4] = "Ranbir Kapoor";
        String searchElement = "Aamir Khan";
        for (int i = 0; i < bollywood.length; i++) {
            if (bollywood[i].equals(searchElement)) {
                System.out.println(searchElement + " found at index " + i);
                break;
            }
        }
        Arrays.sort(bollywood);
        for (String actor : bollywood) {
            System.out.println(actor);
        }
        int[] ages = {25, 30, 45, 35, 50};
        for (int age : ages) {
            System.out.println(age);
        }
        Arrays.sort(ages);
        for (int age : ages) {
            System.out.println(age);
        }
    }
}
