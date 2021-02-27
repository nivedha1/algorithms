package Arrays;

public class NonContingousSubArraySum {
public static void main(String args[]) {
    int[] arr = {5, 5, 10,40, 50, 35};
int incl=arr[0];
int excl=0;
int excl_new=0;
    for (int i = 1; i < arr.length; i++) {
excl_new=Math.max(incl,excl);
incl=excl+arr[i];
excl=excl_new;
    }
    System.out.println(Math.max(incl,excl));
}
}
