// 자료구조(6065) 과제 #9 (60241180 김윤진)
package week10;

public class Quick {
    public static int comparisonCount = 0;
    public static int swapCount = 0;

    public static void sort(Comparable[] a) {
        comparisonCount = 0;
        swapCount = 0;
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static int partition(Comparable[] a, int pivot, int high) {
        int i = pivot + 1;
        int j = high;
        Comparable p = a[pivot];
        while (true) {
            while (i <= high && !isLess(p, a[i])) i++;
            while (j >= pivot && isLess(p, a[j])) j--;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, pivot, j);
        return j;
    }

    private static boolean isLess(Comparable u, Comparable v) {
        comparisonCount++;
        return (u.compareTo(v) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
        swapCount++;
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}