package sb223jy_assign3.exercise_6;

import sb223jy_assign3.exercise_4.Word;

import java.util.Iterator;
import java.util.Stack;

public class TreeWordSet implements WordSet {
    private Tree root;
    private int size;

    public TreeWordSet() {

    }

    @Override
    public void add(Word word) {
        if (root == null) {
            root = new Tree(word);
            size++;
            return;
        }

        if (!contains(word)) {
            size++;
            root.add(word);
        }
    }

    @Override
    public boolean contains(Word word) {
        return root.contains(word);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new TreeIterator();
    }

    private class Tree {
        Word word;
        Tree left = null;
        Tree right = null;

        Tree(Word data) {
            word = data;
        }

        void add(Word data) {
            if (data.compareTo(word) < 0) {
                if (left == null)
                    left = new Tree(data);
                else
                    left.add(data);
            } else if (data.compareTo(word) > 0) {
                if (right == null)
                    right = new Tree(data);
                else
                    right.add(data);
            }
        }

        boolean contains(Word data) {
            Tree copy = this;

            do {
                if (data.compareTo(copy.word) < 0) {
                    if (copy.left == null)
                        return false;
                    else {
                        copy = copy.left;
                    }
                } else if (data.compareTo(copy.word) > 0) {
                    if (copy.right == null)
                        return false;
                    else {
                        copy = copy.right;
                    }
                }
            } while (data.compareTo(copy.word) != 0);
            return true;
        }
    }

    class TreeIterator implements java.util.Iterator {
        private Stack<Tree> s;

        TreeIterator() {
            s = new Stack<>();

            s.push(root);
            Tree current = root;
            while (current.left != null) {
                current = current.left;
                s.push(current);
            }
        }

        @Override
        public boolean hasNext() {
            return s.size() > 0;
        }

        @Override
        public Object next() {
            Tree result = s.pop();

            if (result.right != null) {
                Tree current = result.right;
                s.push(current);

                while (current.left != null) {
                    current = current.left;
                    s.push(current);
                }
            }
            return result.word;
        }
    }

}
