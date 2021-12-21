package dijkstra;

public class Edge {

    private final Knot src;
    private final Knot target;
    private final int distance;

    public Edge(Knot src, Knot target, int distance) {
        this.src = src;
        this.target = target;
        this.distance = distance;
    }

    public Knot getSource() {
        return src;
    }

    public Knot getTarget() {
        return target;
    }

    public int getDistance() {
        return distance;
    }
}
