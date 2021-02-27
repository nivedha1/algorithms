package Hackerrank;

public class PrimeNumber {
    boolean[] p = new boolean[1000001];

    public static void main(String args[]){
        PrimeNumber obj = new PrimeNumber();
        obj.setMultipleTo1();
        obj.checkPrime(21);
        obj.checkPrimeForLoop(21);
    }
    public void setMultipleTo1() {
        for (int i = 2; i <= 1000000; i++) {
            if (!p[i]) {// it will set all multiple of numbers i from I*2,i*3(j=i+i;j=i+i+i..) to 1)
                for (int j = 2 * i; j <= 1000000; j += i)
                    p[j] = true;
            }
        }
    }

    public void checkPrime(int num){

        if(!p[num])
            System.out.println("num is prime");
        else
            System.out.println("num is not prime");
    }

    public void checkPrimeForLoop(int num){

        boolean flag=false;
        for(int j=3;j<=num/2;j=j+2){
            if(num%j==0){
                flag=true;
                System.out.println(j+"is prime factor of "+num);
                break;
            }
        }
        if(!flag)
            System.out.println("Number is prime");
        else
            System.out.println("Number is not prime");

    }
}
