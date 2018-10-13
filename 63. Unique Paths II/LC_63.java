public class LC_63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        // initialize with zeros
        int[][] pathObstacles = new int[height][width];

        for (int i = 0; i < height; i++) {
            if (obstacleGrid[i][0] != 1) {
                pathObstacles[i][0] = 1;
            } else {
                // the initialization sets zeros to the pathObstacles[][], and suppose the third row (i = 2) has an obstacle,
                // the loop will break at i = 2 and the rest row indexes (i > 2) will remain zeros
                break;
            }
        }
        for (int j = 0; j < width; j++) {
            if (obstacleGrid[0][j] != 1) {
                pathObstacles[0][j] = 1;
            } else {
                // the initialization sets zeros to the pathObstacles[][], and suppose the third column (j = 3) has an obstacle,
                // the loop will break at j = 3 and the rest column indexes (j > 3) will remain zeros
                break;
            }
        }
        for (int i = 1; i < height; i++){
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] != 1) {
                    pathObstacles[i][j] = pathObstacles[i - 1][j] + pathObstacles[i][j - 1];
                }
            }
        }
        return pathObstacles[height - 1][width - 1];
    }
