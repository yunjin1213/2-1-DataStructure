// 자료구조(6065) 과제 #8 (60241180 김윤진)

package week9;

public class LinearProbing<K, V> {
    private int M = 23; // 테이블 크기
    private K[] a = (K[]) new Object[M]; // 해시테이블
    private V[] d = (V[]) new Object[M]; // 키 관련 데이터 저장

    public int collisionCount = 0;
    public int totalProbeCount = 0;
    public int maxProbeCount = 0;

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M; //나눗셈함수 (음수되는거 방지함)
    }

    private void put(K key, V data) { //삽입 연산
        int initialpos = hash(key);  // 초기위치
        int i = initialpos, j = 1;

        do {
            if (a[i] == null) {
                a[i] = key;
                d[i] = data;
                return;
            }
            if (a[i].equals(key)) {
                d[i] = data;
                return;
            }
            i = (initialpos + 1) % M;
        } while (i != initialpos);
    }

    public V get(K key) {
        int initialpos = hash(key);
        int i = initialpos, j = 1;
        while (a[i] != null) {
            if (a[i].equals(key)) {
                return d[i];
            }
            i = (initialpos + 1) % M;
        }
        return null;
    }

    public void insertWithProbeCount(K key) {
        int initialpos = hash(key);
        int i = initialpos;
        int probes = 1;

        while (a[i] != null) {
            if (a[i].equals(key)) {
                return;
            }
            collisionCount++;
            i = (i + 1) % M;
            probes++;
        }

        a[i] = key;
        totalProbeCount += probes;
        maxProbeCount = Math.max(maxProbeCount, probes);
    }
}
