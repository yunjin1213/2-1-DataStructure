//자료구조(6065) 과제 #7 (60241180 김윤진)

package week8;

public class Main {
    public static void main(String[] args) {
        Entry a[] = new Entry[20];

         
        a[1] = new Entry(92, "Rose");
        a[2] = new Entry(87, "Tulip");
        a[3] = new Entry(15, "Lily");
        a[4] = new Entry(99, "Sunflower");
        a[5] = new Entry(33, "Daisy");
        a[6] = new Entry(12, "Orchid");
        a[7] = new Entry(77, "Peony");
        a[8] = new Entry(41, "Lavender");
        a[9] = new Entry(5, "Carnation");
        a[10] = new Entry(68, "Jasmine");
        a[11] = new Entry(9, "Azalea");
        a[12] = new Entry(26, "Camellia");

        BHeap<Integer, String> heap = new BHeap<>(a, 12);

        System.out.println("자료구조(6065) 과제 #7 (60241180 김윤진)");
        System.out.println();

        System.out.println("최소힙 구축 전 힙의 (키,값) & 높이");
        printHeap(heap);

        heap.creatHeap();

        System.out.println("최소힙 구축 후 힙의 (키, 값) & 높이");
        printHeap(heap);

        heap.insert(44, "Begonia");
        heap.insert(73, "Freesia");

        System.out.println("(44, \"Begonia\"), (73, \"Freesia\") 삽입 후 최소힙의 (키, 값) & 높이");
        printHeap(heap);

        Entry<Integer, String> minHeap = heap.deleteMin();
        System.out.println("최소값(Key) 삭제 후 삭제된 키의 값(Value): (" + minHeap.getKey() + ", " + minHeap.getValue() + ")");
        System.out.println("최소값 삭제 후 최소힙의 (키, 값) & 높이");
        printHeap(heap);

        heap.decreaseKey(99, 29);
        System.out.println("99를 29로 감소 후 최소힙의 (키,값) & 높이");
        printHeap(heap);

        heap.delete(33);
        System.out.println("33을 삭제 후 최소힙의 (키, 값) & 높이");
        printHeap(heap);

    }

    public static void printHeap(BHeap<Integer, String> heap) {
        for (int i = 1; i <= heap.size(); i++) {
            Entry<Integer, String> e = heap.getEntry(i);
            System.out.print("(" + e.getKey() + ", " + e.getValue() + ") ");
        }
        System.out.println();
        System.out.println("힙 높이: " + getHeight(heap.size()));
        System.out.println();
    }

    public static int getHeight(int n) {
        return (int) (Math.log(n + 1) / Math.log(2));
    }
}