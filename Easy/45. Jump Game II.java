//BRUTE FORCE
class Solution {
    public int jump(int[] nums) {
         int n=nums.length;
         int ind=0;
         int jumps=0;

         return helper(ind,jumps,nums,n);
    }
    public static int helper(int ind,int jumps,int[] nums,int n){
         if(ind >=n-1){
            return jumps;
         }
         
         int mini=Integer.MAX_VALUE;
         for(int i=ind+1;i<=ind+nums[ind];i++){
             mini=Math.min(mini,helper(i,jumps+1,nums,n));
         }
         return mini;
    }
}
//----------------------------------
//OPTIMAL
class Solution {
    public int jump(int[] nums) {
    int n=nums.length;
    int farthest=0;
    int jumps=0;
    int l=0;
    int r=0;
    while(r<n-1){
       for(int i=l;i<=r;i++){
          farthest=Math.max(nums[i]+i,farthest);
       }
       l=r+1;
       r=farthest;
       jumps++;
    }

    return jumps;
    }
}
