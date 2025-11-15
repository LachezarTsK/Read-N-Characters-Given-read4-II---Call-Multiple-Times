
public class Solution {

    public int[][] rangeAddQueries(int sideMatrix, int[][] queries) {
        int[][] answerRangeAddQueries = new int[sideMatrix][sideMatrix];

        for (int[] query : queries) {
            int startRow = query[0];
            int startColumn = query[1];
            int endRow = query[2];
            int endColumn = query[3];

            for (int row = startRow; row <= endRow; ++row) {
                ++answerRangeAddQueries[row][startColumn];
                if (endColumn + 1 < sideMatrix) {
                    --answerRangeAddQueries[row][endColumn + 1];
                }
            }
        }

        for (int row = 0; row < sideMatrix; ++row) {
            for (int column = 1; column < sideMatrix; ++column) {
                answerRangeAddQueries[row][column] += answerRangeAddQueries[row][column - 1];
            }
        }

        return answerRangeAddQueries;
    }
}
