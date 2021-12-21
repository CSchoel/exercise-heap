package cycles;

import static org.junit.Assert.*;

import java.util.stream.IntStream;

import cycles.abstractGraph.AbstractGraph;
import org.junit.Test;

public final class GraphTest {

	/* ***** cycles ***** */
	
	@Test
	public void test_cycle_1() {		
		final AbstractGraph<String> graph = new Graph<>();
		graph.addKnot("hello world");
		graph.connect("hello world", "hello world");
		assertTrue(graph.hasCycles());
	}
	
	@Test
	public void test_cycle_2() {		
		final AbstractGraph<Integer> graph = new Graph<>();
		IntStream.range(0, 100).forEach(graph::addKnot);
		IntStream.range(1, 100).forEach(i -> graph.connect(i - 1, i));
		graph.connect(99, 0);
		assertTrue(graph.hasCycles());
	}
	
	@Test
	public void test_cycle_3() {		
		final AbstractGraph<String> graph = new Graph<>();
		graph.addKnot("a");
		graph.addKnot("b");
		graph.addKnot("c");
		graph.connect("a", "b");
		graph.connect("b", "c");
		graph.connect("c", "a");
		assertTrue(graph.hasCycles());
	}
	
	@Test
	public void test_cycle_4() {		
		final AbstractGraph<String> graph = new Graph<>();
		IntStream.range(0, 26).forEach(c -> graph.addKnot("" + (char) (c + 'a')));
		IntStream.range(1, 26).forEach(c -> graph.connect("" + (char) ((c - 1) + 'a'), "" + (char) (c + 'a')));
		graph.connect("o", "w");
		graph.connect("o", "q");
		graph.connect("o", "o");
		assertTrue(graph.hasCycles());
	}

  @Test
  public void test_cycle_5() {
    final AbstractGraph<String> graph = new Graph<>();
    IntStream.range(0, 26).forEach(c -> graph.addKnot("" + (char) (c + 'a')));
    IntStream.range(1, 20).forEach(c -> graph.connect("" + (char) ((c - 1) + 'a'), "" + (char) (c + 'a')));
    graph.connect("o", "w");
    graph.connect("o", "q");
    graph.connect("o", "o");
    assertTrue(graph.hasCycles());
  }

	
	/* ***** no cycles ***** */
	
	@Test
	public void test_no_cycle_1() {		
		final AbstractGraph<String> graph = new Graph<>();
		graph.addKnot("hello world");
		graph.addKnot("world hello");
		graph.connect("hello world", "world hello");
		assertFalse(graph.hasCycles());
	}
	
	@Test
	public void test_no_cycle_2() {		
		final AbstractGraph<Integer> graph = new Graph<>();
		IntStream.range(0, 100).forEach(graph::addKnot);
		IntStream.range(1, 100).forEach(i -> graph.connect(i - 1, i));
		assertFalse(graph.hasCycles());
	}
	
	@Test
	public void test_no_cycle_3() {		
		final AbstractGraph<Integer> graph = new Graph<>();
		graph.addKnot(0);
		assertFalse(graph.hasCycles());
	}
	
	@Test
	public void test_no_cycle_4() {		
		final AbstractGraph<Integer> graph = new Graph<>();
		assertFalse(graph.hasCycles());
	}

	@Test
  public void test_no_cycle_5() {
    final AbstractGraph<String> graph = new Graph<>();
    IntStream.range(0, 26).forEach(c -> graph.addKnot("" + (char) (c + 'a')));
    IntStream.range(1, 20).forEach(c -> graph.connect("" + (char) ((c - 1) + 'a'), "" + (char) (c + 'a')));
    assertFalse(graph.hasCycles());
  }

  @Test
  public void treeTest_Cycle(){
    final AbstractGraph<Integer> graph = new Graph<>();
    IntStream.range(0, 15).forEach(graph::addKnot);

    //0 ist root
    ///1,2,3 erste ebene

    graph.connect(0,1);
    graph.connect(0,2);
    graph.connect(0,3);

    graph.connect(1,4);
    graph.connect(1,5);
    graph.connect(1,6);

    graph.connect(2,7);
    graph.connect(2,8);
    graph.connect(2,9);
    graph.connect(2,10);

    graph.connect(3,11);
    graph.connect(3,12);

    graph.connect(5,9);

    assertTrue(graph.hasCycles());

  }

  @Test
  public void treeTest_No_Cycle(){
    final AbstractGraph<Integer> graph = new Graph<>();
    IntStream.range(0, 15).forEach(graph::addKnot);

    //0 ist root
    ///1,2,3 erste ebene

    graph.connect(0,1);
    graph.connect(0,2);
    graph.connect(0,3);

    graph.connect(1,4);
    graph.connect(1,5);
    graph.connect(1,6);

    graph.connect(2,7);
    graph.connect(2,8);
    graph.connect(2,9);
    graph.connect(2,10);

    graph.connect(3,11);
    graph.connect(3,12);

    assertFalse(graph.hasCycles());

  }
	
}
