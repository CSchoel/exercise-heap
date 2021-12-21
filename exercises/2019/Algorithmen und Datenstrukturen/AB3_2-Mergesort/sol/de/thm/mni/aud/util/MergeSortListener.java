package de.thm.mni.aud.util;

/**
 * Listener class that can be used to observe the behavior of merge sort implementations for {@link DoublyLinkedList}.
 * @param <E> type of list elements
 */
public interface MergeSortListener<E> {
  /**
   * Should be called when a list is split into two halves.
   * @param left first node of left half
   * @param nLeft number of nodes in left half
   * @param right first node of right half
   * @param nRight number of nodes in right half
   */
  default void split(
    DoublyLinkedList.DoublyLinkedNode<E> left, int nLeft,
    DoublyLinkedList.DoublyLinkedNode<E> right, int nRight) {}

  /**
   * Should be called when a merge of two separate lists is issued.
   * @param left first node of left half
   * @param nLeft number of nodes in left half
   * @param right first node of right half
   * @param nRight number of nodes in right half
   */
  default void startMerge(
    DoublyLinkedList.DoublyLinkedNode<E> left, int nLeft, DoublyLinkedList.DoublyLinkedNode<E> right, int nRight
  ) {}

  /**
   * Should be called when a merge step is finished.
   * @param newStart first node of merged list
   * @param n number of nodes in merged list
   */
  default void finishMerge(
    DoublyLinkedList.DoublyLinkedNode<E> newStart, int n
  ) {}
}
