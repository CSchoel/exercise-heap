package dijkstra;

import java.util.Objects;

public class Knot {

    private final int id;

    public Knot(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knot that = (Knot) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Knot Nr." + id;
    }
}
