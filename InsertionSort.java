package LAB05;
import java.util.*;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] sortArr)
    {
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
            }
            sortArr[j]=swap;
        }
    }
    public static void main(String args[])
    {
        int[]sortArr={8,56,87,3,9,32,100,567};
        System.out.println("Was");
        System.out.println(Arrays.toString(sortArr));
        insertionSort(sortArr);
        System.out.println("Become");
        System.out.println(Arrays.toString(sortArr));
    }

}
