package Stack;

import java.util.Stack;

public class CelebrityProblem {

    static int MATRIX[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    static boolean know(int a, int b) {
        return (MATRIX[a][b] == 1 ? true : false);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < MATRIX.length; i++) {
            stack.push(i);
        }
        while (stack.size() != 1) {
            int a = stack.pop();
            int b = stack.pop();

            // Step 3 : Push the
            // remained person onto stack.
            if (know(a, b)) {
                stack.push(b);
            } else
                stack.push(a);

        }
        int C = stack.pop();
        int i = 0;
        for (i = 0; i < MATRIX.length; i++) {
            if (i < MATRIX.length && !know(i, C) && know(C, i))
                break;
        }
        if (i == MATRIX.length) {
            System.out.println(C);
            System.out.println(true);
        }
    }
}
