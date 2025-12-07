Problem Statement :

Today you decided to go to the gym. You currently have energy equal to E units. There are N exercises in the gym. Each of these exercises drains Ai amount of energy from your body.

You feel tired if your energy reaches 0 or below. Calculate the minimum number of exercises you have to perform such that you become tired. Every unique exercise can only be performed at most 2 times as others also have to use the machines.

If performing all the exercises does not make you feel tired, return -1.

Input Format
E :: INTEGER
The first line contains an integer, E, denoting the Energy.
E :: 1 -> 10^5

N :: INTEGER
The next line contains an integer, N, denoting the number of exercises. N :: 1 -> 10^5

A :: INTEGER ARRAY
Each line i of the N subsequent lines (where 0 ≤ i < N) contains an integer describing the amount of energy drained by i-th exercise.
A[i] :: 1 -> 10^5

Sample Input 1:
6
2
1
2

Sample Output 1 :
4

Sample input 2:
10
2
1
2

Sample Output 2:
-1

Sample input 3:
2
3
1
5
2

Sample Output 3:
1
======================================================================================
import java.util.Scanner;
public class Main {
public static int solution(int nExcercise,int[] arr,int energy){
    int sum = 0;
    for(int i = 0; i< nExcercise; i++) {
	        	if(arr[i]==energy)
	        		return 1;
	        }
    for(int i =0; i<nExcercise; i++){ 
      sum = sum + arr[i]; 
      if(arr[i]== energy){ 
        return 1; 
      } 
      if(sum >= energy){
            return i+1;
        }
        if(2*sum >= energy){
            return 2*(i+1);
        }
    }
    //if sum is not equal to the energy.
return -1;
}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int energy = s.nextInt();
		int nExcercise = s.nextInt();
		int[] arr= new int[nExcercise];
	    for (int i = 0; i < nExcercise; i++) 
	    {
	            arr[i] = s.nextInt();
	    }

	  int ans = solution(nExcercise,arr,energy);
	  System.out.println(ans);
	}
}
