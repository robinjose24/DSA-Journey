class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> list=new ArrayList<>();

        for(int num=0; num < (Math.pow(2,n)); num++){
            ArrayList<Integer> sublist=new ArrayList<>();
            for(int j=0;j<n;j++){
                if ( (num & (1<<j)) !=0 ){
                    sublist.add(nums[j]);
                }
            }
            list.add(sublist);
        }
        return list;

    }
}
