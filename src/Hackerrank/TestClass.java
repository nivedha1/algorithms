package Hackerrank;

import java.util.*;

import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();                 // Reading input from STDIN
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
            if (max < arr[i]) max = arr[i];
        }

        int[] greater = new int[n];
        int[] smaller = new int[max + 1];

        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> index = new Stack<Integer>();
        int element = 0;
        int stkidx = 0;

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (!stack.isEmpty()) {
                element = stack.pop();
                stkidx = index.pop();
                while (element < num) {
                    greater[stkidx] = num;
                    if (stack.isEmpty())
                        break;
                    element = stack.pop();
                    stkidx = index.pop();
                }
                if (element >= num) {
                    stack.push(element);
                    index.push(stkidx);
                }
            }
            stack.push(num);
            index.push(i);

        }

        for (int i = 0; i < n; i++) {
            int num = arr[i];

            if (!stack.isEmpty()) {
                element = stack.pop();
                stkidx = index.pop();
                while (element > num) {
                    smaller[stkidx] = num;
                    if (stack.isEmpty())
                        break;
                    element = stack.pop();
                    stkidx = index.pop();
                }
                if (element <= num) {
                    stack.push(element);
                    index.push(stkidx);
                }
            }
            stack.push(num);
            index.push(num);

        }
        for (int i = 0; i < n; i++) {

            if (greater[i] == 0)
                System.out.println(-1);
            else {
                System.out.println(smaller[greater[i] - 1]);

            }

        }

    }
}
