import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Permutation {

    public static void main(String[] args) {
        int k;

        if (args.length > 0) k = Integer.parseInt(args[0]);
        else k = StdIn.readInt();

        RandomizedQueue<String> queue = new RandomizedQueue<>();

        if (args.length > 1) {
            for (int i = 1; i < args.length; ++i) queue.enqueue(args[i]);
        } else {
            while (!StdIn.isEmpty()) {
                String string = StdIn.readString();
                if (!string.isEmpty()) queue.enqueue(string);
            }
        }

        Iterator<String> iterator = queue.iterator();
        for (int i = 0; i < k && iterator.hasNext(); ++i) {
            System.out.println(iterator.next());
        }
    }

}