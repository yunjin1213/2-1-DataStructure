// 자료구조(6065) 과제 #9 (60241180 김윤진)
package week10;

public class Selection {

    public static int comparisonCount = 0;
    public static int swapCount = 0;

    public static void sort(Comparable[] a) {
        comparisonCount = 0;
        swapCount = 0;

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (isless(a[j], a[min])) min = j;
            }
            swap(a, i, min);
        }
    }

    private static boolean isless(Comparable i, Comparable j) {
        comparisonCount++;
        return (i.compareTo(j) < 0);
    }

    private static void swap(Comparable[] a, int i, int j) {
        swapCount++;
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
