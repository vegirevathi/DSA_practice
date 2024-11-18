import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {

        String input = "a1bcd10cj2";
        String result = alphaString(input);
        System.out.println(result);

        System.out.println("GCD: "+findGcdByEuclideanAlgo(16,8));
        System.out.println("Count: "+((int)Math.log10(1234567) +1));
    }
    public static ArrayList<Integer> findDivisors(int n) {
        // Initialize an empty
        // ArrayList to store the divisors
        ArrayList<Integer> divisors = new ArrayList<>();

        // Iterate up to the square
        // root of n to find divisors
        // Calculate the square root of n
        int sqrtN = (int) Math.sqrt(n);

        // Loop from 1 to the
        // square root of n
        for (int i = 1; i <= sqrtN; ++i) {
            // Check if i divides n
            // without leaving a remainder
            if (n % i == 0) {
                // Add divisor i to the list
                divisors.add(i);

                // Add the counterpart divisor
                // if it's different from i
                if (i != n / i) {
                    // Add the counterpart
                    // divisor to the list
                    divisors.add(n / i);
                }
            }
        }

        // Return the list of divisors
        return divisors;
    }

    static int findGcd(int a, int b) {
        // code here
        //int i = (a<b)?a:b;
        for(int j=((a<b)?a:b);j>0;j--) {
            if ((a%j==0)&&(b%j==0)) {
                return j;
            }
        }
        return 1;
    }

    static int findGcdByEuclideanAlgo(int a, int b) {
        while (a>0&&b>0) {
            if (a>b) {
                a = a%b;
            } else {
                b = b%a;
            }
        }
        return (a==0)?b:a;
    }

    static String alphaString(String input) {
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int k=0;k<input.length();k++) {
            char ch = input.charAt(k);
            if (Character.isLetter(ch)) {
                temp.append(ch);
                //System.out.println("temmp"+temp.toString());
            } else if (Character.isDigit(ch)){
//                for (int i=0;i<ch[k];i++) {
//                    result.append(temp);
//                }

                int count=Character.getNumericValue(ch);
                result.append(temp.toString().repeat(count));
                temp.setLength(0);
            }
        }
        return result.toString();
    }
}