import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine());
            }
            String input = sb.toString();
            Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
            Matcher matcher = pattern.matcher(input);
            
            List<String> multiplications = new ArrayList<>();
            while (matcher.find()) {
                multiplications.add(matcher.group());
            }

            int res = 0;
            for (String multiplication : multiplications) {
                String[] elements = multiplication.split("[\\(,\\)]");
                int a = Integer.parseInt(elements[1]);
                int b = Integer.parseInt(elements[2]);
                res += a*b;
            }

            System.out.println(res);
        }
    }
}