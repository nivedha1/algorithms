package Strings.Anagrams;
import java.util.*;
//2 printing anagrams
public class Anagrams {
    static final int MAX = 256;
    public static void main(String args[]){
        char str1[] = { 't', 'e', 's', 't' };
        char str2[] = { 't', 't', 'e', 'w' };
        System.out.println(checkAnagram(str1,str2));//1
        AnagramSubStringSearch();//3
        AllAngramPairsInSetOfStrings();//4
        countDeletionsInStwoStringToMakeThemANagram("bcadeh","hea");//5
        System.out.println(CheckKCharforTwoStringstoBecomeAngram("anagram","grammar",2));//6
        System.out.println(bitAnagramCheck(8,4));//7
        countOfAnagramSubString("xyyx");//10
        System.out.println(countChangableStringsWithoutDeletiontOMakeAnagrams("ddcf","cedk"));//11
        String[] str={"abc","acb","bac","cad","dac"};
        groupAnagrams(str);

    }

        public static List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0)
                return new ArrayList<List<String>>();

            int listIndex = 0;
            List<List<String>> result = new ArrayList<>();
            Map<String, Integer> anagramGroup = new HashMap<>();

            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);//note
                String sorted = new String(chars);//note char[] can be converted to string
                if (anagramGroup.containsKey(sorted)) {
                    int index = anagramGroup.get(sorted);
                    List<String> listResult = result.get(index);
                    listResult.add(str);
                } else {
                    List<String> resultList = new ArrayList<>();
                    resultList.add(str);
                    result.add(listIndex, resultList);
                    anagramGroup.put(sorted, listIndex);
                    listIndex++;
                }
            }
            return result;
        }

    static int countChangableStringsWithoutDeletiontOMakeAnagrams(String s1, String s2)
    {
        int count = 0;
      int char_count[] = new int[26];
      for (int i = 0; i < s1.length(); i++)
            char_count[s1.charAt(i) - 'a']++;
      for (int i = 0; i < s2.length(); i++)
            if (char_count[s2.charAt(i) - 'a']-- <= 0)
                count++;
        return count;
    }

    private static void countOfAnagramSubString(String str) {

        int[] freq=new int[26];
        Map<String,Integer> flist = new HashMap<>();
        int k=0;
        for(int i=0;i<str.length();i++){
            String s="";
            for(int j=i;j<str.length();j++){
                freq=new int[26];

                s=s+str.charAt(j);
                for(char a:s.toCharArray()){
                    freq[a-'a']++;
                }
                if(!flist.containsKey(Arrays.toString(freq))){
                    flist.put(Arrays.toString(freq),1);
                }else{
                    int val=flist.get(Arrays.toString(freq))+1;
                    flist.put(Arrays.toString(freq),val);
                }
                }
            }

        int res=0;
        for(int val:flist.values()){
            if(val>=2)
            res=res+(val*(val-1)/2);
        }
        System.out.println(res);

    }


    static boolean bitAnagramCheck(long a, long b)
        {//bitcount gives numbe rof ones in binary string
            return (Long.bitCount(a) == Long.bitCount(b));
        }


    static boolean CheckKCharforTwoStringstoBecomeAngram(String str1, String str2,
                                int k)
    {
        int MAX_CHAR=26;
        int n = str1.length();
        if (str2.length() != n)
            return false;
        int[] count1 = new int[MAX_CHAR];
        int[] count2 = new int[MAX_CHAR];
        int count = 0;
        for (int i = 0; i < n; i++)
            count1[str1.charAt(i) - 'a']++;
        for (int i = 0; i < n; i++)
            count2[str2.charAt(i) - 'a']++;
        for (int i = 0; i < MAX_CHAR; i++)
            if (count1[i] > count2[i])
                count = count + Math.abs(count1[i] -
                        count2[i]);
        return (count <= k);
    }
    static void countDeletionsInStwoStringToMakeThemANagram(String str1, String str2) {
        int arr[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            arr[str1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            arr[str2.charAt(i) - 'a']--;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(arr[i]);
        }
        System.out.println(ans);
    }


    private static void AllAngramPairsInSetOfStrings() {
        String arr[] = {"geeksquiz", "geeksforgeeks", "abcd",
                "forgeeksgeeks", "zuiqkeegs"};;
        int n=arr.length;
        for (int i = 0; i < n; i++)
                for (int j = i+1; j < n; j++)
                    if (checkAnagram(arr[i].toCharArray(), arr[j].toCharArray()))
                        System.out.println(arr[i] +" is anagram of " + arr[j]);

    }

    static boolean compare(char arr1[], char arr2[])
    {
        for (int i = 0; i < MAX; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
    private static void AnagramSubStringSearch() {
        String txt = "BACDGABCDA";
        String pat = "ABCD";
            int M = pat.length();
            int N = txt.length();
            char[] countP = new char[MAX];
            char[] countTW = new char[MAX];
            for (int i = 0; i < M; i++)
            {
                (countP[pat.charAt(i)])++;
                (countTW[txt.charAt(i)])++;
            }

            for (int i = M; i < N; i++)
            {
                if (compare(countP, countTW))
                    System.out.println("Found at Index " +
                            (i - M));
                (countTW[txt.charAt(i)])++;
                countTW[txt.charAt(i-M)]--;
            }
            if (compare(countP, countTW))
                System.out.println("Found at Index " +
                        (N - M));
    }

    private static  boolean checkAnagram(char[] str1,char[] str2){
        int n1 = str1.length;
        int n2 = str2.length;
        int[] char1=new int[26];
        int[] char2=new int[26];
        if (n1 != n2) {
            return false;
        }
        for(char c:str1){
            char1[c-'a']++;
        }
        for(char c:str2){
            char2[c-'a']++;
        }

        for (int i = 0; i < 26; i++)
            if (char1[i] != char2[i])
                return false;
        return true;
    }
    private static boolean checkAnagram1(char[] str1,char[]  str2) {
        int n1 = str1.length;
            int n2 = str2.length;
            if (n1 != n2) {
                return false;
            }
            Arrays.sort(str1);
            Arrays.sort(str2);
            for (int i = 0; i < n1; i++)
                if (str1[i] != str2[i])
                    return false;
            return true;
    }
}
