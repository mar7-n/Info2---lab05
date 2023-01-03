package LAB05;

import java.util.Arrays;

public class SelectionSortApproximation
{

    public static void selectionSort(int[] sortArr)
    {
        int counter = 0;
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
                counter++;
            }
            sortArr[pos]=sortArr[i];
            sortArr[i]=min;
            counter++;
        }
        System.out.println("Number of operations: " + counter);
    }
    public static void main(String args[])
    {
        int[]sortArr={1,2,3,4,5,6,7,8};//int[]sortArr={8,56,87,3,9,32,100,567};
        System.out.println("Was");
        System.out.println(Arrays.toString(sortArr));
        selectionSort(sortArr);
        System.out.println("Become");
        System.out.println(Arrays.toString(sortArr));
    }
}
