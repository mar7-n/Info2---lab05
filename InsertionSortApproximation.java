package LAB05;

import java.util.Arrays;

public class InsertionSortApproximation
{
    public static void insertionSort(int[] sortArr)
    {
        int counter=0;
        if (sortArr.length == 0)
        {
            return;
        }
        int j=0;
        for (int i=1;i< sortArr.length;i++)
        {
            int swap=sortArr[i];
            for (j=i;j>0&&swap<sortArr[j-1];j--)
            {
                sortArr[j]=sortArr[j-1];
                counter++;
            }
            sortArr[j]=swap;
            counter++;

        }
        System.out.println("Number of operations: " + counter);
    }
    public static void main(String args[])
    {
        int[]sortArr={8,7,6,5,4,3,2,1};// int[]sortArr={1,2,3,4,5,6,7,8};// int[]sortArr={567,345,76,1,2,8,901,53,765,890,0,-8,6543,3456,367,234,890,61870};int[]sortArr={1,2,3,4,5,6,7,8};//int[]sortArr={8,56,87,3,9,32,100,567};
        System.out.println("Was");
        System.out.println(Arrays.toString(sortArr));
        insertionSort(sortArr);
        System.out.println("Become");
        System.out.println(Arrays.toString(sortArr));
    }
}
