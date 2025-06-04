// 자료구조(6065) 과제 #8 (60241180 김윤진)

package week9;

public class QuadProbing<K, V> {
    private int M = 23; // 테이블 크기
    private int N = 0; // 항목 수 N개
    private K[] a = (K[]) new Object[M]; // 해시테이블
    private V[] d = (V[]) new Object[M]; // 키 관련 데이터 저장

    public int collisionCount = 0;
    public int totalProbeCount = 0;
    public int maxProbeCount = 0;

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; //나눗셈함수 (음수되는거 방지함)
    }

    private void put(K key, V data) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;

        do {
            if (a[i] == null) { //삽입 위치 발견
                a[i] = key;
                d[i] = data;
                return;
            }
            if (a[i].equals(key)) { //이미 key 존재
                d[i] = data;
            }
            i = (initialpos + j * j++) % M; //i = 다음위치

        } while (N < M);
    }

    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        while (a[i] != null) {
            if (a[i].equals(key)) {
                return d[i];
            }
            i = (initialpos + j * j++) % M;
        }
        return null;
    }

    public void insertWithProbeCount(K key) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        int probes = 1;

        while (a[i] != null) {
            if (a[i].equals(key)) {
                return;
            }
            collisionCount++;
            i = (initialpos + j * j) % M;
            j++;
            probes++;
        }

        a[i] = key;
        totalProbeCount += probes;
        maxProbeCount = Math.max(maxProbeCount, probes);
    }
}
