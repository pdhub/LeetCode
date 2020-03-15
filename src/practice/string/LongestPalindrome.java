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

    public String longestPalindromeDP(String s) {
        String ans = "";
        if(s.length() == 0) return ans;
        int n = s.length(), start = 0, end = 0, maxLen = 0;
        boolean[][] DP = new boolean[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                DP[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || DP[i+1][j-1]);
                if(DP[i][j] && (j - i > end - start)) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end+1);
    }
}
