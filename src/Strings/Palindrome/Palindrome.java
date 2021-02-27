package Strings.Palindrome;
import java.util.Arrays;
public class Palindrome {

    public static void main(String args[]){
        System.out.println((isRotationOfPalindrome("aab")) ? 1 : 0);//2
        System.out.println(canFormPalindrome("geeksogeeks"));


    }
    static boolean canFormPalindrome(String str) {
        int count[] = new int[26];
        Arrays.fill(count, 0);
        for (int i = 0; i < str.length(); i++)
            count[(str.charAt(i))-'a']++;
        int odd = 0;
        for (int i = 0; i < 26; i++)
        {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return false;
        }
        return true;
    }
    static boolean isPalindrome(String str)
    {
        int l = 0;
        int h = str.length() - 1;
        while (h > l)
            if (str.charAt(l++) != str.charAt(h--))
                return false;
        return true;
    }
    static boolean isRotationOfPalindrome(String str)
    {//Check if a given string is a rotation of a palindrome
        if (isPalindrome(str))
            return true;
        int n = str.length();
        for (int i = 0; i < n - 1; i++) {
            String str1 = str.substring(i + 1);
            String str2 = str.substring(0, i + 1);
            if (isPalindrome(str1 + str2))
                return true;
        }
        return false;
    }
}
