package de.thm.mni.aud.util;

import java.util.*;

/**
 * <p>Minimal implementation of a doubly linked list</p>
 *
 * <p>Elements can be added using {@link #append(Object)} and
 * {@link #prepend(Object)} and content can be traversed using
 * {@link #iterator()} and {@link #revIterator()}.</p>
 *
 * <p>This list stores its size in an internal variable that can be
 * accessed in O(1) time using {@link #size()}</p>.
 *
 * <p>Subclasses of this class should ensure that they do not break the
 * following <i>class invariants</i> for internal nodes of the class {@link DoublyLinkedNode}:</p>
 *
 * <ul>
 *     <li><b>Link symmetry:</b> If a node <code>a</code> links to a node <code>a.next == b</code>, then it must
 *     hold that <code>b.prev == a</code>. Equivalently if <code>a.prev == b</code> then it must
 *     hold that <code>b.next == a</code>.</li>
 *     <li><b>First is first:</b> If <code>first != null</code> then ist must hold that <code>first.prev == null</code>.</li>
 *     <li><b>Last is last:</b> If <code>last != null</code> then ist must hold that <code>last.next == null</code>.</li>
 *     <li><b>First to last:</b> The node <code>last</code> must be reachable by following next links from <code>first</code> (and vice versa).</li>
 * </ul>
 *
 * <p>These invariants can be checked using {@link #checkClassInvariant()}, which throws an exception if an invariant is broken.</p>
 * @param <E> type of list elements
 */
public class DoublyLinkedList<E> implements Iterable<E> {
  private static final String ARROW_LEFT = "←";
  private static final String ARROW_RIGHT = "→";
  private static final String ARROW_BOTH = "⇄";
  private static final String INFINITY = "∞";

  /**
   * Traverses the list in backward direction using <code>prev</code> links
   * starting at <code>asLast</code> and builds a string representation
   * that can be used to find violations of the class invariant.
   * @param asFirst node where the (sub-)list starts
   * @param asLast node where the (sub-)list ends
   * @return string representation of the link structure between (sub-)list nodes
   */
  protected String checkBackward(DoublyLinkedNode<E> asFirst, DoublyLinkedNode<E> asLast) {
    if (asLast == null) { return "[]"; }
    StringBuilder sb = new StringBuilder();
    Set<DoublyLinkedNode<E>> visited = new HashSet<>();
    DoublyLinkedNode<E> cur = asLast;
    while (cur != null && !visited.contains(cur)) {
      if (cur == asLast) { sb.append("]"); }
      sb.append(cur.content.toString());
      if (cur == asFirst) { sb.append("["); }
      visited.add(cur);
      if (cur.prev != null) {
        sb.append(cur.prev.next == cur ? ARROW_BOTH : ARROW_LEFT);
      }
      cur = cur.prev;
    }
    if (cur != null) { sb.append(INFINITY); }
    return sb.reverse().toString();
  }

  /**
   * Traverses the list in forward direction using <code>next</code> links
   * starting at <code>asFirst</code> and builds a string representation
   * that can be used to find violations of the class invariant.
   * @param asFirst node where the (sub-)list starts
   * @param asLast node where the (sub-)list ends
   * @return string representation of the link structure between (sub-)list nodes
   */
  protected String checkForward(DoublyLinkedNode<E> asFirst, DoublyLinkedNode<E> asLast) {
    if (asFirst == null) { return "[]"; }
    StringBuilder sb = new StringBuilder();
    Set<DoublyLinkedNode<E>> visited = new HashSet<>();
    DoublyLinkedNode<E> cur = asFirst;
    while (cur != null && !visited.contains(cur)) {
      if (cur == asFirst) { sb.append("["); }
      sb.append(cur.content.toString());
      if (cur == asLast) { sb.append("]"); }
      visited.add(cur);
      if (cur.next != null) {
        sb.append(cur.next.prev == cur ? ARROW_BOTH : ARROW_RIGHT);
      }
      cur = cur.next;
    }
    if (cur != null) { sb.append(INFINITY); }
    return sb.toString();
  }

