// class Solution {
//     public static int fn(int ind){
//         if(ind==0) return 1;
//         if(ind==1) return 1;
//         int left=fn(ind-1);
//         int right=fn(ind-2);
//         return left+right;
//     }
//     public int climbStairs(int n) {
//         return fn(n);
//     }
// }
// ----------------------------------
class Solution {
    public static int fn(int ind,int[] dp){
        if(ind==0) return 1;
        if(ind==1) return 1;
//check if subproblems exists
        if(dp[ind]!=-1) return dp[ind];

        int left=fn(ind-1,dp);
        int right=fn(ind-2,dp);
//store the subproblems
        return dp[ind]=left+right;
    }
    public int climbStairs(int n) {
        //declare dp array
        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);

        return fn(n,dp);
    }
}
