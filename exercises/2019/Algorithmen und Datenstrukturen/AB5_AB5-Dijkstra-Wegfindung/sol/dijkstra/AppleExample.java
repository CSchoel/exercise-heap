package dijkstra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AppleExample {

  class Apple{
    Apple(boolean hasWorm){
      worm = hasWorm;
    }
    boolean worm;
  }

  class AppleInfo{
    AppleInfo(int tastiness){
      this.tastiness = tastiness;
    }
    int tastiness;
  }
  Map<Apple,AppleInfo> appleInfo = new HashMap<>();

  void apples(Apple cur){


    Comparator<Apple> appleComparator = Comparator.comparing(apfel -> appleInfo.get(apfel).tastiness);

    PriorityQueue<Apple> queue = new PriorityQueue<Apple>(appleComparator);




    Apple apple1 = new Apple(false);
    appleInfo.put(apple1,new AppleInfo(5));

    queue.offer(apple1);
    queue.poll();

    // Beispiel 1  ----------------------------------------------------

    Apple apple2 = new Apple(true);
    appleInfo.put(apple2,new AppleInfo(3));

    queue.offer(apple2);
    // -> Apfelinfo mit 3 gespeichert
    // -> Queue Apfel mit Wertigkeit "3"

    queue.poll();


    //Beispiel 2 -------------------------------------------------------

    Apple apple3 = new Apple(false);
    appleInfo.put(apple3, new AppleInfo(10));

    queue.offer(apple3);
    // -> Apfel3 mit Wertigkeit 10 gespeichert
    queue.offer(apple1);
    // -> Apfel 1 mit 5
    // -> Apfel 3 mit 10

    appleInfo.get(apple3).tastiness = 2;

    // -> Apfel1 mit 5 gespeichert
    // -> Apfel3 mit... ? gespeichert ! -> Undefinier!

    queue.poll(); // -> Apfel 1 oder 3?

    // Lösung / Sicherheit:

    // Erst ändern -> Dann hinzufügen. Aufpassen bei dem Pseudcode

    queue.remove(apple3);

    // ändern

    queue.offer(apple3);

  }


}
