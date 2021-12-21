package dijkstra;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import org.junit.Test;

import static org.junit.Assert.*;


public class DijkstraTest {

  @Test
	public void x08priorityQueueUpdateTest() {
		List<Knot> knots = IntStream.range(0, 4).mapToObj(Knot::new).collect(Collectors.toList());
		List<Edge> edges = List.of(
		        new Edge(knots.get(0), knots.get(1), 1),
                new Edge(knots.get(0), knots.get(2), 4),
                new Edge(knots.get(0), knots.get(3), 5),
                new Edge(knots.get(1), knots.get(3), 1),
                new Edge(knots.get(3), knots.get(2), 1)
		);
		List<Knot> path0 = List.of(knots.get(0));
		List<Knot> path1 = List.of(knots.get(0), knots.get(1));
		List<Knot> path2 = List.of(knots.get(0), knots.get(1), knots.get(3), knots.get(2));
		List<Knot> path3 = List.of(knots.get(0), knots.get(1), knots.get(3));
		Dijkstra d = new Dijkstra(new Graph(knots, edges));
		d.execute(knots.get(0));
		assertEquals(path0, d.getShortestPath(knots.get(0), knots.get(0)));
        assertEquals(path1, d.getShortestPath(knots.get(0), knots.get(1)));
        assertEquals(path2, d.getShortestPath(knots.get(0), knots.get(2)));
        assertEquals(path3, d.getShortestPath(knots.get(0), knots.get(3)));
    }

   @Test
   public  void x01miniStraightLineTest(){

	  /*
	  Graph:

	 (O) >>>1>>> (1) >>>3>>> (2)

	  Best Route:

	  0, 1, 2
	   */
     List<Knot> knots = new ArrayList<>();
     List<Edge> edges = new ArrayList<>();
     Graph graph;
     List<Knot> correctPath = new ArrayList<>();
     List<Knot> testedPath;

     for(int i = 0; i < 3; i++) knots.add(new Knot(i));

     for(int i = 0; i < 2; i++) edges.add(new Edge(knots.get(i),knots.get(i+1),i*2 + 1));

     graph = new Graph(knots, edges);

     for(int i = 0; i < 3;i++) correctPath.add(knots.get(i));

     Dijkstra dijkstra = new Dijkstra(graph);
     dijkstra.execute(knots.get(0));
     testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(2));

     assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

