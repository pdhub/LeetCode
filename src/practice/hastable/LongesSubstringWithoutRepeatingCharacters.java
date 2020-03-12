package practice.hastable;

import java.util.HashSet;
import java.util.Set;

public class LongesSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            String sub = "";
            for (int j = start; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))){
                    sub+= s.charAt(j);
                    set.add(s.charAt(j));
                }else {
                    set.clear();
                    break;
                }
            }
            if (max < sub.length())
                max = sub.length();
        }
        return max;
    }

    public static void main(String[] args) {
        LongesSubstringWithoutRepeatingCharacters l = new LongesSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
        System.out.println(l.lengthOfLongestSubstring(" "));
    }
}
