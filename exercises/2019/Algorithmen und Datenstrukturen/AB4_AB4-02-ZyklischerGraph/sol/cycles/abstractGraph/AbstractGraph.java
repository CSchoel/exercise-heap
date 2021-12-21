package cycles.abstractGraph;

import java.util.*;

/**
 * Simple undirected graph implementation
 * @param <E> The type of a vertex of this graph. The underlying class should implement
 * the methods {@link Object#equals(Object)}, {@link Object#hashCode()} and {@link Object#toString()}.
 */
public abstract class AbstractGraph<E> {
	private final Set<E> knots = new HashSet<>();
	private final Set<E> immutableView = Collections.unmodifiableSet(knots);
	private final Map<E, Set<E>> edges = new HashMap<>();
	
	public AbstractGraph() {}
	
	/**
	 * Connects the two given knots. Afterwards the following property holds:<br>
	 * {@code isConnected(a, b) == true && isConnected(b, a) == true}
	 * @param a The first vertex
	 * @param b The second vertex
	 */
	public final void connect(final E a, final E b) {
		if (!knots.contains(a)) {
			throw new IllegalArgumentException(String.format("can not connect vertex '%s' with vertex '%s', '%s' is not a vertex of the graph!", a, b, a));
		}
		if (!knots.contains(b)) {
			throw new IllegalArgumentException(String.format("can not connect vertex '%s' with vertex '%s', '%s' is not a vertex of the graph!", a, b, b));
		}
		edges.get(a).add(b);
		edges.get(b).add(a);
	}
	
	/**
	 * Adds the provided knot to this graph
	 * @param knot The knot to add
	 */
	public final void addKnot(final E knot) {
	  if(knots.contains(knot))throw new IllegalArgumentException(String.format("can not add knot '%s'. Graph already contains '%s'", knot,knot));
		knots.add(knot);
		edges.put(knot, new HashSet<>());
	}
	
	/**
	 * @return All knots of this graph
	 */
	public final Set<E> getKnots() {
		return immutableView;
	}
	
	/**
	 * Checks if this graph contains a cycle
	 * @return Whether or not this graph contains a cycle
	 */
	public abstract boolean hasCycles();

	public final Set<E> getAdjacent(final E vertex) {
		return Collections.unmodifiableSet(edges.get(vertex));
	}
	
}
