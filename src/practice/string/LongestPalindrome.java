package practice.string;

public class LongestPalindrome {
    //Longest substring
    public static String expand(String s, int i, int j){
        int len = s.length();
        while (i>=0 && j<len && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindrome(String s) {
        int currLen, maxLength = 0;
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            String sub = expand(s, i, i);
            currLen = sub.length();

            if (currLen > maxLength){
                maxLength = currLen;
                maxStr = sub;
            }

            sub = expand(s, i, i + 1);
            currLen = sub.length();
            if (currLen > maxLength) {
                maxLength = currLen;
                maxStr = sub;
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {

    }
}
