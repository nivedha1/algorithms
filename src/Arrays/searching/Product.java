package Arrays.searching;
import java.util.Arrays;
public class Product {

    public static void main(String args[]){
        int[] arr={ -1, -1, -8,-4, 4, 3 };
        Arrays.sort(arr);
        findMinimumProduct(arr);
        findMaximumProductPair(arr,arr.length);
        findMaximumProductSubArray();
    }

    private static void findMaximumProductSubArray() {
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 };
        int max_product_so_far=1;int max=Integer.MIN_VALUE;
        int min_product_so_far=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>0){
                max_product_so_far=max_product_so_far*arr[i];
                min_product_so_far=Math.min(min_product_so_far*arr[i],1);
            }
            if(arr[i]==0){
                max_product_so_far=1;
                min_product_so_far=1;
            }
            if(arr[i]<0){
               int temp= max_product_so_far;
               max_product_so_far=Math.max(min_product_so_far*arr[i],1);
               min_product_so_far=temp*arr[i];
            }
if(max_product_so_far>max){
    max=max_product_so_far;
}
        }
        System.out.println(max);

    }

    private static void findMaximumProductPair(int[] arr,int n) {
        if (n < 2) {
            System.out.println("No pairs exists");
            return;
        }

        if (n == 2) {
            System.out.println(arr[0] + " " + arr[1]);
            return;
        }
        int posa = Integer.MIN_VALUE,
                posb = Integer.MIN_VALUE;
        int nega = Integer.MIN_VALUE,
                negb = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > posa) {
                posb = posa;
                posa = arr[i];
            } else if (arr[i] > posb)
                posb = arr[i];
            if (arr[i] < 0 && Math.abs(arr[i]) >
                    Math.abs(nega)) {
                negb = nega;
                nega = arr[i];
            } else if (arr[i] < 0 && Math.abs(arr[i])
                    > Math.abs(negb))
                negb = arr[i];
        }

        if (nega * negb > posa * posb)
            System.out.println("Max product pair is {"
                    + nega + ", " + negb + "}");
        else
            System.out.println("Max product pair is {"
                    + posa + ", " + posb + "}");
    }


    private static void findMinimumProduct(int[] arr) {
        int count_zero=0;
        int negMax=Integer.MAX_VALUE;
        int posmin=Integer.MAX_VALUE;
        int product=1;
        int countNeg=0;
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            if(num==0){
                count_zero++;
            }
            else if(num<0){
                negMax=Math.min(negMax,num);
                product=product*arr[i];
                countNeg++;
            }
            else{
                posmin=Math.min(posmin,num);
            }
        }
        if(count_zero==arr.length||(countNeg==0&&count_zero>0))
            System.out.println(0);
        else if(countNeg==0)
            System.out.println(posmin);//minimum postive integer will be the product
        else if(countNeg%2==0)
            System.out.println(product/negMax);//divide the total negative product by the least neg number
        else
            System.out.println(product);

    }

}
