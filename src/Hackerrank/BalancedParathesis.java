package Hackerrank;
import java.util.*;
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.io.*;
import java.util.*;
class BalancedParathesis {




        public static void main(String[] args) throws IOException {
                 Scanner s = new Scanner(System.in);
                int n = s.nextInt();                 // Reading input from STDIN
                int[] arr =new int[n];

                for(int i=0;i<n;i++){
                    arr[i]=s.nextInt();
                }
                int[] dp = new int[n];
                dp[n-1]=0;
                for(int i=n-2;i>=0;i--){//5 2 3 7 9 8 11
                    int temp=arr[i];
                    for(int j=i+1;j<n;j++)
                    {
                        if(temp<arr[j])
                            dp[i]=dp[i]+1;
                    }
                }

                int t = s.nextInt();
                int[] ans=new int[t];
                for(int i=0;i<t;i++){
                    int a =s.nextInt();
                    int b=s.nextInt();

                    ans[i]=dp[a]-dp[b];
                }

                for(int i:ans)
                    System.out.println(i);

                // Write your code here

            }
        }
