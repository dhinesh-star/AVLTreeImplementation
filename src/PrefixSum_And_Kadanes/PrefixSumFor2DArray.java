package PrefixSum_And_Kadanes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Pair{
    int row1;
    int row2;
    int column1;
    int column2;
    Pair(int row1, int row2, int column1, int column2){
        this.row1=row1;
        this.row2=row2;
        this.column1=column1;
        this.column2=column2;
    }
}
public class PrefixSumFor2DArray {
    public static void printingMatrix(int[][] arr, int n, int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of rows:- ");
        int n=sc.nextInt();
        System.out.print("Enter the no.of columns:- ");
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        System.out.println("Enter the matrix");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.print("No.of queries:- ");
        int noOfQueries=sc.nextInt();
        System.out.println("Enter the query first pair left top corner and second pair right most corner");
        Pair[] queries=new Pair[noOfQueries];
        for(int i=0;i<noOfQueries;i++){
            int leftTopRow=sc.nextInt();
            int leftTopColumn= sc.nextInt();
            int rightBottomRow = sc.nextInt();
            int rightBottomColumn = sc.nextInt();
            queries[i]=new Pair(leftTopRow,rightBottomRow,leftTopColumn,rightBottomColumn);
        }

        //Creating 2D prefix Matrix;
        int[][] prefixMatrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //Calculating the answer
                int A = matrix[i][j];
                int B = (i-1>=0)?prefixMatrix[i-1][j]:0;
                int C = (j-1>=0)?prefixMatrix[i][j-1]:0;
                int D=(i-1>=0 && j-1>=0)?prefixMatrix[i-1][j-1]:0;
                prefixMatrix[i][j] = A+B+C-D;
            }
        }
        System.out.println("Original Matrix");
        printingMatrix(matrix,n,m);
        System.out.println("Prefix Matrix");
        printingMatrix(prefixMatrix,n,m);

        //Calculating the queries answer;
        List<Integer> ansList=new ArrayList<>();
        for(Pair query:queries){
            int r1=query.row1;
            int c1=query.column1;
            int r2=query.row2;
            int c2=query.column2;
            //Calculating the answer
            int A = prefixMatrix[r2][c2];
            int B = (r1-1>=0)?prefixMatrix[r1-1][c2]:0;
            int C = (c1-1>=0)?prefixMatrix[r2][c1-1]:0;
            int D = (r1-1>=0 && c1-1>=0)?prefixMatrix[r1-1][c1-1]:0;

            int ans = A-B-C+D;
            ansList.add(ans);
        }
        System.out.println("Final answer for all the queries:- "+ansList);
    }
}
