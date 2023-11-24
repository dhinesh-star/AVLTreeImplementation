package PrefixSum_And_Kadanes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrefixSumFor1DArray {
    public static int prefixSubArray(List<Integer> prefixSum, int sp, int ep){
        if(sp<=0) return prefixSum.get(ep);
        return prefixSum.get(ep)-prefixSum.get(sp-1);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array:- ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the Array Element");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter the no.of query:- ");
        int noOfQueries=sc.nextInt();
        int[][] queries = new int[noOfQueries][2];
        System.out.println("Enter the queries range");
        for(int i=0;i<noOfQueries;i++){
            queries[i][0]=sc.nextInt();
            queries[i][1]=sc.nextInt();
        }
        //Creating the prefixSum array
        List<Integer> prefixSum = new ArrayList<>();
        int runningSum=0;
        for(int i=0;i<n;i++){
            runningSum+=arr[i];
            prefixSum.add(runningSum);
        }
        System.out.println("PrefixSum List:- "+prefixSum);
        List<Integer> ansList = new ArrayList<>();
        for(int[] query:queries){
            int sp=query[0],ep=query[1];
            int ans=prefixSubArray(prefixSum,sp,ep);
            ansList.add(ans);
//            int ans=((sp<=0)?ansList.get(ep):(ansList.get(ep)-ansList.get(sp-1)));
//            ansList.add(ans);
        }
        System.out.println("Final Answer:- "+ansList);
    }
}
