// 자료구조(6065) 과제 #9 (60241180 김윤진)
package week10;

public class Shell {
    public static int comparisonCount = 0;
    public static int swapCount = 0;

    public static void sort(Comparable[] a) {
        comparisonCount = 0;
        swapCount = 0;

        int N = a.length;
        int h = 4;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && isless(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);

                }
            }
            h /= 3;
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
