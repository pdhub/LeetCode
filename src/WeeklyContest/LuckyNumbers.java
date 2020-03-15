package WeeklyContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rowmin = new int[matrix.length];
        Arrays.fill(rowmin, Integer.MAX_VALUE);

        int[] colMax = new int[matrix[0].length];
        Arrays.fill(colMax, Integer.MIN_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int element = matrix[i][j];
                if (element < rowmin[i])
                    rowmin[i] = element;
                if (element > colMax[j])
                    colMax[j] = element;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int element = matrix[i][j];
                if (element <= rowmin[i] && element >= colMax[j])
                    result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{3,7,8},{9,11,13},{15,16,17}};


        //System.out.println(new LuckyNumbers().luckyNumbers(input));

        int[][] input2 = new int[][]{{1,10,4,2},{9,3,8,7},{15,16,17,12}};
        System.out.println(new LuckyNumbers().luckyNumbers(input2));
    }
}