  /**
   * Same as {@link #checkClassInvariant()} but allows to check only a part
   * of the list, substituting <code>first</code> and <code>last</code>.
   * @param asFirst substitute for first node (if only a part of the list should be checked)
   * @param asLast substitute for last node (if only a part of the list should be checked)
   * @param checkBoundaries if <code>false</code>, <code>first</code> is
   *                        allowed to have a back link and <code>last</code>
   *                        is allowed to have a forward link
   * @throws DLLInvariantException if any of the aforementioned errors is present in the internal node structure
   */
  protected void checkClassInvariant(DoublyLinkedNode<E> asFirst, DoublyLinkedNode<E> asLast, boolean checkBoundaries) throws DLLInvariantException {
    List<String> errors = new ArrayList<>();
    String forward = checkForward(asFirst, asLast);
    String backward = checkBackward(asFirst, asLast);
    if (forward.contains(ARROW_LEFT) || forward.contains(ARROW_RIGHT)) {
      errors.add("Missing or broken backward link");
    }
    if (backward.contains(ARROW_LEFT) || backward.contains(ARROW_RIGHT)) {
      errors.add("Missing or broken forward link");
    }
    if (!forward.endsWith("]") && checkBoundaries) {
      errors.add("Last element has forward link");
    }
    if (!backward.startsWith("[") && checkBoundaries) {
      errors.add("First element has backward link");
    }
    if (!forward.contains("]")) {
      errors.add("Last element cannot be reached by following forward links from first element");
    }
    if (!backward.contains("[")) {
      errors.add("First element cannot be reached by following backward links from last element");
    }
    if (forward.contains(INFINITY)) {
      errors.add("Following forward links leads to an infinite loop");
    }
    if (backward.contains(INFINITY)) {
      errors.add("Following backward links leads to an infinite loop");
    }
    if (!errors.isEmpty()) {
      throw new DLLInvariantException(forward, backward, errors);
    }
  }

  /**
   * <p>Same as {@link #checkClassInvariant(DoublyLinkedNode, DoublyLinkedNode, boolean)}
   * but can find the substitute for <code>last</code> by following forward
   * links from <code>asFirst</code> for <code>nNodes</code> steps.</p>
   *
   * <p>If this methods runs into a <code>null</code> link before
   * <code>nNodes</code> have been traversed, it uses the last node found
   * that was not <code>null</code> as substitute for <code>last</code>.</p>
   *
   * @param asFirst substitute for first node (if only a part of the list should be checked)
   * @param nNodes number of nodes in the list (used to find substitute for <code>last</code>)
   * @param checkBoundaries if <code>false</code>, <code>first</code> is
   *                        allowed to have a back link and <code>last</code>
   *                        is allowed to have a forward link
   */
  protected void checkClassInvariant(DoublyLinkedNode<E> asFirst, int nNodes, boolean checkBoundaries) {
    DoublyLinkedNode<E> asLast = asFirst;
    for(int i = 0; i < nNodes && asLast.hasNext(); i++) { asLast = asLast.next; }
    checkClassInvariant(asFirst, asLast, checkBoundaries);
  }

  /**
   * <p>Checks the class invariants and throws an exception if any problems are encountered.</p>
   *
   * <p>The errors are found by traversing the list in forward and backward
   * direction and transforming it into a string representation.
   * A normal list will look as follows:</p>
   *
   * <pre>[a⇄b⇄c]</pre>
   *
   * <p>Errors can be the following:</p>
   *
   * <ul>
   *     <li>
   *         <p>Broken forward links without matching back links</p>
   *         <code>[a⇄b→c]</code>
   *     </li>
   *     <li>
   *         <p>Broken backward links without matching forward links</p>
   *         <code>[a⇄b←c]</code>
   *     </li>
   *     <li>
   *         <p>Backward link in <code>first</code></p>
   *         <code>x←[a⇄b⇄c]</code>
   *     </li>
   *     <li>
   *         <p>Forward link in <code>last</code></p>
   *         <code>[a⇄b⇄c]→x</code>
   *     </li>
   *     <li>
   *         <p>Last element not reachable by forward links from first element</p>
   *         <code>[a⇄b</code>
   *     </li>
   *     <li>
   *         <p>First element not reachable by backward links from last element</p>
   *         <code>b⇄c]</code>
   *     </li>
   *     <li>
   *         <p>Infinite loop while following forward or backward links</p>
   *         <code>[a⇄b⇄c⇄∞</code>
   *     </li>
   * </ul>
   */
  public void checkClassInvariant() throws DLLInvariantException {
    checkClassInvariant(first, last, true);
  }

