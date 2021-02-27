package Backtracking;

public class TugOfwar {

    public static void main(String args[]) {
        int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        int n = arr.length;
        boolean[] sol = new boolean[n];
        int sum = 0;
        boolean[] current_elements = new boolean[n];
        for (int i = 0; i < n; i++)
            sum = sum + arr[i];
        int currentidx = 0;
        int currsum = 0;
        int no_element_selected = 0;
        solve(arr, n, sol, current_elements, currentidx, sum, Integer.MAX_VALUE, no_element_selected);


        for (int i = 0; i < n; i++) {
            if (sol[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println("***********");
        for (int i = 0; i < n; i++) {
            if (sol[i] == false)
                System.out.print(arr[i] + " ");
        }

    }

    private static void solve(int[] arr, int n, boolean[] sol, boolean[] current_elements, int currentidx, int sum, int currsum, int no_element_selected) {

        if (currentidx == n)
            return;
        if (n / 2 - no_element_selected == n - currentidx)//if currentindex-n tells remaining elements that can be selected
            //if the gap is equal then return if it becomes less that n/2-no_elements_selected
            // it cant add anymore to no_element_selected such that n/2==no_element_selected
            return;

        solve(arr, n, sol, current_elements, currentidx + 1, sum, currsum, no_element_selected);

        no_element_selected++;
        sum = sum + arr[currentidx];
        current_elements[currentidx] = true;

        if (no_element_selected == n / 2) {
            if (Math.abs(sum / 2 - currsum) < currsum) {
                currsum = Math.abs(sum / 2 - currsum);
                for (int i = 0; i < n; i++)
                    sol[i] = current_elements[i];
            }
        } else {
            solve(arr, n, sol, current_elements, currentidx + 1, sum, currsum, no_element_selected);

        }

        current_elements[currentidx] = false;

    }


}
