class Solution {
    public static int fn(int ind,int target,int[] arr){
         if(ind==0){
             if(arr[0]==0 && target==0){
                 return 2;
             }
             if(target==0){
                 return 1;
             }
             if(arr[0]==target){
                 return 1;
             }
             return 0;
         }
         
         int pick=0;
         if(arr[ind]<=target){
             pick=fn(ind-1,target-arr[ind],arr);
         }
         int notpick=fn(ind-1,target,arr);
         
         return pick+notpick;
        
    }
    public int countPartitions(int[] arr, int diff) {
        // code 
        int n=arr.length;
        int sum=0;
        
        for(int ele:arr){
            sum=sum+ele;
        }
        // no negative || no fractio
        
        if(sum-diff<0 || (sum-diff)%2 !=0) return 0;
        int s2= (sum-diff)/2;
        
        int target=s2;
        
        return fn(n-1,target,arr);
        
    }
}.
