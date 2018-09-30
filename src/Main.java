public class Main {

    public static void main(String[] args) {
        testDeque();

//        testRandomizedQueue();
    }

    private static void testRandomizedQueue() {
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);

        print("Random queue:");
        print(queue);
        print(queue);
        print(queue);

        print("Samples:");
        print(queue.sample());
        print(queue.sample());
        print(queue.sample());

        print("Dequeuing:");
        print(queue.dequeue());
        print(queue.dequeue());
        print(queue.dequeue());

        print("Random queue:");
        print(queue);
        print(queue);
        print(queue);
        print(queue);
        print(queue);

    }

    private static void testDeque() {
        Deque<Integer> deque = new Deque<>();

        deque.addFirst(1);
        deque.removeFirst();
        print(String.format("Is deque empty? %s", deque.isEmpty()));
        deque.addFirst(1);

        deque.removeLast();
        print(String.format("Is deque empty? %s", deque.isEmpty()));
        deque.addFirst(1);
        deque.removeFirst();
        deque.addLast(1);
        print(deque);

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);

        print(deque);

        deque.removeFirst();
        deque.removeLast();

        print(deque);

        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.removeLast();
        print(deque);

    }

    private static void print(Object n) {
        System.out.println(n);
    }


    private static <T> void print(Iterable<T> deque) {
        for(T i : deque) {
            System.out.print(String.format("%s, ", i));
        }
        System.out.println();
    }
}
