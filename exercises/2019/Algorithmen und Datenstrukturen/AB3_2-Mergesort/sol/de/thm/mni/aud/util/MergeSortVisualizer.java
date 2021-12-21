package de.thm.mni.aud.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>{@link MergeSortListener} that collects information about split and merge
 * steps as a string of the following form where each line is either the result
 * of a split or a merge operation.</p>
 *
 * <pre>
 * [c, a][f, e]    # <- first set of split operations
 * [c][a][f][e]    # <- second set of split operations
 * [a, c][e, f]    # <- first set of merge operations
 * [a, c, e, f]    # <- second set of merge operations
 * </pre>
 *
 * <p><b>Warning:</b> For large lists this listener may use a lot of memory
 * and processing power. It should only be used for diagnosis on small example
 * lists - preferably with content that is only one character wide.</p>
 * @param <E>
 */
public class MergeSortVisualizer<E> implements MergeSortListener<E> {
  private List<StringBuilder> splitLines = new ArrayList<>();
  private List<StringBuilder> mergeLines = new ArrayList<>();
  private int level = 0;

  @Override
  public void split(DoublyLinkedList.DoublyLinkedNode<E> left, int nLeft, DoublyLinkedList.DoublyLinkedNode<E> right, int nRight) {
    if (splitLines.size() < level + 1) {
      splitLines.add(new StringBuilder());
      mergeLines.add(new StringBuilder());
    }
    appendN(splitLines.get(level), left, nLeft);
    appendN(splitLines.get(level), right, nRight);
    level++;
  }

  private void appendN(StringBuilder sb, DoublyLinkedList.DoublyLinkedNode<E> node, int n) {
    sb.append("[");
    for(int i = 0; i < n-1; i++) {
      sb.append(node.content);
      sb.append(", ");
      node = node.next;
    }
    if (n > 0) { sb.append(node.content); }
    sb.append("]");
  }

  @Override
  public void finishMerge(DoublyLinkedList.DoublyLinkedNode<E> newStart, int n) {
    level--;
    appendN(mergeLines.get(level), newStart, n);
  }

  @Override
  public String toString() {
    List<StringBuilder> mergeRev = new ArrayList<StringBuilder>(mergeLines);
    Collections.reverse(mergeRev);
    return String.join("\n", splitLines) + "\n" + String.join("\n", mergeRev);
  }
}
