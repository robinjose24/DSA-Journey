class Solution {
    public static int fn(int ind1, int ind2,String s1,String s2){
        if(ind1<0 || ind2<0){
            return 0;
        }
        //match
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return 1+ fn(ind1-1,ind2-1,s1,s2);
        }
        return Math.max( fn(ind1-1,ind2,s1,s2) ,fn(ind1,ind2-1,s1,s2) );
        //notmatch
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();

        return fn(n1-1,n2-1,text1,text2);
    }
}
//-------------------------------------------------------
class Solution {
    public static int fn(int ind1, int ind2,String s1,String s2,int[][] dp){
        if(ind1<0 || ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        //match
        if(s1.charAt(ind1)==s2.charAt(ind2)){
            return 1+ fn(ind1-1,ind2-1,s1,s2,dp);
        }
        dp[ind1][ind2]=Math.max( fn(ind1-1,ind2,s1,s2,dp) ,fn(ind1,ind2-1,s1,s2,dp) );

        return Math.max( fn(ind1-1,ind2,s1,s2,dp) ,fn(ind1,ind2-1,s1,s2,dp) );
        //notmatch
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();

        int[][] dp=new int[n1][n2];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return fn(n1-1,n2-1,text1,text2,dp);
    }
}
