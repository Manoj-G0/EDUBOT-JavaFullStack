import java.util.*;

class PermutationsGenerator {
    private static void generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        generatePermutationsHelper(str.toCharArray(), 0, result);
        for (String permutation : result) {
            System.out.println(permutation);
        }
    }

    private static void generatePermutationsHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
        } else {
            for (int i = index; i < chars.length; i++) {
                swap(chars, index, i);
                generatePermutationsHelper(chars, index + 1, result);
                swap(chars, index, i);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";

        generatePermutations(str);
    }
}
