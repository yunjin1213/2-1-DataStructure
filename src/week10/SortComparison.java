// 자료구조(6065) 과제 #9 (60241180 김윤진)
package week10;

import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        // 0-9999 까지 난수 생성
        Integer[] keys = new Random().ints(1000, 0, 10000)
                .boxed()
                .toArray(Integer[]::new);

        System.out.println("자료구조(6065) 과제 #9 (60241180 김윤진)");
        System.out.println();

        Integer[] arrayTOSort;
        long start;
        long end;

        // Selection sort
        arrayTOSort = keys.clone();
        start = System.nanoTime();
        Selection.sort(arrayTOSort);
        end = System.nanoTime();
        System.out.printf("[Selection sort] 소요된 시간: %.3fms, 원소간 비교 횟수: %d, 원소 교환 횟수: %d\n", (end - start) / 1_000_000.0, Selection.comparisonCount, Selection.swapCount);

        // Insertion sort
        arrayTOSort = keys.clone();
        start = System.nanoTime();
        Insertion.sort(arrayTOSort);
        end = System.nanoTime();
        System.out.printf("[Insertion sort] 소요된 시간: %.3fms, 원소간 비교 횟수: %d, 원소 교환 횟수: %d\n", (end - start) / 1_000_000.0, Insertion.comparisonCount, Insertion.swapCount);

        // Shell sort
        arrayTOSort = keys.clone();
        start = System.nanoTime();
        Shell.sort(arrayTOSort);
        end = System.nanoTime();
        System.out.printf("[Shell sort] 소요된 시간: %.3fms, 원소간 비교 횟수: %d, 원소 교환 횟수: %d\n", (end - start) / 1_000_000.0, Shell.comparisonCount, Shell.swapCount);

        // Heap sort
        arrayTOSort = new Integer[keys.length + 1];
        arrayTOSort[0] = 0;
        System.arraycopy(keys, 0, arrayTOSort, 1, keys.length);
        start = System.nanoTime();
        Heap.sort(arrayTOSort);
        end = System.nanoTime();
        System.out.printf("[Heap sort] 소요된 시간: %.3fms, 원소간 비교 횟수: %d, 원소 교환 횟수: %d\n", (end - start) / 1_000_000.0, Heap.comparisonCount, Heap.swapCount);

        // Merge sort
        arrayTOSort = keys.clone();
        start = System.nanoTime();
        Merge.sort(arrayTOSort);
        end = System.nanoTime();
        System.out.printf("[Merge sort] 소요된 시간: %.3fms, 원소간 비교 횟수: %d, 원소 교환 횟수: %d\n", (end - start) / 1_000_000.0, Merge.comparisonCount, Merge.swapCount);

        // Quick sort
        arrayTOSort = keys.clone();
        start = System.nanoTime();
        Quick.sort(arrayTOSort);
        end = System.nanoTime();
        System.out.printf("[Quick sort] 소요된 시간: %.3fms, 원소간 비교 횟수: %d, 원소 교환 횟수: %d\n", (end - start) / 1_000_000.0, Quick.comparisonCount, Quick.swapCount);

        /* 결과 분석
         * 1. 정렬 시간 (가장 긴 -> 짧은 순):
         * Insertion > Selection > Shell > Quick > Merge > Heap
         *
         * 2. 원소간 비교 횟수 (가장 많은 -> 적은 순):
         * Selection > Insertion > Shell > Quick > Heap > Merge
         *
         * 3. 원소 교환 횟수
         * Insertion > Shell > Selection > Heap > Merge > Quick
         */

        System.out.println("------------------------------------------------------");
        System.out.println("결과 분석");
        System.out.println("1. 정렬 시간 (가장 긴 -> 짧은 순):");
        System.out.println("   Insertion > Selection > Shell > Quick > Merge > Heap");

        System.out.println("2. 원소간 비교 횟수 (가장 많은 -> 적은 순):");
        System.out.println("   Selection > Insertion > Shell > Quick > Heap > Merge");

        System.out.println("3. 원소 교환 횟수 (가장 많은 -> 적은 순):");
        System.out.println("   Insertion > Shell > Selection > Heap > Merge > Quick");
    }
}
