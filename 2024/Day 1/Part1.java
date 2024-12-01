import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();
            
            while (scanner.hasNextLine()) {
                String[] input = scanner.nextLine().split("   ");
                firstList.add(Integer.valueOf(input[0]));
                secondList.add(Integer.valueOf(input[1]));
            }

            firstList.sort(Integer::compare);
            secondList.sort(Integer::compare);

            int res = 0;
            for (int i = 0; i < firstList.size(); i++) {
                res += Math.abs(firstList.get(i) - secondList.get(i));
            }
            System.out.println(res);
        }
    }
}