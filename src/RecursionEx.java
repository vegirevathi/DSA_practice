public class RecursionEx {

    static void printNums(int k, int n){
        if(k==n){
            System.out.println(n);
            return;
        }
        System.out.println(k);
        printNums(k+1, n);
    }

    static void printNums2ndMethod(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printNums2ndMethod(n-1);
        System.out.println(n);
    }

    static int printFactorial(int n){
        if(n==0){
            return 1;
        }
        int fact=n*printFactorial(n-1);
        return fact;
    }

    static int sumOfNumbers(int n) {
        if(n==0){
            return 0;
        }
        int sum=n+sumOfNumbers(n-1);
        return sum;
    }

    static void printFibonacci(int first, int second, int count, int n) {
        if(count==n){
            System.out.println(first+second);
            return;
        }
        System.out.println(first+second);
        count++;
        second=first+second;
        first=second-first;
        printFibonacci(first, second, count, n);
    }

    static int printFibonacci2ndMethod(int n){
        if(n==1 || n==0){
            return n;
        }
        int fibnm1 = printFibonacci2ndMethod(n-1);//fibonacci of n minus 1
        int fibnm2 = printFibonacci2ndMethod(n-2);//fibonacci of n minus 2
        return fibnm1+fibnm2;
    }

    static boolean isSorted(int[] arr, int i){
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    static int findFirstOccurence(int[] arr, int i, int k){
        if(i>arr.length-1){
            return -1;
        }
        if(arr[i]==k){
            return i;
        }
        return findFirstOccurence(arr, i+1, k);
    }

    static int findLastOccurence(int[] arr, int i, int k){
        if(i<0){
            return -1;
        }
        if(arr[i]==k){
            return i;
        }
        return findLastOccurence(arr, i-1, k);
    }

    static int powerOfN(int n, int x){
        if(x==0){
            return 1;
        }
        return n*powerOfN(n, x-1);
    }

    static int optimizedPower(int n, int x){
        if(x==0){
            return 1;
        }
        int halfPower = optimizedPower(n, x/2);
        int halfPowerSq=halfPower*halfPower;
        if(x%2!=0){
            halfPowerSq=halfPowerSq*n;
        }
        return halfPowerSq;
    }

    public static void main(String[] args){
        int k=1;
        int n=10;
        //printNums(k,n);
        //printNums2ndMethod(n);
        //System.out.println("factorial of 5 is "+printFactorial(5));
        //System.out.println("Sum of Natural numbers is "+sumOfNumbers(5));
//        System.out.println("Fibonacci series is ");
//        printFibonacci(0,1,2,10);
//        System.out.println(printFibonacci2ndMethod(10));

//        int[] arr={1,2,3,4,5,0};
//        System.out.println(isSorted(arr,0));
//        int[] arr={1,2,3,4,5,0,2,5,3};
        int[] arr2={5,5,5,5,5};
//        System.out.println(findFirstOccurence(arr,0, 2));
        //System.out.println(findLastOccurence(arr2,arr2.length-1, 5));
        System.out.println(optimizedPower(2,11));
    }


}
