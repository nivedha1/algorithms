package Arrays.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalOverlap {


    int start;
    int end;

    IntervalOverlap(int s, int e) {
        this.start = s;
        this.end = e;
    }


    public static void main(String args[]) {
        ArrayList<IntervalOverlap> list = new ArrayList<IntervalOverlap>();
        list.add(new IntervalOverlap(6, 8));
        list.add(new IntervalOverlap(1, 3));
        list.add(new IntervalOverlap(2, 4));
        list.add(new IntervalOverlap(4, 7));
        Collections.sort(list, new Comparator<IntervalOverlap>() {
            @Override
            public int compare(IntervalOverlap o1, IntervalOverlap o2) {
                if (o1.start > o2.start) return 1;
                else if (o1.start < o2.start) return -1;
                else return 0;
            }
        });
        for (int i = 1; i < list.size(); i++)
            if (list.get(i - 1).end > list.get(i).start) {
                System.out.println("YES");
                break;
            }

    }
}
