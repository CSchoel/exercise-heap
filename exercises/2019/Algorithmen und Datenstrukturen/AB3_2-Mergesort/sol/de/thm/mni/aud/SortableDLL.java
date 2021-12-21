package de.thm.mni.aud;

import de.thm.mni.aud.util.DoublyLinkedList;
import de.thm.mni.aud.util.MergeSortAdapter;
import de.thm.mni.aud.util.MergeSortListener;

public class SortableDLL<E extends Comparable<E>> extends DoublyLinkedList<E> {

  public void sort() {
    sort(new MergeSortAdapter<>());
  }
  public void sort(MergeSortListener<E> listener) {
    DoublyLinkedNode<E> newFirst = sort(first, size, listener, new DoublyLinkedNode<E>(null));
    DoublyLinkedNode<E> newLast = newFirst;
    if (newLast == null) {
      newLast = null;
    } else {
      while (newLast.hasNext()) { newLast = newLast.next; }
    }
    first = newFirst;
    last = newLast;
  }
  private DoublyLinkedNode<E> sort(
      DoublyLinkedNode<E> left, int len, MergeSortListener<E> listener,
      DoublyLinkedNode<E> dummy
  ) {
    if(len <= 1) return left;
    int middle = len / 2;
    //middle = 1; // FIXME uncomment this and run with -Xss100m to make solution run in O(n²)
    DoublyLinkedNode<E> right = left;
    for(int i = 0; i < middle; i++) {
      right = right.next;
    }
    // split list
    right.prev.next = null;
    right.prev = null;
    int nLeft = middle;
    int nRight = len-middle;
    listener.split(left, nLeft, right, nRight);
    left = sort(left, middle, listener, dummy);
    checkClassInvariant(left, nLeft, false);
    right = sort(right, nRight, listener, dummy);
    checkClassInvariant(right, nRight, false);
    return merge(left, nLeft, right, nRight, listener, dummy);
  }

  private DoublyLinkedNode<E> merge(
      DoublyLinkedNode<E> left, int nLeft, DoublyLinkedNode<E> right,
      int nRight, MergeSortListener<E> listener, DoublyLinkedNode<E> dummy
  ) {
    listener.startMerge(left, nLeft, right, nRight);
    //dummy = new DoublyLinkedNode<>(null); // FIXME uncomment to make merge use O(n) memory
    // start with dummy as first node
    DoublyLinkedNode<E> res = dummy;
    while (left != null && right != null) {
      if (left.content.compareTo(right.content) < 0) {
        DoublyLinkedList.link(res, left);
        res = left;
        left = left.next;
      } else {
        DoublyLinkedList.link(res, right);
        res = right;
        right = right.next;
      }
    }
    if (left != null) { link(res, left); }
    else if (right != null) { link (res, right); }
    res = dummy.next;
    res.prev = null;
    listener.finishMerge(res, nLeft + nRight);
    return res;
  }
}
