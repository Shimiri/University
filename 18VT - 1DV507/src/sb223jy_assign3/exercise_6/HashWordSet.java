package sb223jy_assign3.exercise_6;

import sb223jy_assign3.exercise_4.Word;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashWordSet implements WordSet {
    private int size;
    private int pos = -1;
    private Node[] buckets = new Node[8];
    private Node n;

    public HashWordSet() {

    }

    @Override
    public void add(Word word) {
        if (!contains(word)) {
            if (++size == buckets.length)
                rehash();
            int pos = getPosition(word);
            if (buckets[pos] == null) {
                buckets[pos] = new Node(word);
            } else {
                Node last = traverseList(buckets[pos]);
                last.next = new Node(word);
            }
        }
    }

    @Override
    public boolean contains(Word word) {
        int pos = getPosition(word);
        if (buckets[pos] == null)
            return false;
        Node n = buckets[pos];
        while (n != null) {
            if (n.data.equals(word))
                return true;
            n = n.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                if (n != null && n.next != null)
                    return true;
                for (int i = pos + 1; i < buckets.length; i++) {
                    if (buckets[i] != null)
                        return true;
                }
                return false;
            }

            @Override
            public Object next() {
                if (n != null && n.next != null) {
                    n = n.next;
                } else {
                    do {
                        pos++;
                        if (pos == buckets.length) {
                            throw new NoSuchElementException();
                        }
                        n = buckets[pos];
                    } while (n == null);
                }
                return n.data;
            }
        };
    }

    private int getPosition(Word word) {
        int hc = word.hashCode();
        if (hc < 0)
            hc = -hc;
        return hc % buckets.length;
    }

    private Node traverseList(Node last) {
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    private void rehash() {
        Node[] copies = buckets;
        buckets = new Node[2 * copies.length];
        size = 0;
        for (Node n : copies) {
            if (n == null) continue;
            while (n != null) {
                add(n.data);
                n = n.next;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buckets.length; i++) {
            sb.append("Bucket ").append(i + 1).append(":").append("\n");
            Node n = buckets[i];
            while (n != null){
                sb.append("    ").append(n.data.toString()).append("\n");
                n = n.next;
            }
        }
        return sb.toString();
    }

    private class Node {
        Node (Word data) {
            this.data = data;
        }

        Word data;
        Node next;
    }
}
