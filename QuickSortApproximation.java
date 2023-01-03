package LAB05;

import java.util.Arrays;

public class QuickSortApproximation
{
    static int counter=0;
    public static void quickSort(int[] array, int low, int high)
    {
       // int counter=0;
        if (array.length == 0)
        {
            return;
        }
        if (low >= high)
        {
            return;
        }
        //choose the middle element and pivot
        int middle = low + (high - low) / 2;
        int pivot = array[middle];
        //declaration of elements which low of our middle element or high
        int i=low;
        int j=high;
        // divide into subarrays that are larger and smaller than the reference element
        while(i<=j)
        {
            while(array[i]<pivot)
            {
                i++;
                counter++;
            }

            while(array[j]>pivot)
            {
                j--;
                counter++;
            }

            //swapping
            if(i<=j)
            {
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;

            }
            counter++;

        }
        //recursion call for sorting left and right
        if(low<j)
        {
            quickSort(array,low,j);

        }
        if(high>i)
        {
            quickSort(array,i,high);

        }


    }

    public static void main(String[] args)
    {
        //int counter=0;
        int [] testArray={12,11,10,9,8,7,6,5,4,3,2,1};
        //int [] testArray={3,87,105,43,56,1,0,998,345,77,-6,91};
        System.out.println("Was");
        System.out.println(Arrays.toString(testArray));

        int low = 0;
        int high = testArray.length - 1;


        quickSort(testArray, low, high);
        System.out.println("Become");
        System.out.println(Arrays.toString(testArray));
        System.out.println("Number of operations: " + counter);

    }
}
