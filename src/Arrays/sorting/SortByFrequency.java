package Arrays.sorting;

import java.util.*;

public class SortByFrequency {


    public static void main(String args[]){
        SortByFrequency obj = new SortByFrequency();
        int[] arr = {2,3,1,1,1,4,3,2,5,9,1,2,3};
        obj.sortByFrequency(arr);

    }

    private void sortByFrequency(int[] arr) {

        Map<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> output=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]))
            {
                map.put(arr[i],map.get(arr[i])+1);

            }
            else
                map.put(arr[i],1);
            output.add(arr[i]);
        }
        SortComparator comp=new SortComparator(map);
        Collections.sort(output,comp);
        for(int i:output){
            System.out.print(i+" ");
        }

    }


    public class SortComparator implements Comparator<Integer>{
        Map<Integer,Integer> map = new HashMap<>();

        SortComparator(Map<Integer,Integer> freqMap){
            this.map=freqMap;
        }

        @Override
        public int compare(Integer o1, Integer o2) {

            int freqComp=map.get(o1).compareTo(map.get(o1));
            int valueComp=o1.compareTo(o2);
            if(freqComp==0)
                return valueComp;
            else
                return freqComp;

        }
    }

}
