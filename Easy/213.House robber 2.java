class Solution {
    public int fn(int ind,int[] arr,int[] dp){ 
        if(ind==0) return arr[0];
        if(ind<0) return 0;

        if(dp[ind]!=-1) return dp[ind];
        int pick= arr[ind]+fn(ind-2,arr,dp);
        int notpick=0+fn(ind-1,arr,dp);

        dp[ind]=Math.max(pick,notpick);
        return Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        int[] arr1 = new int[n-1];
        int[] dp1=new int[n-1];
        Arrays.fill(dp1,-1);
        for(int i = 0; i < n-1; i++){
            arr1[i] = nums[i];
        }
        int case1 = fn(n-2, arr1,dp1);

        // Case 2: exclude first, include last → nums[1..n-1]
        int[] dp2=new int[n-1];
        Arrays.fill(dp2,-1);
        int[] arr2 = new int[n-1];
        for(int i = 1; i < n; i++){
            arr2[i-1] = nums[i];
        }
        int case2 = fn(n-2, arr2,dp2);

        return Math.max(case1, case2);
    }
}
