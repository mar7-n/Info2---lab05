package LAB05;

import java.util.Arrays;

public class MergeSortApproximation
{
    static int counter=0;
    public static void mergeSort(int[] a, int lo, int hi) {
        counter++;
        if (hi <= lo) return;
        int mid = (lo+hi)/2;
        mergeSort(a,lo,mid);
        mergeSort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    public static void merge(int[] a, int lo, int mid, int hi){

        int [] aux = a.clone();
        int count = lo;
        int i = lo;
        int j = mid+1;
        while(i<=mid && j<=hi)
        {
            if(aux[i]<aux[j])
            {
                a[count] = aux[i];
                i++;
            } else {
                a[count] = aux[j];
                j++;
            }
            count++;
            counter++;

        }
       

        if(i<=mid)
        {
            for(;i<=mid;i++,count++)
            {
                a[count] = aux[i];
                counter++;
            }
        }
        else if(j<=hi)
        {
            for(;j<=hi;j++,count++)
            {
                a[count] = aux[j];
                counter++;
            }
        }

    }
    public static void main(String[] args)
    {
        int [] testArray={1,2,3,4,5,6,7,8,9,10,11,12};
        //int [] testArray={3,87,105,43,56,1,0,998,345,77,-6,91};
        System.out.println("Was");
        System.out.println(Arrays.toString(testArray));

        int low = 0;
        int high = testArray.length - 1;

        mergeSort(testArray, low, high);
        System.out.println("Become");
        System.out.println(Arrays.toString(testArray));
        System.out.println("Number of operations: " + counter);
    }

}
