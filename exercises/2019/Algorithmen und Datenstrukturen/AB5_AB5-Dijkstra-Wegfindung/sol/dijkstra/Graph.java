package dijkstra;
import java.util.List;

public class Graph {

    private List<Knot> knots;
	  private List<Edge> edges;

    public Graph(List<Knot> knots, List<Edge> edges) {
        this.knots = knots;
        this.edges = edges;
    }

    public List<Knot> getKnots() {
        return knots;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
