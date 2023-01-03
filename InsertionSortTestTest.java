package LAB05;

import org.junit.jupiter.api.Test;

import static LAB05.InsertionSort.insertionSort;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTestTest
{
    InsertionSort s =new InsertionSort();
   @Test
    void insertionSortGeneral()
   {
       int[] a={6,90,4,5,3,1,10};
       s.insertionSort(a);
       assertArrayEquals(new int[]{1,3,4,5,6,10,90},a);
   }
   @Test
    void insertionSortEmpty()
   {
       int [] a={};
       s.insertionSort(a);
       assertArrayEquals(new int[]{},a);
   }
   @Test
    void insertionSortSorted()
   {
       int[]a={1,2,3,4,5,6,7,8};
       s.insertionSort(a);
       assertArrayEquals(new int[]{1,2,3,4,5,6,7,8},a);
   }
   @Test
    void insertionSortOnlyOne()
   {
        int[]a={6};
        s.insertionSort(a);
        assertArrayEquals(new int[]{6},a);
   }


}