public class Patterns {
    public static void main(String[] args) {
        //printHollowRect(5,5);
        //printInvertedAndRotatedPyramid(9);
        //printInvertedPyramidWithNumbers(10);
        //printFloydsTriangle(7);
        //printZeroOneTriangle(7);
        //printButterfly(4);
        //printButterflyPattern(4);
        //printRhombus(5);
        //printHollowRhombus(5);
        printDiamond(4);
        //symmetricalVoidPattern(5);
    }

    static void printHollowRect(int rows, int columns) {
        for(int i=1;i<=rows;i++) {
            for(int j=1;j<=columns;j++) {
                if(i==1||i==rows||j==1||j==columns) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void printInvertedAndRotatedPyramid(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows; j++) {
                if (i == rows || j == rows || i+j >= rows+1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void printInvertedPyramidWithNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void printFloydsTriangle(int n) {
        int c=1;
        for (int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(c+" ");
                c++;
            }
            System.out.println();
        }
    }

    static void printZeroOneTriangle(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                if ((i+j)%2 == 0) {
                    System.out.print(1 +" ");
                } else {
                    System.out.print(0+" ");
                }
            }
            System.out.println();
        }
    }

    static void printButterfly(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=2*n; j++) {
                if (j<=i||j>(2*n)-i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--) {
            for(int j=1;j<=2*n; j++) {
                if (j<=i||j>(2*n)-i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void printButterflyPattern(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i; j++) {
               System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--) {
            for(int j=1;j<=i; j++) {
                System.out.print("*");
            }
            for(int j=1;j<=2*(n-i);j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printRhombus(int n) {
        for (int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=n;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printHollowRhombus(int n) {
        for (int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }
            for (int j=1;j<=n;j++) {
                if(i==1||i==5||j==1||j==5) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

//                *
//               ***
//              *****
//             *******
//             *******
//              *****
//               ***
//                *

    static void printDiamond(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--) {
            for(int j=1;j<=n-i;j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

//            **********
//            ****  ****
//            ***    ***
//            **      **
//            *        *
//            *        *
//            **      **
//            ***    ***
//            ****  ****
//            **********
    static void symmetricalVoidPattern(int n) {
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=(n-i+1);j++) {
                System.out.print("*");
            }
            for(int j=1;j<=2*(i-1);j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=(n-i+1);j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--) {
            for(int j=1;j<=(n-i+1);j++) {
                System.out.print("*");
            }
            for(int j=1;j<=2*(i-1);j++) {
                System.out.print(" ");
            }
            for(int j=1;j<=(n-i+1);j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //not complted
    static void numberPattern(int n) {
        for (int i=1;i<=(2*n)-1;i++) {
            for(int j=1;j<=(2*n)-1;j++) {
                if(i==1||i==(2*n)-i||j==1||j==(2*n)-i) {
                    System.out.print(n);
                }
            }
        }
    }
}