     for(int i = 0; i < correctPath.size(); i++) {
         assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
       }
   }

  @Test
  public  void x02miniGraphTriangleTest(){

	  /*
	  Graph:

	 (O) > > >1> > >(1)
	    >           >
	     >         >
	     9001     2
	        >	   >
	         >  >
	          (2)

	  Best Route:

	  0, 1, 2
	   */

    List<Knot> knots = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    Graph graph;
    List<Knot> correctPath = new ArrayList<>();
    List<Knot> testedPath;

    for(int i = 0; i < 3; i++) knots.add(new Knot(i));

    edges.add(new Edge(knots.get(0),knots.get(2),9001));
    edges.add(new Edge(knots.get(0),knots.get(1),1));
    edges.add(new Edge(knots.get(1),knots.get(2),2));

    graph = new Graph(knots, edges);

    for(int i = 0; i < 3;i++) correctPath.add(knots.get(i));

    Dijkstra dijkstra = new Dijkstra(graph);
    dijkstra.execute(knots.get(0));
    testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(2));

    assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

    for(int i = 0; i < correctPath.size(); i++) {
      assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
    }
  }

  @Test
  public  void x03miniGraphRectangleShotWayTest(){

	  /*
	  Graph:

	 (0) >>1>> (1)
	  >         >
	  7         3
	  >         >
	 (3) <<5<< (2)


	  Best Route:

	  0, 3
	   */
    List<Knot> knots = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    Graph graph;
    List<Knot> correctPath = new ArrayList<>();
    List<Knot> testedPath;

    for(int i = 0; i < 4; i++) knots.add(new Knot(i));

    edges.add(new Edge(knots.get(0),knots.get(1),1));
    edges.add(new Edge(knots.get(1),knots.get(2),3));
    edges.add(new Edge(knots.get(2),knots.get(3),5));

    edges.add(new Edge(knots.get(0),knots.get(3),7));


    graph = new Graph(knots, edges);

    correctPath.add(knots.get(0));
    correctPath.add(knots.get(3));

    Dijkstra dijkstra = new Dijkstra(graph);
    dijkstra.execute(knots.get(0));
    testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(3));

    assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

    for(int i = 0; i < correctPath.size(); i++) {
      assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
    }
  }

  @Test
  public  void x04miniGraphRectangleLongWayTest(){

	  /*
	  Graph:

	 (0) >>1>> (1)
	  >         >
	  13        3
	  >         >
	 (3) <<5<< (2)


	  Best Route:

	  0, 1, 2, 3
	   */

    List<Knot> knots = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    Graph graph;
    List<Knot> correctPath = new ArrayList<>();
    List<Knot> testedPath;

    for(int i = 0; i < 4; i++) knots.add(new Knot(i));

    edges.add(new Edge(knots.get(0),knots.get(1),1));
    edges.add(new Edge(knots.get(1),knots.get(2),3));
    edges.add(new Edge(knots.get(2),knots.get(3),5));

    edges.add(new Edge(knots.get(0),knots.get(3),13));


    graph = new Graph(knots, edges);

    for(int i = 0; i < 4;i++) correctPath.add(knots.get(i));

    Dijkstra dijkstra = new Dijkstra(graph);
    dijkstra.execute(knots.get(0));
    testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(3));

    assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

    for(int i = 0; i < correctPath.size(); i++) {
      assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
    }
  }

  @Test
  public void x05falseFriendTest(){

	  /*
	  Graph:

	  (0) >>1>> (1) >>1>> (2) >>1>> (3) >>1>> (4) >>1>> (5)
	   >         >         >         >         >         >
	    >         >        >        >         >         >
	      >        >       >       >         >         >
	        >       >      >      >       >         >
	        1000  | 900 | 800 | 700   | 50     |  600
	          >       >    >     >      >         >
	              >   >    >     >    >       >
	                  > > >  > > >  > > > > >
	                        (6)
	                    (Alles Zeigt auf 6)
	                    
	   Erklärung:
    > : Gerichtet nach rechts / unten
    < : Gerichtet nach links / oben
    - : Gerichtet in beide Richtungen (gleiches Gewicht)

	  Best Route:

	  0, 1,2,3,4,6
	   */

    List<Knot> knots = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    Graph graph;
    List<Knot> correctPath = new ArrayList<>();
    List<Knot> testedPath;

    for(int i = 0; i < 7; i++) knots.add(new Knot(i));

    for(int i = 0; i < 5; i++) edges.add(new Edge(knots.get(i),knots.get(i+1),1));


    for(int i = 0; i < 4; i++) edges.add(new Edge(knots.get(i),knots.get(6),1000 - i*100));
    edges.add(new Edge(knots.get(4),knots.get(6),50));
    edges.add(new Edge(knots.get(5),knots.get(6),600));

    graph = new Graph(knots, edges);

    for(int i = 0; i < 5;i++) correctPath.add(knots.get(i));
    correctPath.add(knots.get(6));

    Dijkstra dijkstra = new Dijkstra(graph);
    dijkstra.execute(knots.get(0));
    testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(6));

    assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

    for(int i = 0; i < correctPath.size(); i++) {
      assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
    }
  }


  @Test
  public void x06falseFriendCycleLongTest(){

	  /*
	  Graph:
	               < < < < < < < < < < < < <
               <                           <
	  (0) >>1>> (1) >>1>> (2) >>1>> (3)       1
	   >         >                  >  >        <
	    >         >                 5    11       <
	      >        >               >       >      <
	        >       >            (4) --5-- (5) > >
	        1000     90           >         >
              >      >          1        >
                >    >          >       3
                   > >         (6)    >
                     >         >     >
                       >      9     >
                          >   >   >
                            > > >
	                           (7)

    Erklärung:
    > : Gerichtet nach rechts / unten
    < : Gerichtet nach links / oben
    - : Gerichtet in beide Richtungen (gleiches Gewicht)
	  Best Route:

	  0, 1,2,3,4,5,7
	   */

    List<Knot> knots = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    Graph graph;
    List<Knot> correctPath = new ArrayList<>();
    List<Knot> testedPath;

    for(int i = 0; i < 8; i++) knots.add(new Knot(i));

    edges.add(new Edge(knots.get(0),knots.get(1),1));
    edges.add(new Edge(knots.get(0),knots.get(7),1000));

    edges.add(new Edge(knots.get(1),knots.get(2),1));
    edges.add(new Edge(knots.get(1),knots.get(7),90));

    edges.add(new Edge(knots.get(2),knots.get(3),1));

    edges.add(new Edge(knots.get(3),knots.get(4),5));
    edges.add(new Edge(knots.get(3),knots.get(5),11));

    edges.add(new Edge(knots.get(4),knots.get(6),1));
    edges.add(new Edge(knots.get(4),knots.get(5),5));

    edges.add(new Edge(knots.get(5),knots.get(4),5));
    edges.add(new Edge(knots.get(5),knots.get(7),3));
    edges.add(new Edge(knots.get(5),knots.get(1),1));

    edges.add(new Edge(knots.get(6),knots.get(7),9));

    graph = new Graph(knots, edges);

    correctPath.add(knots.get(0));
    correctPath.add(knots.get(1));
    correctPath.add(knots.get(2));
    correctPath.add(knots.get(3));
    correctPath.add(knots.get(4));
    correctPath.add(knots.get(5));
    correctPath.add(knots.get(7));

    Dijkstra dijkstra = new Dijkstra(graph);
    dijkstra.execute(knots.get(0));
    testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(7));

    assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

    for(int i = 0; i < correctPath.size(); i++) {
      assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
    }
  }

  @Test
  public void x07falseFriendCycleShortTest(){

	  /*
	  Graph:
	               > > > > > > > > > > > > >
               >                           >
	  (0) >>1>> (1) >>1>> (2) >>1>> (3)       1
	   >         >                  >  >        >
	    >         >                 5    11     >
	      >        >               >       >    >
	        >       >            (4) --5-- (5) <
	        1000     90           >         >
              >      >          1        >
                >    >          >       3
                   > >         (6)    >
                     >         >     >
                       >      9     >
                          >   >   >
                            > > >
	                           (7)

    Erklärung:
    > : Gerichtet nach rechts / unten
    < : Gerichtet nach links / oben
    - : Gerichtet in beide Richtungen (gleiches Gewicht)
	  Best Route:

	  0, 1,2,3,4,5,7
	   */

    List<Knot> knots = new ArrayList<>();
    List<Edge> edges = new ArrayList<>();
    Graph graph;
    List<Knot> correctPath = new ArrayList<>();
    List<Knot> testedPath;

    for(int i = 0; i < 8; i++) knots.add(new Knot(i));

    edges.add(new Edge(knots.get(0),knots.get(1),1));
    edges.add(new Edge(knots.get(0),knots.get(7),1000));

    edges.add(new Edge(knots.get(1),knots.get(2),1));
    edges.add(new Edge(knots.get(1),knots.get(7),90));

    //Diff to LongTest
    edges.add(new Edge(knots.get(1),knots.get(5),1));

    edges.add(new Edge(knots.get(2),knots.get(3),1));

    edges.add(new Edge(knots.get(3),knots.get(4),5));
    edges.add(new Edge(knots.get(3),knots.get(5),11));

    edges.add(new Edge(knots.get(4),knots.get(6),1));
    edges.add(new Edge(knots.get(4),knots.get(5),5));

    edges.add(new Edge(knots.get(5),knots.get(4),5));
    edges.add(new Edge(knots.get(5),knots.get(7),3));

    edges.add(new Edge(knots.get(6),knots.get(7),9));

    graph = new Graph(knots, edges);

    correctPath.add(knots.get(0));
    correctPath.add(knots.get(1));
    correctPath.add(knots.get(5));
    correctPath.add(knots.get(7));

    Dijkstra dijkstra = new Dijkstra(graph);
    dijkstra.execute(knots.get(0));
    testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(7));

    assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

    for(int i = 0; i < correctPath.size(); i++) {
      assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
    }
  }




	@Test
	public void x09smallGraphTest() {
		List<Knot> knots = new ArrayList<>();
		List<Edge> edges = new ArrayList<>();
		Graph graph;
		List<Knot> correctPath = new ArrayList<>();
		List<Knot> testedPath;
		
		for(int i = 0; i < 4; i++) knots.add(new Knot(i));
		
		edges.add(new Edge(knots.get(0), knots.get(1), 10));
		edges.add(new Edge(knots.get(1), knots.get(0), 10));
		edges.add(new Edge(knots.get(0), knots.get(2), 5));
		edges.add(new Edge(knots.get(2), knots.get(0), 5));
		edges.add(new Edge(knots.get(1), knots.get(3), 5));
		edges.add(new Edge(knots.get(3), knots.get(1), 5));
		edges.add(new Edge(knots.get(2), knots.get(3), 5));
		edges.add(new Edge(knots.get(3), knots.get(2), 5));
		
		graph = new Graph(knots, edges);
		
		correctPath.add(knots.get(0));
		correctPath.add(knots.get(2));
		correctPath.add(knots.get(3));
		
		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.execute(knots.get(0));
		testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(3));

		assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());
		
		if(correctPath.size() == testedPath.size()) 
			for(int i = 0; i < correctPath.size(); i++) {
				assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
			}
	}
	
	@Test
	public void x10mediumGraphTest() {
		List<Knot> knots = new ArrayList<>();
		List<Edge> edges = new ArrayList<>();
		Graph graph;
		List<Knot> correctPath = new ArrayList<>();
		List<Knot> testedPath;

		for (int i = 0; i < 7; i++) knots.add(new Knot(i));

		edges.add(new Edge(knots.get(0), knots.get(1), 10));
		edges.add(new Edge(knots.get(1), knots.get(0), 10));
		edges.add(new Edge(knots.get(0), knots.get(2), 5));
		edges.add(new Edge(knots.get(2), knots.get(0), 5));
		edges.add(new Edge(knots.get(1), knots.get(3), 4));
		edges.add(new Edge(knots.get(3), knots.get(1), 4));
		edges.add(new Edge(knots.get(1), knots.get(4), 19));
		edges.add(new Edge(knots.get(4), knots.get(1), 19));
		edges.add(new Edge(knots.get(3), knots.get(4), 8));
		edges.add(new Edge(knots.get(4), knots.get(3), 8));
		edges.add(new Edge(knots.get(3), knots.get(6), 13));
		edges.add(new Edge(knots.get(6), knots.get(3), 13));
		edges.add(new Edge(knots.get(4), knots.get(6), 4));
		edges.add(new Edge(knots.get(6), knots.get(4), 4));
		edges.add(new Edge(knots.get(2), knots.get(5), 20));
		edges.add(new Edge(knots.get(5), knots.get(2), 20));
		edges.add(new Edge(knots.get(5), knots.get(6), 3));
		edges.add(new Edge(knots.get(6), knots.get(5), 3));

		graph = new Graph(knots, edges);

		correctPath.add(knots.get(0));
		correctPath.add(knots.get(1));
		correctPath.add(knots.get(3));
		correctPath.add(knots.get(4));
		correctPath.add(knots.get(6));

		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.execute(knots.get(0));
		testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(6));

		assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

		if (correctPath.size() == testedPath.size())
			for (int i = 0; i < correctPath.size(); i++) {
				assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
			}
	}

	@Test
	public void x11bigGraphTest() {
		List<Knot> knots = new ArrayList<>();
		List<Edge> edges = new ArrayList<>();
		Graph graph;
		List<Knot> correctPath = new ArrayList<>();
		List<Knot> testedPath;

		for (int i = 0; i < 13; i++) knots.add(new Knot(i));

		edges.add(new Edge(knots.get(0), knots.get(1), 2));
		edges.add(new Edge(knots.get(0), knots.get(9), 1));
		edges.add(new Edge(knots.get(0), knots.get(3), 11));
		edges.add(new Edge(knots.get(1), knots.get(0), 2));
		edges.add(new Edge(knots.get(1), knots.get(4), 4));
		edges.add(new Edge(knots.get(1), knots.get(2), 1));
		edges.add(new Edge(knots.get(2), knots.get(1), 1));
		edges.add(new Edge(knots.get(2), knots.get(10), 10));
		edges.add(new Edge(knots.get(2), knots.get(5), 5));
		edges.add(new Edge(knots.get(3), knots.get(0), 11));
		edges.add(new Edge(knots.get(3), knots.get(4), 7));
		edges.add(new Edge(knots.get(3), knots.get(6), 2));
		edges.add(new Edge(knots.get(4), knots.get(9), 1));
		edges.add(new Edge(knots.get(4), knots.get(1), 4));
		edges.add(new Edge(knots.get(4), knots.get(10), 3));
		edges.add(new Edge(knots.get(4), knots.get(5), 12));
		edges.add(new Edge(knots.get(4), knots.get(12), 8));
		edges.add(new Edge(knots.get(4), knots.get(7), 13));
		edges.add(new Edge(knots.get(4), knots.get(11), 9));
		edges.add(new Edge(knots.get(4), knots.get(3), 7));
		edges.add(new Edge(knots.get(5), knots.get(2), 5));
		edges.add(new Edge(knots.get(5), knots.get(4), 12));
		edges.add(new Edge(knots.get(5), knots.get(8), 20));
		edges.add(new Edge(knots.get(6), knots.get(3), 2));
		edges.add(new Edge(knots.get(6), knots.get(11), 1));
		edges.add(new Edge(knots.get(6), knots.get(7), 2));
		edges.add(new Edge(knots.get(7), knots.get(6), 2));
		edges.add(new Edge(knots.get(7), knots.get(4), 13));
		edges.add(new Edge(knots.get(7), knots.get(8), 3));
		edges.add(new Edge(knots.get(8), knots.get(7), 3));
		edges.add(new Edge(knots.get(8), knots.get(12), 10));
		edges.add(new Edge(knots.get(8), knots.get(5), 20));
		edges.add(new Edge(knots.get(9), knots.get(0), 1));
		edges.add(new Edge(knots.get(9), knots.get(4), 1));
		edges.add(new Edge(knots.get(10), knots.get(4), 3));
		edges.add(new Edge(knots.get(10), knots.get(2), 10));
		edges.add(new Edge(knots.get(11), knots.get(6), 1));
		edges.add(new Edge(knots.get(11), knots.get(4), 9));
		edges.add(new Edge(knots.get(12), knots.get(4), 8));
		edges.add(new Edge(knots.get(12), knots.get(8), 10));

		graph = new Graph(knots, edges);

		correctPath.add(knots.get(0));
		correctPath.add(knots.get(9));
		correctPath.add(knots.get(4));
		correctPath.add(knots.get(3));
		correctPath.add(knots.get(6));
		correctPath.add(knots.get(7));
		correctPath.add(knots.get(8));

		Dijkstra dijkstra = new Dijkstra(graph);
		dijkstra.execute(knots.get(0));
		testedPath = dijkstra.getShortestPath(knots.get(0), knots.get(8));

		assertEquals("You haven't found the shortest path yet! Your path doesn't include the right number of knots!", correctPath.size(), testedPath.size());

		if (correctPath.size() == testedPath.size())
			for (int i = 0; i < correctPath.size(); i++) {
				assertEquals("You haven't found the shortest path yet! Knot Nr. " + i + " is incorrect!", correctPath.get(i), testedPath.get(i));
			}
	}

}
