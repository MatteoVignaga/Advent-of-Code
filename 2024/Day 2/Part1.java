import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<int[]> reports = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String report = scanner.nextLine();
                String[] stringLevels = report.split(" ");
                int[] levels = Arrays.stream(stringLevels).mapToInt(Integer::valueOf).toArray();
                reports.add(levels);
            }

            int count = 0;
            for (int[] levels : reports) {
                boolean safe = true;
                boolean increasing = false;
                boolean decreasing = false;
                
                for (int i = 0; i < levels.length-1; i++) {
                    if (levels[i] == levels[i+1] || Math.abs(levels[i]-levels[i+1]) > 3) {
                        safe = false;
                    } 

                    if (levels[i] < levels[i+1]) {
                        increasing = true;
                    } else {
                        decreasing = true;
                    }
                }
                if (safe && !(increasing && decreasing)) count++;
            }

            System.out.println(count);
        }
    }
}
