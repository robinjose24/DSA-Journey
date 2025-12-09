Problem Statement: While playing an RPG game, you were assigned to complete one of the hardest quests in this game. There are n monsters you’ll need to defeat in this quest.

Each monster i is described with two integer numbers – poweri and bonusi. To defeat this monster, you’ll need at least poweri experience points. If you try fighting this monster without having enough experience points, you lose immediately. You will also gain bonusi experience points if you defeat this monster. You can defeat monsters in any order.
The quest turned out to be very hard – you try to defeat the monsters but keep losing repeatedly. Your friend told you that this quest is impossible to complete.
Knowing that, you’re interested, what is the maximum possible number of monsters you can defeat?

(Question difficulty level: Hardest)

Input:

The first line contains an integer, n, denoting the number of monsters. The next line contains an integer, e, denoting your initial experience.
Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer, poweri, which represents power of the corresponding monster.
Each line i of the n subsequent lines (where 0 ≤ i < n) contains an integer, bonusi, which represents bonus for defeating the corresponding monster.
Input	Output	Output Description
2
123
78
130
10
0	2	
Initial experience level is 123 points.
Defeat the first monster having power of 78 and bonus of 10. Experience level is now 123+10=133.
Defeat the second monster.
3
100
101
100
304
100
1
524	2	
Initial experience level is 100 points.
Defeat the second monster having power of 100 and bonus of 1. Experience level is now 100+1=101.
Defeat the first monster having power of 101 and bonus of 100. Experience level is now 101+100=201.
The third monster can’t be defeated.
  ==========================================================================================
  import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int exp = s.nextInt();

        int[] monst = new int[n];
        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) monst[i] = s.nextInt();
        for (int i = 0; i < n; i++) bonus[i] = s.nextInt();

        class Monster {
            int power, bonus;
            Monster(int power, int bonus) {
                this.power = power;
                this.bonus = bonus;
            }
        }

        Monster[] monsters = new Monster[n];
        for (int i = 0; i < n; i++) monsters[i] = new Monster(monst[i], bonus[i]);

        Arrays.sort(monsters, Comparator.comparingInt(m -> m.power));

        int count = 0;
        for (Monster m : monsters) {
            if (exp < m.power) break;
            exp += m.bonus;
            count++;
        }

        System.out.println(count);
    }
}
