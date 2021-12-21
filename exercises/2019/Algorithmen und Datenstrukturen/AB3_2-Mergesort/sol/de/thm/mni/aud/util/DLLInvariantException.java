package de.thm.mni.aud.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Exception that reports violations of the class invariant in
 * {@link DoublyLinkedList}.
 */
public class DLLInvariantException extends RuntimeException {
  /**
   * Constructs a new exception with the given errors and traversal strings
   * @param forward forward traversal string
   * @param backward backward traversal string
   * @param errors list of error messages
   */
  public DLLInvariantException(String forward, String backward, List<String> errors) {
    super(String.format(
      "\nForward traversal:  %s\nBackward traversal: %s\n\nERRORS:\n%s",
      forward,
      backward,
      String.join("\n", errors)
    ));
  }
}
