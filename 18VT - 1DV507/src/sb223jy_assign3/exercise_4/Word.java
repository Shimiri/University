package sb223jy_assign3.exercise_4;

public class Word implements Comparable<Word> {
    private String word;

    public String getWord() {
        return word;
    }

    public Word(String str) {
        word = str.toLowerCase();
    }

    public String toString() {
        return word;
    }

    public int hashCode() {
        int hc = 0;
        for (int i = 0; i < word.length(); i++) {
            hc += word.charAt(i) - i;
        }
        return hc;
    }

    public boolean equals(Object other) {
        if (other instanceof Word) {
            Word tmp = (Word) other;
            return word.hashCode() == tmp.word.hashCode();
        }
        return false;
    }

    public int compareTo(Word w) {
        return word.compareTo(w.toString());
    }
}
