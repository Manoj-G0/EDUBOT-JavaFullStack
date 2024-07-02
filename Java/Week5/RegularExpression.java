import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        String text = "the teacher wore a yellow turtleneck";
        String pattern1 = "nec";
        String pattern2 = "NEC";
        Pattern p = Pattern.compile(pattern1);
        Matcher m = p.matcher(text);
        if (m.find()) {
            System.out.println("Pattern '" + pattern1 + "' found at position: " + m.start() + "-" + m.end());
        } else {
            System.out.println("Pattern '" + pattern1 + "' not found.");
        }

        m = Pattern.compile(pattern2).matcher(text);
        if (m.find()) {
            System.out.println("Pattern '" + pattern2 + "' found at position: " + m.start() + "-" + m.end());
        } else {
            System.out.println("Pattern '" + pattern2 + "' not found.");
        }
    }
}