  /**
   * Internal node
   * @param <E> type of list elements
   */
  protected final static class DoublyLinkedNode<E> {
    static int counter = 0;
    public E content;
    public DoublyLinkedNode<E> next;
    public DoublyLinkedNode<E> prev;
    public DoublyLinkedNode(E el) {
      content = el;
      counter++;
    }

    /**
     * Checks if this node has a next node
     * @return result of <code>next != null</code>
     */
    public boolean hasNext() { return next != null; }
    /**
     * Checks if this node has a previous node
     * @return result of <code>prev != null</code>
     */
    public boolean hasPrev() { return prev != null; }
  }

  /**
   * Links two nodes, ensuring that <code>left.next == right</code> and <code>right.prev == left</code>
   * @param left left node (can be <code>null</code>)
   * @param right right node (can be <code>null</code>)
   * @param <E> type of list elements
   */
  protected static <E> void link(DoublyLinkedNode<E> left, DoublyLinkedNode<E> right) {
    if (left != null) {
      left.next = right;
    }
    if (right != null) {
      right.prev = left;
    }
  }

  /** first node */
  protected DoublyLinkedNode<E> first;

  /** last node */
  protected DoublyLinkedNode<E> last;

  /** number of nodes in the list */
  protected int size = 0;

  @Override
  public final Iterator<E> iterator() {
    return new Iterator<>() {
      private DoublyLinkedNode<E> cur = first;

      @Override
      public boolean hasNext() {
        return cur != null;
      }

      @Override
      public E next() {
        E res = cur.content;
        cur = cur.next;
        return res;
      }
    };
  }

  /**
   * Like {@link #iterator()} but starts at last element following backward links.
   * @return iterator that traverses from last to first element
   */
  public final Iterator<E> revIterator() {
    return new Iterator<>() {
      private DoublyLinkedNode<E> cur = last;

      @Override
      public boolean hasNext() {
        return cur != null;
      }

      @Override
      public E next() {
        E res = cur.content;
        cur = cur.prev;
        return res;
      }
    };
  }

  /**
   * Appends an element to the end of the list.
   * @param el element to add
   */
  public final void append(E el) {
    DoublyLinkedNode<E> node = new DoublyLinkedNode<>(el);
    link(last, node);
    last = node;
    size++;
    if (size == 1) { first = last; }
  }

  /**
   * Prepends an element to the front of the list.
   * @param el element to add
   */
  public final void prepend(E el) {
    DoublyLinkedNode<E> node = new DoublyLinkedNode<>(el);
    link(node, first);
    first = node;
    size++;
    if (size == 1) { last = first; }
  }

  /**
   * <p>Returns the size of the list.</p>
   * <p>This runs in O(1).</p>
   * @return the number of elements in the list
   */
  public final int size() {
    return size;
  }

  @Override
  public final String toString() {
    List<String> elements = new ArrayList<>();
    for(E el: this) { elements.add(el.toString()); }
    return elements.toString();
  }

  @Override
  public final boolean equals(Object other) {
    if (other == null) return false;
    if (other == this) return true;
    if (!(other instanceof DoublyLinkedList)) return false;
    DoublyLinkedList<?> otherLst = (DoublyLinkedList<?>) other;
    Iterator<?> it1 = iterator();
    Iterator<?> it2 = otherLst.iterator();
    while(it1.hasNext() && it2.hasNext()) {
      Object e1 = it1.next();
      Object e2 = it1.next();
      if (e1 == e2) continue;
      if (e1 == null) return false;
      if (!e1.equals(e2)) return false;
    }
    return !(it1.hasNext() || it2.hasNext());
  }

  @Override
  public final int hashCode() {
    int code = 0;
    for(E el : this) {
      code = code * 31 + el.hashCode();
    }
    return code;
  }
}
