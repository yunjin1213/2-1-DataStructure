// 자료구조(6065) 과제 #8 (60241180 김윤진)

package week9;

public class DoubleHashing<K, V> {
    private int M = 23; // 테이블 크기
    private int N = 0; // 항목 수 N개
    private K[] a = (K[]) new Object[M]; // 해시테이블
    private V[] dt = (V[]) new Object[M]; // 키 관련 데이터 저장

    public int collisionCount = 0;
    public int totalProbeCount = 0;
    public int maxProbeCount = 0;

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; //나눗셈함수 (음수되는거 방지함)
    }

    private void put(K key, V data) {
        int initialpos = hash(key);
        int i = initialpos;
        int j = 1;
        int d = (7 - (int) key % 7); // 두 번째 해시 함수

        do {
            if (a[i] == null) {
                a[i] = key;
                dt[i] = data;
                return;
            }
            if (a[i].equals(key)) {
                dt[i] = data;
                return;
            }
            i = (initialpos + j * d) % M;
            j++;
        } while (N < M);
    }

    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos;
        int j = 1;
        int d = (7 - (int) key % 7); // 두 번째 해시 함수

        while (a[i] != null) {
            if (a[i].equals(key)) {
                return dt[i];
            }
            i = (initialpos + j * d) % M;
            j++;
        }
        return null;
    }

    public void insertWithProbeCount(K key) {
        int initialpos = hash(key);
        int d = secondHash(key);
        int i = initialpos;
        int j = 1;
        int probes = 1;

        while (a[i] != null) {
            if (a[i].equals(key)) {
                return;
            }
            collisionCount++;
            i = (initialpos + j * d) % M;
            j++;
            probes++;
        }

        a[i] = key;
        totalProbeCount += probes;
        maxProbeCount = Math.max(maxProbeCount, probes);
    }

    private int Hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private int secondHash(K key) {
        return 7 - (key.hashCode() & 0x7fffffff) % 7;
    }


}
