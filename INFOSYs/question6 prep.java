Problem Statement :

You are given an array of size N. You need to change this array into a mountain. By mountain we mean, the either ends of the array should have equal elements. Then as we move towards the middle from both ends, the next element is just one more than the previous one. So, it would have a peak in the middle and decrease if you go towards either end, just like a mountain.

Examples of mountains are [1, 2, 3, 2, 1] or [6, 7, 8, 8, 7, 6]. But the array [1, 2, 4, 2, 1] is not a mountain because from 2 to 4 the difference is 2. The array [1, 2, 3, 1] is also not a mountain because the elements 2 and 3 are not equal from both ends.

You need to find the minimum number of elements that should be changed to make the array a mountain. You can make the elements negative or zero as well.

Input Format
N :: INTEGER
The first line contains an integer, N, denoting the number of elements in array. N :: 1 -> 10^5

array :: INTEGER ARRAY
Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing i-th element of array. array[i] :: 1 -> 10^6

Sample Input 1:
5
1
2
3
4
5

Sample Output 1 :
2

Sample input 2:
9
1
1
1
2
3
2
1
1
1

Sample Output 2:
4
===============================================================================
import java.util.Scanner;
class Main{
public static int mountain(int[] arr, int n){
    int count=0;
  //start of if
    if(n%2==0){
        int m2 = n/2;
        int m1 = m2-1;
        
        if(arr[m1] == arr[m2]){
            for(int i =m1-1; i>=0; i--){
                if(arr[i] != (arr[i+1] -1)){
                    count++;
                    arr[i] = (arr[i+1]-1);
                }
            }
        }
        else if(arr[m1] != arr[m2]){
            arr[m2] = arr[m1];
              for(int i =m1-1; i>=0; i--){
                if(arr[i] != (arr[i+1] -1)){
                    count++;
                    arr[i] = (arr[i+1]-1);
                }
            }   
        }
      
        int j = m1-1;
        for(int i =m2+1; i<n; i++){ 
          if(arr[i] != arr[j]){ 
            count ++;
          } j--;
        }
      return count;
      } 
    //start of else  
    else{
      int mid = n/2;
      for(int i = mid-1; i>=0; i--){
            if(arr[i] != (arr[i+1]-1)){
                    count++;
                    arr[i] = (arr[i+1]-1);
                }
        }
        int j = mid-1;
        for(int i = mid+1;i < n; i++){
            if(arr[i] !=arr[j]){
                count++;
            }
            j--;
        }
        return count;
    }
    
}

public static void main(String[] args) {
Scanner s = new Scanner(System.in);
  int n = s.nextInt();
    int arr[] = new int[n];
    for(int i =0; i < n; i++){
       arr[i]= s.nextInt();
    }
  System.out.println(mountain(arr,n));
}
}
