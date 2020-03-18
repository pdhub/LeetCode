package practice;

import java.util.*;

public class LetterCombinationsPhoneNumber {


    static Map<Integer, String> digitToCharaters = new HashMap<Integer, String>();

    {
        digitToCharaters.put(1, "");
        digitToCharaters.put(2, "abc");
        digitToCharaters.put(3, "def");
        digitToCharaters.put(4, "ghi");
        digitToCharaters.put(5, "jkl");
        digitToCharaters.put(6, "mno");
        digitToCharaters.put(7, "pqrs");
        digitToCharaters.put(8, "tuv");
        digitToCharaters.put(9, "wxyz");
    }

    public List<String> letterCombinations(String inputStr) {
        if (inputStr.length() == 0){
            return Arrays.asList("");
        }

        char ch = inputStr.charAt(0);
        String restOfString = inputStr.substring(1);

        List<String> prev = letterCombinations(restOfString);
        List<String> res = new ArrayList<String>();
        String digit = digitToCharaters.get((Integer.parseInt(ch+"")));
        for (String l : prev){
            for (int i = 0; i < digit.length(); i++) {
                res.add(digit.charAt(i) + l);
            }
        }
        return res;
    }
}
