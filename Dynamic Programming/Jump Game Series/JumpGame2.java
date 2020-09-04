//Problem number 45

//Given an array of non-negative integers, you are initially positioned at the first index of the array.

//Each element in the array represents your maximum jump length at that position.

//Your goal is to reach the last index in the minimum number of jumps.

//O(N^2) solution (TLE)
class Solution {
    int[]dp;
    public int jump(int[] nums) {
        dp=new int[nums.length];
        for(int i=1;i<nums.length;i++)dp[i]=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++)
            for(int j=0;j<i;j++)
                if(j+nums[j]>=i)
                {
                    if(dp[j]!=Integer.MAX_VALUE)
                    {
                        dp[i]=1+dp[j];
                        break;
                    }
                }
        return dp[nums.length-1];
    }
}
//greedy O(N) solution
class Solution {
    public int jump(int[] nums) {
        int currEnd = 0, currFarthest = 0;
        int jumps = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > currFarthest)return -1;
            
            currFarthest = Math.max(currFarthest, nums[i] + i);
            
            if(i == currEnd && i != nums.length-1){
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;
    }
}
