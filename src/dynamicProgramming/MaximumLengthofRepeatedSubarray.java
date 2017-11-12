package dynamicProgramming;

/**
 * Created by PDeb on 11/12/2017.
 */
public class MaximumLengthofRepeatedSubarray {


    public static void main(String[] args) {
        int A[] = {1,2,3,2,1};
        int B[] = {3,2,1,4,7};
        System.out.println(new MaximumLengthofRepeatedSubarray().findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {
        int aLen = A.length;
        int bLen = B.length;
        int maxLen = findMaxLen(A, B, aLen+1, bLen+1);
        return maxLen;
    }

    private int findMaxLen(int[] a, int[] b, int aLen, int bLen) {
        int T[][] = new int[aLen][bLen];
        for (int i = 0; i < aLen; i++) {
            T[0][i] = 0;
        }

        for (int i = 0; i < bLen; i++) {
            T[i][0] = 0;
        }

        int maxLen = 0;
        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                if(a[i-1]==b[j-1]){
                    T[i][j] = T[i-1][j-1]+1;
                    if(maxLen < T[i][j])
                        maxLen = T[i][j];
                }
                else
                    T[i][j] = 0;
            }
        }
        return maxLen;
    }
}
