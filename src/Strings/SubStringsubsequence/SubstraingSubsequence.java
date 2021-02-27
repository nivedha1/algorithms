package Strings.SubStringsubsequence;

import java.util.*;

public class SubstraingSubsequence {
    //3 4 6 8 11              42 43 45
    static int[][] L=null;
    public static void main(String args[]){
        LogestSubsequenceWithElementOccuringKTimes();//1
        oneStringisSubsequenceofSecondString();//2
        String a = "geeksforgeeks";
        String b = "ge";
        System.out.println(findNumberOfTimesAstringOccursInOtherString(a,b));//5//7//9//12
        LCSPermutationsAllowed();//10
        a = "abcabcaa";
        b = "acbacba";
        L=new int[a.length()+1][b.length()+1];
        System.out.println(PrintLengthofLCS(a,b,a.length(),b.length()));
        SortedSet<String> out=findAllLCS(a,b,a.length(),b.length());//14 13
        for(String s:out){
            System.out.println(s);
        }
        longeatBalancedPAranthesis();//38
        idEndingWithSubstring();//39
        lcsof3Strings();//41
        searchStringInset();//44
        lengthofLongestSubstringWithequal1and0();//46
        System.out.println(closestPalindromeNumber());//48
        findLongestVowel();//47
        findSubstringAllVowels();//49

    }

