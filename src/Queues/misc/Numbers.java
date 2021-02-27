package Queues.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Numbers {

    public static void main(String args[]) {
        printAllBinaryNumbers(3);
        SmallestMultipleMadeof0and9(7);
    }

    private static void SmallestMultipleMadeof0and9(int num) {
        Queue<String> list = new LinkedList<>();
        ArrayList<String> output = new ArrayList<>();
        list.add("9");

        int MAX_COUNT = 100;
        while (MAX_COUNT > 0) {

            String a = list.poll();
            String b = a;
            output.add(a);
            a = a + "0";
            b = b + "9";
            list.add(a);
            list.add(b);
            MAX_COUNT = MAX_COUNT - 2;
        }
        for (int i = output.size() - 1; i > 0; i--) {
            if (Integer.parseInt(output.get(i)) % num == 0) {
                System.out.println(output.get(i));
                break;
            }
        }

    }

    private static void printAllBinaryNumbers(int num) {

        int count = num;
        Queue<String> list = new LinkedList<>();
        list.add("0");

        while (num > 0) {

            String a = list.peek();
            String b = a;
            a = a + "0";
            b = b + "1";
            list.add(a);
            list.add(b);
            num = num - 2;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(list.poll());
        }


    }


}
