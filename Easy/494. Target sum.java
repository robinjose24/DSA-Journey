class Solution {
    public static int fn(int ind,int target,int[] arr,int[][] dp){
        if(ind==0){
            if(arr[ind]==0 && target==0) return 2;
            if(target==0) return 1;
            if(target==arr[ind]) return 1;
            return 0;
        }

        if(dp[ind][target]!=-1) return dp[ind][target];

        int pick=0;
        if(arr[ind]<=target){
            pick= fn(ind-1,target-arr[ind],arr,dp);
        }
        int notpick=fn(ind-1,target,arr,dp);
        
        dp[ind][target]=pick+notpick;
        return pick+notpick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int ele:nums){
            sum=sum+ele;
        }
        int s2=(sum-target)/2;
        if((sum-target)<0 || (sum-target)%2!=0) 
            return 0;
        
        int[][] dp=new int[n][s2+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fn(n-1,s2,nums,dp);
    }
}
