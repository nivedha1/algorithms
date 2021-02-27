package Hackerrank;

import java.util.*;

public class ArrayDelete {

    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int count = s.nextInt();
        int[] arr = new int[count];// Reading input from STDIN
        for (int i = 0; i < count; i++) {
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        boolean[] visited = new boolean[count];
        for (int j = 0; j < count; j++) {
            for (int k = j + 1; k < count; k++) {
                if (arr[j] < arr[k] && arr[j] != 0 && arr[k] != 0 && !visited[k]) {
                    arr[j] = 0;
                    visited[k] = true;
                    break;
                }
            }
        }
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        System.out.println(sum);


    }
}


