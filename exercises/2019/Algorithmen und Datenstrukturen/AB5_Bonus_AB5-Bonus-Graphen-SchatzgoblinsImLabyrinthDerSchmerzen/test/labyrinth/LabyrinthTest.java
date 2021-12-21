package labyrinth;

import de.thm.mni.aud.commons.AbstractFileIOTest;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by glasen on 20.06.17.
 */
public class LabyrinthTest extends AbstractFileIOTest {

    public LabyrinthTest() {
        super("labyrinth_noRoom.txt", "labyrinth_mini.txt", "labyrinth_small.txt", "labyrinth_10_10.txt", "labyrinth_20_20.txt", "labyrinth_100_100.txt");
    }

    @Test
    public void noRoomLabyrinth() throws IOException {

        List<String> noRoomText = Files.readAllLines(Paths.get("labyrinth_noRoom.txt"));
        final Labyrinth noRoomLab = new Labyrinth(noRoomText);

        List<Integer> roomList = GoblinDresche.findeDenGoblin(noRoomLab, 3);
        Set<Integer> roomSet = new HashSet<Integer>(roomList);
        List<Integer> correctRoomList = new ArrayList<>();
        Set<Integer> compareSet = new HashSet<Integer>(correctRoomList);

        assertEquals(compareSet,roomSet);
    }

    
    @Test
    public void miniLabyrinth() throws IOException {

        List<String> miniText = Files.readAllLines(Paths.get("labyrinth_mini.txt"));
        final Labyrinth miniLab = new Labyrinth(miniText);

        List<Integer> roomList = GoblinDresche.findeDenGoblin(miniLab, 3);
        Set<Integer> roomSet = new HashSet<Integer>(roomList);
        List<Integer> correctRoomList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 6));
        Set<Integer> compareSet = new HashSet<Integer>(correctRoomList);

        assertEquals(compareSet,roomSet);
    }


    @Test
    public void smallLabyrinth() throws IOException {

        final List<String> smallText = Files.readAllLines(Paths.get("labyrinth_small.txt"));
        final Labyrinth smallLab = new Labyrinth(smallText);

        final List<Integer> roomList = GoblinDresche.findeDenGoblin(smallLab, 5);
        final Set<Integer> roomSet = new HashSet<Integer>(roomList);
        final List<Integer> correctRoomList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,8,9));
        final Set<Integer> compareSet = new HashSet<Integer>(correctRoomList);

        assertEquals(compareSet,roomSet);
    }

    @Test
    public void Labyrinth10() throws IOException {

        final List<String> tenText = Files.readAllLines(Paths.get("labyrinth_10_10.txt"));
        final Labyrinth tenLab = new Labyrinth(tenText);

        final List<Integer> roomList = GoblinDresche.findeDenGoblin(tenLab, 10);
        final Set<Integer> roomSet = new HashSet<Integer>(roomList);
        final List<Integer> correctRoomList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,9,10,12,13,14,15,16,17,18,
                21,22,25,28
        ));
        final Set<Integer> compareSet = new HashSet<Integer>(correctRoomList);

        assertEquals(compareSet,roomSet);
    }


    @Test
    public void Labyrinth20() throws IOException {

        final List<String> TwentyText = Files.readAllLines(Paths.get("labyrinth_20_20.txt"));
        final Labyrinth TwentyLab = new Labyrinth(TwentyText);

        final List<Integer> roomList = GoblinDresche.findeDenGoblin(TwentyLab, 30);
        final Set<Integer> roomSet = new HashSet<Integer>(roomList);
        final List<Integer> correctRoomList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,18,19,20,21,24,25,
                26,27,28,29,30,31,32,38,39,43,44,45,46,47,48,49,50,51,52,
                58,59,60,61,66,67,68,69,70,71,72,73,74,79,80,84,85,86,87,
                88,89,90,91,92,93,99,108,109,110
        ));
        final Set<Integer> compareSet = new HashSet<Integer>(correctRoomList);

        assertEquals(compareSet,roomSet);
    }



    @Test
    public void Labyrinth100() throws IOException {

        final List<String> oneHundredText = Files.readAllLines(Paths.get("labyrinth_100_100.txt"));
        final Labyrinth oneHundredLab = new Labyrinth(oneHundredText);

        final List<Integer> roomList = GoblinDresche.findeDenGoblin(oneHundredLab, 60);
        final Set<Integer> roomSet = new HashSet<Integer>(roomList);
        final List<Integer> correctRoomList = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,89,
                90,91,92,93,94,117,118,119,120,121,122,123,124,125,126,
                127,128,129,185,186,187,188,218,219,220,221,222,223,224,
                225,226,227,228,229,230,231,232,233,234,291,292,293,294,
                313,314,315,316,317,318,319,320,321,322,323,324,325,326,
                329,387,388,389,390,391,392,393,394,395,414,415,416,417,
                418,419,420,421,422,423,424,425,426,427,428,429,430,431,
                491,492,493,494,495,496,511,512,513,514,515,516,517,518,
                519,520,521,522,523,524,525,589,590,591,592,613,614,615,
                616,617,618,619,620,621,622,623,624,625,626,689,690,691,
                692,693,694,695,696,697,719,720,721,722,723,724,725,727,
                728,729,730,731,789,791,814,815,816,817,827,828,829,890,
                891,912,913,914,915,916,988,989,990,1015,1016,1017,1018,
                1019,1020,1094,1095,1114,1115,1116,1117,1118,1119,1191,
                1192,1193,1214,1215,1216,1217,1218,1289,1290,1319,1320,
                1321,1322,1323,1393,1421,1422,1423,1424,1493,1494,1520,
                1521,1522,1596,1621,1692,1719,1720,1721,1722,1723,1724,
                1725
                ));
        final Set<Integer> compareSet = new HashSet<Integer>(correctRoomList);

        assertEquals(compareSet,roomSet);
    }

}

