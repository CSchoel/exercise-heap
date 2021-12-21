package hashables.test;

import hashables.Tile;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TileTest extends HashableTest {
    private List<Tile> simpleTiles = List.of(
            new Tile(Tile.Type.LAND, "Basihara", (short)100, (short)17),
            new Tile(Tile.Type.LAND, "Basihara", (short)100, (short)17),
            new Tile(Tile.Type.WATER, "Basihara", (short)100, (short)17),
            new Tile(Tile.Type.ROCK, "Basihara", (short)100, (short)17)
    );

    private List<String> regions = List.of(
            "Basihara", "Wald der Speichereichen", "Ströme der Bequemlichkeit", "Highlands", "Der schiefe Berg"
    );
    private Tile randomTile() {
        Random r = new Random();
        return new Tile(
                Tile.Type.values()[r.nextInt(Tile.Type.values().length)],
                regions.get(r.nextInt(regions.size())),
                (short)r.nextInt(1000),
                (short)r.nextInt(1000)
        );
    }
    @Test
    public void t01_toString() {
        assertEquals("R(1,1) in Basihara", new Tile(Tile.Type.ROCK, "Basihara", (short)1, (short)1).toString());
        assertEquals("L(1,1) in Basihara", new Tile(Tile.Type.LAND, "Basihara", (short)1, (short)1).toString());
        assertEquals("W(1,1) in Basihara", new Tile(Tile.Type.WATER, "Basihara", (short)1, (short)1).toString());
        assertEquals("W(135,544) in Highlands", new Tile(Tile.Type.WATER, "Highlands", (short)135, (short)544).toString());
    }
    @Test
    public void t02_equals() {
        assertAllEqual(simpleTiles);
        assertShouldNotEqual(
                new Tile(Tile.Type.LAND, "Basihara", (short)5, (short)18),
                new Tile(Tile.Type.LAND, "Highlands", (short)5, (short)18)
        );
        assertShouldNotEqual(
                new Tile(Tile.Type.LAND, "Basihara", (short)5, (short)18),
                new Tile(Tile.Type.LAND, "Basihara", (short)5, (short)180)
        );
        assertShouldNotEqual(
                new Tile(Tile.Type.ROCK, "Basihara", (short)5, (short)18),
                new Tile(Tile.Type.ROCK, "Basihara", (short)0, (short)18)
        );
    }
    @Test
    public void t03_hashCodeFitsEquals() {
        assertAllHashesEqual(simpleTiles);
    }
    @Test
    public void t04_collisionsAcceptable() {
        testHashCollisions(this::randomTile, 100000, 100, 10);
    }
    @Test
    public void t05_collisionsOptimal() {
        testHashCollisions(this::randomTile, 100000, 0, 1);
    }
}
