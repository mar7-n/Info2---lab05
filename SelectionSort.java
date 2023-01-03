package LAB05;

import java.util.Arrays;

public class SelectionSort
{
    public static void selectionSort(int[] sortArr)
    {
        if (sortArr.length == 0)
        {
            return;
        }

        for (int i=0; i< sortArr.length;i++)
        {
            int pos=i;
            int min=sortArr[i];
            for (int j=i+1;j< sortArr.length;j++)
            {
                if (sortArr[j]<min)
                {
                    pos=j;
                    min=sortArr[j];
                }
            }
            sortArr[pos]=sortArr[i];
            sortArr[i]=min;
        }
    }
    public static void main(String args[])
    {
        int[]sortArr={8,56,87,3,9,32,100,567};
        System.out.println("Was");
        System.out.println(Arrays.toString(sortArr));
        selectionSort(sortArr);
        System.out.println("Become");
        System.out.println(Arrays.toString(sortArr));
    }
}
