✅ Problem Explained in Simple Words

You have N segments of land with heights:

L1, L2, L3, …, LN


You want the land to become strictly decreasing:

L1 > L2 > L3 > … > LN


This is required to build a downward sloping road.

❗What Can You Do?

You cannot increase heights —
You can only DIG (reduce) a segment’s height.

And on day D, digging is very powerful:

💥 Digging power on day D = 2ᴰ − 1 (meters)

Examples:

Day 1: reduce by 1 meter

Day 2: reduce by 3 meters

Day 3: reduce by 7 meters

Day 4: reduce by 15 meters

…

And you can apply the day’s power to any number of segments.

🎯 Goal

Find the minimum number of days required so that after digging:

L1 > L2 > L3 > … > LN

⭐ Let’s Fully Understand With My Own Example
🔹 Example
N = 4
L = [10, 8, 8, 5]


We need:

10 > 8 > 8 > 5


But currently:

L2 = 8

L3 = 8 → violates (because we need L2 > L3)

So we must reduce L3.

Step 1 — Fix L3

L2 = 8
L3 must become ≤ 7

Current L3 = 8
Required: reduce by 8 − 7 = 1

Step 2 — Check L4

We need L3 > L4
After fixing, L3 = 7
L4 = 5 → already okay
No digging needed.

🔹 Total digging required = 1 meter

Minimum days?
On day 1, you can dig 1 meter.

So:

Answer = 1 day

⭐ A Bigger Example (More Clear)
Example
N = 5
L = [6, 6, 6, 6, 6]


We want:

6 > 5 > 4 > 3 > 2


Because every next must be strictly smaller.

Required heights:
L1 = 6
L2 = 5
L3 = 4
L4 = 3
L5 = 2


Now calculate digging needed:

Segment	Current	Needed	Reduction
L1	6	6	0
L2	6	5	1
L3	6	4	2
L4	6	3	3
L5	6	2	4

Total digging needed:

1 + 2 + 3 + 4 = 10 meters


Now: How many days to accumulate at least 10?

Daily powers:

Day 1 → 1

Day 2 → 3

Day 3 → 7

Day 4 → 15

Sum after days:

After day 1: 1

After day 2: 4

After day 3: 11 → enough!

So 3 days are needed.

Answer = 3

⭐ Summary of the Problem

Make the array strictly decreasing.

Compute how much each element must be reduced.

Sum all required reductions → totalReduction.

Each day gives digging power = 2ᴰ − 1.

Total power after d days = 2ᵈ − 1.

Find smallest d such that:

2ᵈ − 1 ≥ totalReduction
================================================================
  import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        long[] L = new long[n];
        for (int i = 0; i < n; i++) {
            L[i] = s.nextLong();
        }

        long totalReduction = 0;

        for (int i = 1; i < n; i++) {
            if (L[i] >= L[i - 1]) {
                long newValue = L[i - 1] - 1;
                long reduction = L[i] - newValue;
                totalReduction += reduction;
                L[i] = newValue;
            }
        }

        // If no reduction needed
        if (totalReduction <= 0) {
            System.out.println(0);
            return;
        }

        // Minimum days needed: 2^D - 1 >= totalReduction
        // => D >= log2(totalReduction + 1)
        int days = (int) Math.ceil(Math.log(totalReduction + 1) / Math.log(2));

        System.out.println(days);
    }
}
