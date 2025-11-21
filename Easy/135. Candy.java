class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        //left to right

        arr1[0]=1;
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                arr1[i]=arr1[i-1]+1;
            }
            else{
                arr1[i]=1;
            }
        }

        arr2[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                arr2[i]=arr2[i+1]+1;
            }
            else{
                arr2[i]=1;
            }
        }

        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+(Math.max(arr1[i],arr2[i]));
        }
        return sum;
        //----------------------------------------

        int n=ratings.length;
        int[] arr1=new int[n];
        //left to right

        arr1[0]=1;
        for(int i=1;i<n;i++){
            if(ratings[i-1]<ratings[i]){
                arr1[i]=arr1[i-1]+1;
            }
            else{
                arr1[i]=1;
            }
        }

        int sum=Math.max(arr1[n-1],1);
        int curr=1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                curr=curr+1;
                
            }
            else{
                curr=1;
            }
            sum=sum+(Math.max(arr1[i],curr));
        }

        return sum;
      
        //-------------------------------------
        int n=ratings.length;
        int sum=1;
        int i=1;
        while(i<n){
            while(i<n && ratings[i-1]==ratings[i]){
                sum=sum+1;
                i++;
            }
            int peak=1;
            while(i<n && ratings[i-1]<ratings[i]){
                peak=peak+1;
                sum=sum+peak;
                i++;                
            }
            int down=1;
            while(i<n && ratings[i-1]>ratings[i]){
                sum=sum+down;
                down++;
                i++;
            }
            if(down>peak){
                sum=sum+(down-peak);
            }
        }
        return sum;
    }
}
