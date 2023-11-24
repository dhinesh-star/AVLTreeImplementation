package PrefixSum_And_Kadanes;

import java.util.Scanner;

public class Kadanes {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of array:- ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the array elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        //Kadane's Algorithm starts here
        //Kadane's Algorithm is used to find the maximum sub-array sum in the given the array
        int train=0,maxSubArraySum=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int currTrain=train+arr[i];
            //If the ith person starts new train
            int newTrain=arr[i];
            train=Math.max(currTrain,newTrain);
            //Out of all the sub-array(train), max sum sub-array sum will be one of biggest trains
            maxSubArraySum=Math.max(maxSubArraySum,train);
        }
        System.out.println("maxSum:- "+maxSubArraySum);
        //To find the index of maximum sub-array sum index
        int osi=-1;
        int oei=-1;
        int maxSum=Integer.MIN_VALUE;

        int csi=0;
        int cei=0;
        int currSum=0;
        for(int i=0;i<n;i++){
            int prevSum=currSum+arr[i];
            int newTrain=arr[i];
            if(newTrain>prevSum){
                csi=i;
                cei=i;
                currSum=newTrain;
            }
            else{
                currSum=prevSum;
            }

            if(currSum>maxSum){
                osi=csi;
                oei=cei;
                maxSum=currSum;
            }
            cei++;
        }
        System.out.println("Starting Index of maximum Sub-array:- "+osi);
        System.out.println("Ending Index of maximum sub-array:- "+oei);
    }
}
