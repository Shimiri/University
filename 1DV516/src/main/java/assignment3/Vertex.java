package assignment3;

public class Vertex {
    private int item;

    public Vertex(int item) {
        this.item = item;
    }

    public int getItem() {
        return item;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex)
            return ((Vertex) obj).getItem() == item;
        return false;
    }

    @Override
    public int hashCode() {
        return item;
    }
}
