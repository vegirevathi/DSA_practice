public class Arrays2D {

    static void printCountOfElements(int[][] matrix, int key){
        int count=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j]==key){
                    count++;
                }
            }
        }
        System.out.println("count of "+ key+" is "+count);
    }

    static void sumOfNumbersInARow(int[][] matrix, int row){
        int sum=0;
        for(int c=0;c< matrix.length;c++){
            sum+=matrix[row-1][c];
        }
        System.out.println("sum of elements in row "+ row+" is "+sum);
    }

    static void transposeOfMatrix(int[][] matrix){
        int rows=matrix.length;
        int columns=matrix[0].length;
        int[][] matrixTranspose=new int[columns][rows];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrixTranspose[j][i]=matrix[i][j];
            }
        }
        for(int i=0;i<matrixTranspose.length;i++){
            for(int j=0;j<matrixTranspose[0].length;j++){
                System.out.print(matrixTranspose[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] input={ {1,4,9},{11,4,3},{2,2,3} };
        //printCountOfElements(input, 3);
        //sumOfNumbersInARow(input, 2);
        transposeOfMatrix(input);
    }
}
