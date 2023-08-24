package sorting;

import java.util.Arrays;

public class SortingAlgorithm {
    public static void main(String[] args) {

    }


    public void bubbleSort(int[] a) {
        System.out.println(" Before sorting " + Arrays.toString(a));
        int x;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    x = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = x;
                }
            }

        }
        //using single loop
        /*for(int i=0;i<a.length-1;i++){
            if(a[i]>a[i+1]){
                int y =a[i];
                a[i]=a[i+1];
                a[i+1]=y;
                i=-1;
            }
        }*/
        System.out.println(" After sorting " + Arrays.toString(a));
    }

    /**
     * unstable algorithm -- If any array contains the duplicate element then the output sorted array does
     * does not arrange the element in same order as they were in unsorted array.
     *
     * @param a
     */
    public void selectionSort(int[] a) {
        System.out.println(" Before sorting " + Arrays.toString(a));
        for (int i = 0; i < a.length; i++) {
            int smallest = findSmallestIndex(a, i);
            swapElement(a, i, smallest);
        }
        System.out.println(" After sorting " + Arrays.toString(a));
    }

    public void swapElement(int[] a, int i, int smallest) {
        int temp;
        temp = a[i];
        a[i] = a[smallest];
        a[smallest] = temp;
    }

    public int findSmallestIndex(int[] a, int index) {
        int smallest = index;
        for (int i = index + 1; i < a.length; i++) {
            if (a[i] < a[smallest]) {
                smallest = i;
            }
        }
        return smallest;
    }

    /**
     * Stable implementation of selection sort
     */

    public void stableSelectionSort(int a[]) {
        System.out.println(" Before Sorting " + Arrays.toString(a));
        for (int i = 0; i < a.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[smallest] > a[j]) {
                    smallest = j;
                }
            }
            int key = a[smallest];
            while (smallest > i) {
                a[smallest] = a[smallest - 1];
                smallest--;
            }
            a[i] = key;
        }
        System.out.println(" After Sorting " + Arrays.toString(a));
    }

    public void insertionSorting(int[] a) {
        /*System.out.println(" Before sorting " + Arrays.toString(a));
        for (int i = 0; i < a.length - 1; i++) {
            int j = i + 1;
            while (j > 0) {
                if (a[j] < a[j - 1]) {
                    swapElement(a, j, j - 1);
                }
                j--;
            }
        }
        System.out.println(" After Sorting " + Arrays.toString(a));*/
        System.out.println(" Before sorting " + Arrays.toString(a));
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
        System.out.println(" After sorting " + Arrays.toString(a));
    }

    public void shellSorting(int[] a) {
        System.out.println(" Before sorting " + Arrays.toString(a));
        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                int temp = a[i];
                int j = i;
                while (j >= gap && a[j - gap] > temp) {
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
        }
        System.out.println(" After sorting " + Arrays.toString(a));
    }
}
