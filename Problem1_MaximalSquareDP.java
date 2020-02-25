//Time Complexity: O(m*n)

class Solution {
    public int maximalSquare(char[][] matrix) {
        //row & column length
        int rows = matrix.length;
        int cols = matrix[0].length;
        //edge case
        if(rows == 0)
            return 0;

        //2D array of dp of length and breadth equal to row and column       
        int [][] dp = new int[rows+1][cols+1];
        int sqLength = 0;
        //in the given matrix
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=cols; j++){
                //if and only if the matrix has 1
                //compare the min of the neighboring 3 nodes; add 1 to it
                //get maxSqLength and store to compare the max square length
                if(matrix[i-1][j-1]== '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    sqLength = Math.max(sqLength,dp[i][j]);
                }
            }
        }
        //since need area of the sqaure; square the maxNum
        return sqLength*sqLength;
    }
}