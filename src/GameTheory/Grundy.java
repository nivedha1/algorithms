package GameTheory;

import java.util.HashSet;

public class Grundy {

    int calculateMex(HashSet<Integer> set)
    {
        int mex = 0;

        while (set.contains(mex))
            mex++;
        System.out.println(mex);

        return (mex);
    }

    // A function to Compute Grundy Number of 'n'
// Only this function varies according to the game
    int calculateGrundy(int n)
    {
        if (n == 0)
            return (0);

        HashSet<Integer> set=new HashSet<Integer>(); // A Hash Table

        for (int i=0; i<=n-1; i++)
            set.add(calculateGrundy(i));


        return (calculateMex(set));
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        Grundy g = new Grundy();

        System.out.println(g.calculateGrundy(10));

    }
}
