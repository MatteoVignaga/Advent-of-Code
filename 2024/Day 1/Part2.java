import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> firstList = new ArrayList<>();
            List<Integer> secondList = new ArrayList<>();
            
            while (scanner.hasNextLine()) {
                String[] input = scanner.nextLine().split("\\s+");
                firstList.add(Integer.valueOf(input[0]));
                secondList.add(Integer.valueOf(input[1]));
            }
    
            Map<Integer, Integer> similarityScores = new HashMap<>();
            int score = 0;
            for (Integer n : firstList) {
                if (similarityScores.containsKey(n)) {
                    score += n*similarityScores.get(n);
                } else {
                    int similarityScore = 0;
                    for (Integer m : secondList) {
                        if (m.equals(n)) similarityScore++;
                    }
                    similarityScores.put(n, similarityScore);
                    score += n*similarityScore;
                }
                
            }
    
            System.out.println(score);
        }
    }
}
