// 자료구조(6065) 과제 #8 (60241180 김윤진)

package week9;

import java.util.Arrays;
import java.util.Random;

public class HashingExperiment {
    public static void main(String[] args) {
        // (1) 0~99 사이 난수 20개 생성
        Random rand = new Random();
        Integer[] keys = new Integer[20];
        for (int i = 0; i < 20; i++) {
            keys[i] = rand.nextInt(100);
        }
        System.out.println("자료구조(6065) 과제 #8 (60241180 김윤진)");
        System.out.println();
        System.out.println("삽입할 키: " + Arrays.toString(keys));

        // (2) 각각의 해시 테이블 초기화
        LinearProbing<Integer, String> lp = new LinearProbing<>();
        QuadProbing<Integer, String> qp = new QuadProbing<>();
        DoubleHashing<Integer, String> dh = new DoubleHashing<>();
        Chaining<Integer, String> ch = new Chaining<>();

        // (3) 각 방식으로 삽입하고 충돌/조사횟수 측정
        System.out.println("\nLinear Probing:");
        for (Integer key : keys) lp.insertWithProbeCount(key);
        printStats(lp.collisionCount, lp.totalProbeCount, lp.maxProbeCount);

        System.out.println("\nQuadratic Probing:");
        for (Integer key : keys) qp.insertWithProbeCount(key);
        printStats(qp.collisionCount, qp.totalProbeCount, qp.maxProbeCount);

        System.out.println("\nDouble Hashing:");
        for (Integer key : keys) dh.insertWithProbeCount(key);
        printStats(dh.collisionCount, dh.totalProbeCount, dh.maxProbeCount);

        System.out.println("\nChaining:");
        for (Integer key : keys) ch.put(key, "");
        ch.printTable();
    }

    private static void printStats(int collisions, int totalProbes, int maxProbes) {
        System.out.println("충돌 횟수: " + collisions);
        System.out.println("평균 조사 횟수: " + String.format("%.2f", totalProbes / 20.0));
        System.out.println("최대 조사 횟수: " + maxProbes);
    }
}