    private static void longeatBalancedPAranthesis() {
        String str = "((()())())((";
        int n = str.length();

        int sum = 0;
            int maxi = 0;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '(')
                    sum += 1;
                else
                    sum -= 1;
                if (sum == 0)
                    maxi = i;
            }
            System.out.println(maxi + 1);
    }

    private static void idEndingWithSubstring() {
        //Check if a string is suffix of another
        String s1 = "geeks", s2 = "geeksforgeeks";
        boolean result = s2.endsWith(s1);
        if (result)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static void lcsof3Strings() {
        String X = "AGGT12";
        String Y = "12TXAYB";
        String Z = "12XBA";

        int m = X.length();
        int n = Y.length();
        int o = Z.length();

        int[][][] L = new int[m+1][n+1][o+1];
            for (int i=0; i<=m; i++)
            {
                for (int j=0; j<=n; j++)
                {
                    for (int k=0; k<=o; k++)
                    {
                        if (i == 0 || j == 0||k==0)
                            L[i][j][k] = 0;

                        else if (X.charAt(i - 1) == Y.charAt(j - 1)
                                && X.charAt(i - 1)==Z.charAt(k - 1))
                            L[i][j][k] = L[i-1][j-1][k-1] + 1;

                        else
                            L[i][j][k] = Math.max(Math.max(L[i-1][j][k],
                                    L[i][j-1][k]),
                                    L[i][j][k-1]);
                    }
                }
            }

            System.out.println(L[m][n][o]);

    }

    private static void searchStringInset() {
        String[] arr = {"aba","baba","aba","xzxb"};
        String[] q   = {"aba","xzxb","ab"};

        int counter = 0;
        for (int i=0;i<q.length; i++)
            for (int j = 0; j < arr.length; j++)
                if (q[i].equals(arr[j]))
                    counter++;

        System.out.println(counter);
    }


    private static void lengthofLongestSubstringWithequal1and0() {
        //Length of the longest substring with equal 1s and 0s
        String str = "101001000";
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map. put(0, -1);
        int res =0;
        int count_0 = 0, count_1 = 0;
        for(int i=0; i<str.length();i++)
        {
            if(str.charAt(i)=='0')
                count_0++;
            else
                count_1++;
            if(map.containsKey(count_1-count_0))
                res = Math.max(res, (i - map.get(count_1-count_0)));
            else
                map.put(count_1-count_0,i);

        }

        System.out.println("Length of longest balanced sub string = "+res);

    }

    static boolean isPalindrome(String n) {
        for (int i = 0; i < n.length() / 2; i++)
            if (n.charAt(i) != n.charAt(n.length() - 1 - i))
                return false;
        return true;
    }
    private static int closestPalindromeNumber() {
        int num = 121;
            int RPNum = num - 1;
            while (!isPalindrome(String.valueOf(Math.abs(RPNum))))
                RPNum--;
            int SPNum = num + 1;
            while (!isPalindrome(String.valueOf(Math.abs(SPNum))))
                SPNum++;
            if (Math.abs(num - RPNum) > Math.abs(num - SPNum))
                return SPNum;
            else
                return RPNum;

    }


    static void findLongestVowel()
    {
        String str = "aeoibsddaeiouudb";
        int count = 0, res = 0;
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++)
        {
            if (isVowel(s[i]))
                count++;
            else
            {
                res = Math.max(res, count);
                count = 0;
            }
        }
        System.out.println(res);
    }
    static boolean isVowel(char x) {
        return (x == 'a' || x == 'e' || x == 'i'
                || x == 'o' || x == 'u');
    }
    private static void findSubstringAllVowels() {
        String str = "aeoibsddaeiouudb";
        HashSet<Character> hash = new HashSet<Character>();
            int n = str.length();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (isVowel(str.charAt(j)) == false)
                        break;
                    hash.add(str.charAt(j));
                    if (hash.size() == 5)
                        System.out.print(str.substring(i, j + 1) + " ");
                }
                hash.clear();
            }
    }

    public static SortedSet<String> findAllLCS(String a, String b, int m, int n) {
            SortedSet<String> s = new TreeSet<>();
            if (m == 0 || n == 0)
            {
                s.add("");
                return s;
            }
            if (a.charAt(m - 1) == b.charAt(n - 1))
            {
                Set<String> tmp = findAllLCS(a, b, m - 1, n - 1);
                for (String str : tmp)
                    s.add(str + a.charAt(m - 1));
            }
            else
            {
                // If LCS can be constructed from top side of the matrix, recurse for X[0..m-2] and Y[0..n-1]
                if (L[m - 1][n] >= L[m][n - 1])
                    s = findAllLCS(a, b, m - 1, n);
                // If LCS can be constructed from left side of the matrix, recurse for X[0..m-1] and Y[0..n-2]
                if (L[m][n - 1] >= L[m - 1][n])
                {
                    Set<String> tmp = findAllLCS(a, b, m, n - 1);
                    // merge two sets if L[m-1][n] == L[m][n-1] Note s will be empty if L[m-1][n] != L[m][n-1]
                    s.addAll(tmp);
                }
            }
            return s;
    }

    private static int PrintLengthofLCS(String a, String b, int m, int n) {
        /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
//        ABCD 			EFGH
//        abc,efgh                 abcd efg
//        abc,efg  ab,efgh		abc,efg  abcd,ef
        //abc,efg is repeated twice
//        int lcs( char *X, char *Y, int m, int n )
//        {
//            if (m == 0 || n == 0)
//                return 0;
//            if (X[m-1] == Y[n-1])
//                return 1 + lcs(X, Y, m-1, n-1);
//            else
//                return max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
//        }
        for (int i = 0; i <= m; i++)
            {
                for (int j = 0; j <= n; j++)
                {
                    if (i == 0 || j == 0)
                        L[i][j] = 0;
                    else if (a.charAt(i - 1) == b.charAt(j - 1))
                        L[i][j] = L[i - 1][j - 1] + 1;
                    else
                        L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
            return L[m][n];
    }

    private static void LCSPermutationsAllowed() {
        //Longest common subsequence with permutations allowed
        String str1 = "geeks", str2 = "cake";
        int count1[] = new int[26], count2[] = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            count2[str2.charAt(i) - 'a']++;
        }
        String result = "";
        for (int i = 0; i < 26; i++)
        {
            for (int j = 1; j <= Math.min(count1[i], count2[i]); j++) {
                result += (char)('a' + i);
            }
        }

        System.out.println(result);

    }

    private static int findNumberOfTimesAstringOccursInOtherString(String a,String b) {
        //Find number of times a string occurs as a subsequence in given string
         int i,j=0;
        int m=a.length();
        int n=b.length();
        int[][] dp=new int[m+1][n+1];
        for(i=0;i<=n;i++){
            dp[0][i]=0;
        }
        for(j=0;j<=m;j++){
            dp[j][0]=1;
        }
        for(i=1;i<=m;i++){
            char c=a.charAt(i-1);
            for(j=1;j<=n;j++){
                if(c==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    private static void oneStringisSubsequenceofSecondString() {
        String str1 = "gksrek";
        String str2 = "geeksforgeeks";
        int m = str1.length();
        int n = str2.length();
        int i=0,j=0;
        for (i = 0,j=0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;
        System.out.println(j == m);
    }

    private static void LogestSubsequenceWithElementOccuringKTimes() {
        //Longest subsequence where every character appears at-least k times
        String str = "geeksforgeeks";
        int n = str.length();
        int k = 2;
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            freq[str.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            char c = str.charAt(i);
            if(freq[c-'a']>=k)
                System.out.print(c+" ");
        }
    }

}
