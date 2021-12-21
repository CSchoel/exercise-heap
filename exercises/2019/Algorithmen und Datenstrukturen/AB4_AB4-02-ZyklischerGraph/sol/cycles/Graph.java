package cycles;

import cycles.abstractGraph.AbstractGraph;

import java.util.HashSet;
import java.util.Set;

public final class Graph<V> extends AbstractGraph<V> {

	@Override
	public final boolean hasCycles() {
		Set<V> visitedVertices = new HashSet<>();
		if (getKnots().isEmpty()) {
			return false;
		}
		return hasCyclesDFS(getKnots().iterator().next(), null, visitedVertices);
	}

	private final boolean hasCyclesDFS(final V vertex, final V parent, final Set<V> visitedVertices) {
		visitedVertices.add(vertex);
		for (V adjacentVertex : getAdjacent(vertex)) {
			if (adjacentVertex.equals(parent)) {
				continue;
			}
			if (visitedVertices.contains(adjacentVertex)) {
				return true;
			}
			if (hasCyclesDFS(adjacentVertex, vertex, visitedVertices)) {
				return true;
			}
		}
		return false;
	}

}
