package damenproblem;

public enum Direction {
    NORTH, NORTHEAST, EAST, SOUTHEAST, SOUTH, SOUTHWEST, WEST, NORTHWEST;

    public int[] getModifiers() {
        switch (this) {
            case NORTH:
                return new int[]{0, -1};
            case NORTHEAST:
                return new int[]{1, -1};
            case EAST:
                return new int[]{1, 0};
            case SOUTHEAST:
                return new int[]{1, 1};
            case SOUTH:
                return new int[]{0, 1};
            case SOUTHWEST:
                return new int[]{-1, 1};
            case WEST:
                return new int[]{-1, 0};
            case NORTHWEST:
                return new int[]{-1, -1};
            default:
                throw new IllegalArgumentException();
        }
    }
}
