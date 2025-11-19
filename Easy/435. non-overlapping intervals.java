class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int freeTime=Integer.MIN_VALUE;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));

        int n=intervals.length;
        int cnt=0;
        for(int i=0;i<n;i++){
           if(intervals[i][0]>=freeTime){
              cnt++;
              freeTime=intervals[i][1];
           }
        }
        return n-cnt;
    }
}
