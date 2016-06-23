import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution.*/
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        for (int i = 0; i < cases; i++) {
            int contestants = scanner.nextInt();

            if (contestants <= 1) {
                System.out.println(contestants);
                continue;
            }

            int [] skillList = new int[contestants];

            for (int j = 0; j < contestants; j++) {
                skillList[j] = scanner.nextInt();
            }

            Arrays.sort(skillList);
            Map<Integer, Integer> skillLevelFrequency = new LinkedHashMap<Integer, Integer>();
            int skillLevel = skillList[0];
            int frequency = 1;

            for (int j = 1; j < contestants; j++) {
                if (skillLevel == skillList[j]) {
                    frequency++;
                }
                else {
                    skillLevelFrequency.put(skillLevel, frequency);
                    skillLevel = skillList[j];
                    frequency = 1;
                }
            }

            List<Integer> team = new ArrayList<Integer>();
            int minGroupSize = Integer.MAX_VALUE;
        }
    }
}