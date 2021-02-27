package Arrays.sorting;

public class MergeSort {
    int[] arr = { 7,1,3,5,2,9,8,15,3};


    public static void main(String args[]){
        MergeSort obj = new MergeSort();
        obj.sort();

    }

    public  void sort() {
        merge(0,arr.length-1);
        for(int i:arr){
            System.out.println(i);
        }
    }

    private void merge(int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;
            merge(left, mid );
            merge(mid+1, right);
            mergeSort(left, mid, right);
        }

    }

    public void mergeSort(int l,int m,int r)
    {
      int n1=m-l+1;//m-l+1 not m-l if m=3 and l=0 there are total 4 elements
      int n2=r-m;
      int[] L=new int[n1];
      int[] R=new int[n2];
      for(int i=0;i<n1;i++)
          L[i]=arr[l+i];
      for(int i=0;i<n2;i++)
          R[i]=arr[m+i+1];//mid+1 not mid since right starts from mid+1

      int i=0,j=0,k=l;//k = l not 0
      while(i<n1&&j<n2)
      {
          if(L[i]<=R[j]){
              arr[k]=L[i];
              k++;
              i++;
          }
          else {
            arr[k]=R[j];
            k++;
            j++;
          }
      }
      while(i<n1){
          arr[k]=L[i];
          k++;
          i++;
      }
      while(j<n2){
          arr[k]=R[j];
          k++;
          j++;
      }


    }
}

