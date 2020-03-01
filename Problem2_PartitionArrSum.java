//Time Complexity: O(n*k)

class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        //edge case
        if( A == null ||  A.length == 0)
            return 0;
        
        int[] dp = new int[A.length];        
        //for all the elements; check dp
        for(int i=0; i< A.length; i++){
            //to compare max everytime we slide
            int current_max_sum = 0;
            //i-j+1>=0 to check bounds, for 1st element no element before that
            //slide the partition and compare max
            for(int j=1; j<=K && i-j+1>=0; j++){
                current_max_sum = Math.max(current_max_sum, A[i-j+1]);
                if(i-j >= 0){
                    dp[i] = Math.max(dp[i], current_max_sum * j + dp[i-j]); 
                } else{
                    //if less than 0, no element to compare with
                    dp[i] = Math.max(dp[i], current_max_sum * j );
                }
            }
        }
        return dp[A.length-1];
    }
}