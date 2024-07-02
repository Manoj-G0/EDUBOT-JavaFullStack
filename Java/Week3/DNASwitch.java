import java.util.Scanner;

public class DNASwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder dnaSequence = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            System.out.print("Enter a DNA nucleotide: ");
            char nucleotide = scanner.next().charAt(0);
            nucleotide = Character.toUpperCase(nucleotide);

            switch (nucleotide) {
                case 'A':
                    System.out.println("A. Adenine");
                    break;
                case 'C':
                    System.out.println("C. Cytosine");
                    break;
                case 'G':
                    System.out.println("G. Guanine");
                    break;
                case 'T':
                    System.out.println("T. Thymine");
                    break;
                default:
                    System.out.println("Unknown");
                    break;
            }

            dnaSequence.append(nucleotide);
        }

        System.out.println("Final DNA sequence: " + dnaSequence.toString());
        scanner.close();
    }
}
