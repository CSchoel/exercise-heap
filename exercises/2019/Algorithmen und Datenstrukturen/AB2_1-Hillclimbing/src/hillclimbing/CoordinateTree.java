package hillclimbing;

import java.util.ArrayList;
import java.util.List;

public class CoordinateTree {
    private List<CoordinateTree> children = new ArrayList<>();
    public final CoordinateTree parent;
    public final Coordinate content;

    public CoordinateTree(CoordinateTree parent, Coordinate content) {
        this.parent = parent;
        this.content = content;
    }

    public boolean beenThere(Coordinate coordinate) {
        if (parent == null) return false;
        return coordinate.equals(content) || parent.beenThere(coordinate);
    }

    public CoordinateTree addChild(CoordinateTree child) {
        children.add(child);
        return this;
    }

    public CoordinateTree getChild(Coordinate childCoordinates) {
        if (childCoordinates.equals(content)) return this;
        for (CoordinateTree tree : children) {
            if (tree.content.equals(childCoordinates))
                return tree;
        }
        return null;
    }
}
