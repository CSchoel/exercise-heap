package hashables;

import java.text.MessageFormat;
import java.util.Objects;

public class Tile {
    public enum Type { LAND, WATER, ROCK }
    private Type type;
    private String region;
    private short x,y;
    public Tile(Type type, String region, short x, short y) {
        this.type = type;
        this.region = region;
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != getClass()) return false;
        Tile otherTile = (Tile) other;
        return region.equals(otherTile.region) && x == otherTile.x && y == otherTile.y;
    }
    public String toString() {
        return MessageFormat.format("{0}({1},{2}) in {3}", type.name().charAt(0), x, y, region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, x * 101027, y);
    }
}
