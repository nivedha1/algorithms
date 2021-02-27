package Arrays.sorting;

public class Sorting {

    public static void main(String args[]) {
        Sorting obj = new Sorting();
        int[] arr = {1, 0, 2, 0, 1, 2, 2, 1, 0};
        obj.sort012(arr);
    }

    private void sort012(int[] arr) {

        int mid = 0;
        int low = 0;
        int high = arr.length - 1;
        while (mid <= high) {//this wont work for for loop
            int num = arr[mid];//no i arr[mid]
            if (num == 1) {
                mid++;
            } else if (num == 0) {
                swap(mid, low, arr);
                mid++;
                low++;
            } else if (num == 2) {
                swap(high, mid, arr);
                high--;//dont decrement mid
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private void swap(int mid, int low, int[] arr) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
    }
}
