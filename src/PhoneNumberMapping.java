import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMapping {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<String>();

        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        _letterCombinations(digits, "", results, map);

        return results;
    }

    private void _letterCombinations(String digits, String progress, List<String> results, Map<Character, String> map) {
        if (digits.isEmpty()) {
            results.add(progress);
            return;
        }

        String letters = map.get(digits.charAt(0));

        for (int i = 0; i < letters.length(); i++) {
            _letterCombinations(digits.substring(1), progress + letters.charAt(i), results, map);
        }
    }
}