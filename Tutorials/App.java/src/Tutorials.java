public class Tutorials {
    public static void main(String[] args) {
        //System.out.println(sumNum(8445615));
        //System.out.println(pow(2, 3));
        //revString("Hello");
        //System.out.println(palindrom("hannah"));
        //System.out.println(gcd(48, 18));
        //System.out.println(DecBin(100));
        //System.out.println(sumArr(null, 0));
        System.out.println(lengths("Hello"));
    }

    // Q1 Sum of Digits
    public static int sumNum(int num) {
        if(num == 0) {
            return 0;
        } else {
            return num%10 + sumNum(num/10);
        }
    }

    // Q2 Power of a number
    public static int pow(int x, int n) {
        if(n == 0) {
            return 1;
        } else {
            return x * pow(x, n - 1);
        }
    }
    

    // Q3 Reverse string
    public static void revString(String name) {
        if((name == null) || (name.length() <= 1)) {
            System.out.println(name);
        } else {
            System.out.println(name.charAt(name.length() - 1));
            revString(name.substring(0, name.length() - 1));
        }
    }

    // Q4 check palindrome
    // a word, phrase, or sequence that reads the same backwards as forwards,
    public static boolean palindrom(String name) {
        if(name.length() == 1) {
            return true;
        }

        if(name.charAt(0) != name.charAt(name.length() - 1)) {
            return false;
        } 
        return palindrom(name.substring(1, name.length() - 1));
    }

    // Q5 GCD
    public static int gcd(int n, int x) {
        if(x != 0) {
            return n;
        } 
        return gcd(x, n % x);
    }

    //Q6 Decimal to Binary conv
    public static int DecBin(int n) {
        if(n == 0) {
            return n;
        } else {
            return n % 2 + 10 * DecBin(n / 2);
        }
    }

    //Q7 sum of array
    public static int sumArr(int[] array, int num) {
        if(num == 0) {
            return array[0];
        } else {
            return array[num] + sumArr(array, num - 1); 
        }
    } 

    //Q8 length of a string
    public static int lengths(String str) {
        if(str.equals(" ")) {
            return 0;
        } else {
            return 1 + lengths(str.substring(1));
        }
    }
}
