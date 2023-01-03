package LAB05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest
{
    SelectionSort s = new SelectionSort();
    @Test
    void SelectionSortGeneral ()
        {
            int[] a={6,90,4,5,3,1,10};
            s.selectionSort(a);
            assertArrayEquals(new int[]{1,3,4,5,6,10,90},a);
        }
    @Test
    void SelectionSortEmpty()
        {
            int []a={};
            s.selectionSort(a);
            assertArrayEquals(new int[]{},a);
        }
    @Test
    void SelectionSortSorted()
    {
        int []a={1,2,3,4,5,6};
        s.selectionSort(a);
        assertArrayEquals(new int[]{1,2,3,4,5,6},a);
    }
    @Test
    void SelectionSortOnlyOne()
    {
        int[]a={1};
        s.selectionSort(a);
        assertArrayEquals(new int[]{1},a);
    }
}
