package sb223jy_lab4.sorter_orter;

public class Ort implements Comparable<Ort>{
    private int postkod;
    private String namn;

    public Ort(int postkod, String namn) {
        this.postkod = postkod;
        this.namn = namn;
    }

    public String toString() {
        return postkod + " " + namn;
    }

    @Override
    public int compareTo(Ort o) {
        if (postkod == o.postkod)
            return 0;
        else if (postkod > o.postkod)
            return 1;
        else
            return -1;
    }
}
