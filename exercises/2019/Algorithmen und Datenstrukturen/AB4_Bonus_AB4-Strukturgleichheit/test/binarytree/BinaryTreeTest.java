
package binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;


import static org.junit.Assert.*;

public class BinaryTreeTest {

    private <E> boolean containsAll(ABinaryTree<E> tree, E ... elem){
      for (E var : elem
           ) {
        if(!tree.contains(var)) return false;
      }
      return true;
    }


    @Test
    public void isIsomorph(){
      ABinaryTree<Integer> myTree = new BinaryTree<>(Comparator.<Integer>naturalOrder());
      ABinaryTree<Integer> otherTree = new BinaryTree<>(Comparator.<Integer>naturalOrder());

      myTree.add(2);
      myTree.add(3);
      myTree.add(4);
      myTree.add(5);
      myTree.add(6);

      assertTrue("The Add-Method or the Contains-Method does not work",containsAll(myTree,2,3,4,5,6));
      assertFalse("The Contains-Method does not work",containsAll(myTree,2,9,4));

      otherTree.add(6);
      otherTree.add(7);
      otherTree.add(8);
      otherTree.add(9);
      otherTree.add(10);

      assertTrue("The Add-Method or the Contains-Method does not work",containsAll(otherTree,6,7,8,9,10));
      assertFalse("The Contains-Method does not work",containsAll(otherTree,2,3,5,2,6));

      assertTrue("The Tree is isomorphic but you say it isn't",myTree.isomorph(otherTree));
    }

  @Test
  public void notIsomorph(){
    ABinaryTree<Integer> myTree = new BinaryTree<>(Comparator.<Integer>naturalOrder());
    ABinaryTree<Integer> otherTree = new BinaryTree<>(Comparator.<Integer>naturalOrder());

    myTree.add(2);
    myTree.add(3);
    myTree.add(4);
    myTree.add(5);
    myTree.add(6);

    assertTrue("The Add-Method or the Contains-Method does not work",containsAll(myTree,2,3,4,5,6));
    assertFalse("The Contains-Method does not work",containsAll(myTree,2,9,4));


    otherTree.add(6);
    otherTree.add(7);
    otherTree.add(8);
    otherTree.add(9);
    otherTree.add(10);
    otherTree.add(11);

    assertTrue("The Add-Method or the Contains-Method does not work",containsAll(otherTree,6,7,8,9,10,11));
    assertFalse("The Contains-Method does not work",containsAll(otherTree,2,3,5,2,6));


    assertFalse("The Tree is not isomorphic but you say it is",myTree.isomorph(otherTree));
  }

}
