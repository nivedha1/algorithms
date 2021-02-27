package Strings;

import java.util.ArrayList;

public class DeleteSameWordsInSequence {
    public static void main(String[] args)
    {
        ArrayList<String> v = new ArrayList<>();

        v.add("tom"); v.add("jerry");
        v.add("jerry");v.add("tom");

        System.out.println(removeConsecutiveSame(v));
    }

    private static int removeConsecutiveSame(ArrayList<String> v) {
        int n = v.size();
        for (int i = 0; i < n; ) {
            if (v.get(i) == v.get(i + 1)) {
                v.remove(i);
                v.remove(i);

            if (i > 0) {
                i = i-1;
            }
                n = n - 2;
        }

            else{
           i++;
        }


        }
        return v.size();

     }
    }

