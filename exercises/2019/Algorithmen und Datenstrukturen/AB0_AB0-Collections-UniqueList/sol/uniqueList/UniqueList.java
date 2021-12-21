package uniqueList;

import java.util.*;

public class UniqueList {
  /**
   * convert a list with multiple elements in a list with unique elements
   * @param lst list of elements
   * @return list of new unique elements
   */
    public static <E> List<E> distinct(List<E> lst) {
        return new ArrayList<>(new HashSet<>(lst));
    }
}
