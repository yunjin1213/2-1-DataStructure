// 자료구조(6065) 과제 #8 (60241180 김윤진)
package week9;

import java.util.Random;
import java.util.stream.IntStream;

public class HashingExperiment {
    public static void main(String[] args) {
        // 0~99 사이 난수 20개 생성
        Integer[] keys = new Random().ints(20, 0, 100)
                .boxed()
                .toArray(Integer[]::new);

        System.out.println("자료구조(6065) 과제 #8 (60241180 김윤진)");
        System.out.println();
        System.out.print("삽입할 키: ");
        IntStream.range(0, keys.length).forEach(i -> System.out.print(keys[i] + (i < keys.length - 1 ? ", " : "\n")));

        LinearProbing<Integer, String> lp = new LinearProbing<>();
        QuadProbing<Integer, String> qp = new QuadProbing<>();
        DoubleHashing<Integer, String> dh = new DoubleHashing<>();
        Chaining<Integer, String> ch = new Chaining<>();

        // Linear Probing
        System.out.println("\nLinear Probing:");
        for (Integer key : keys) lp.insertWithProbeCount(key);
        printStats(lp.collisionCount, lp.totalProbeCount, lp.maxProbeCount);

        // Quadratic Probing
        System.out.println("\nQuadratic Probing:");
        for (Integer key : keys) qp.insertWithProbeCount(key);
        printStats(qp.collisionCount, qp.totalProbeCount, qp.maxProbeCount);

        // Double Hashing
        System.out.println("\nDouble Hashing:");
        for (Integer key : keys) dh.insertWithProbeCount(key);
        printStats(dh.collisionCount, dh.totalProbeCount, dh.maxProbeCount);

        // Chaining
        System.out.println("\nChaining:");
        for (Integer key : keys) ch.put(key, "a");
        ch.printTable();
    }

    private static void printStats(int collisions, int totalProbes, int maxProbes) {
        System.out.println("충돌 횟수: " + collisions);
        System.out.println("평균 조사 횟수: " + String.format("%.2f", totalProbes / 20.0));
        System.out.println("최대 조사 횟수: " + maxProbes);
    }
}