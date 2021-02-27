package Queues.hackerearth;
import java.util.*;
public class Anagrams {
    /* IMPORTANT: Multiple classes and nested static classes are supported */



        public static void main(String args[] ) throws Exception {

            Scanner s = new Scanner(System.in);
            int tc = s.nextInt();
            for(int k=0;k<tc;k++)
            {
                String s1 = s.next();
                String s2 = s.next();

                if(s2.length()>s1.length())
                {
                    String temp = s2;
                    s2 = s1;
                    s1=temp;
                }
                int cnt =0;
                char[] carr1 = s1.toCharArray();
                char[] carr2 = s2.toCharArray();
                Arrays.sort(carr1);
                Arrays.sort(carr2);
                for(int i=0;i<carr1.length;i++){
                    char c1 = carr1[i];
                    for(int j=0;j<carr2.length;j++){
                        char c2 = carr2[j];
                        if(c2>c1){
                            break;
                        }
                        else if(c1==c2)
                        {
                            cnt++;
                            break;
                        }
                    }
                }
                cnt=cnt*2;
                System.out.println(carr1.length+carr2.length-cnt);

            }
        }

}
