package  dijkstra;

import java.util.*;

class Dijkstra {

  private class DijkstraInfo {
    int distToStart;
    Knot predecessor;
    boolean visited;

    DijkstraInfo(int distToStart, Knot predecessor, boolean visited) {
      this.distToStart = distToStart;
      this.predecessor = predecessor;
      this.visited = visited;
    }
  }

  private List<Knot> knots;
  private List<Edge> edges;
  private Map<Knot, DijkstraInfo> knotInfos = new HashMap<>();

  Dijkstra(Graph graph) {
    knots = graph.getKnots();
    edges = graph.getEdges();
  }

  /** Fancy Execute */
  void executeFancy(Knot start) {
    PriorityQueue<Knot> queue = new PriorityQueue<>(Comparator.comparing(x -> knotInfos.get(x).distToStart));
    knotInfos.put(start,new DijkstraInfo(0,null,true));
    queue.offer(start);

    while(!queue.isEmpty()){
      Knot cur = queue.poll();
      edges.stream().filter(x -> x.getSource() == cur).forEach( e -> {
        int dist = knotInfos.get(cur).distToStart + e.getDistance();
        if(!knotInfos.containsKey(e.getTarget()) || knotInfos.get(e.getTarget()).distToStart > dist){
          knotInfos.put(e.getTarget(), new DijkstraInfo(dist,cur,true));
          queue.offer(e.getTarget());
        }
      });
    }
  }


  /** normal Execute */
  void execute(Knot start) {
    knotInfos = new HashMap<>();
    knots.forEach(x -> knotInfos.put(x, new DijkstraInfo(Integer.MAX_VALUE,null,false)));

    Comparator<Knot> myOwnComparator = Comparator.comparing(x -> knotInfos.get(x).distToStart);
    PriorityQueue<Knot> queue = new PriorityQueue<>(myOwnComparator);

    knotInfos.put(start,new DijkstraInfo(0,null,true));
    queue.offer(start);

    while(!queue.isEmpty()) {

      Knot cur = queue.poll();
      knotInfos.get(cur).visited = true;

      for (Edge e : edges) {
        if (e.getSource() != cur) continue;
        if (knotInfos.get(e.getTarget()).visited) continue;

        int oldDist = knotInfos.get(e.getTarget()).distToStart;
        int newDist = knotInfos.get(cur).distToStart + e.getDistance();

        if (newDist < oldDist) {
          queue.remove(e.getTarget()); //remove old Value if existent - queue is not distinct
          knotInfos.get(e.getTarget()).distToStart = newDist;
          knotInfos.get(e.getTarget()).predecessor = cur;
          //adds new Elem. This is moved down to ensure the new weight is used to prioritize the node in the Queue
          queue.offer(e.getTarget());
          }

      }
    }
  }


  List<Knot> getShortestPath(Knot start, Knot target) {
    LinkedList<Knot> path = new LinkedList<>();
    path.addFirst(target);
    Knot current = target;
    while(current != start) {
      if(current == null) return Collections.emptyList();
      current = knotInfos.get(current).predecessor;
      path.addFirst(current);
    }

    return path;
  }

}
