// 자료구조(6065) 과제 #9 (60241180 김윤진)
package week10;

public class Insertion {

    public static int comparisonCount = 0;
    public static int swapCount = 0;

    public static void sort(Comparable[] a) {
        comparisonCount = 0;
        swapCount = 0;

        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (isless(a[j], a[j - 1]))
                    swap(a, j, j - 1);
                else break;
            }
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

