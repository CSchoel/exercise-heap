package hashables;

import java.text.MessageFormat;
import java.util.Objects;

public class Interval {
    private double min, max;
    private boolean minOpen, maxOpen;
    public Interval(double min, double max, boolean minOpen, boolean maxOpen) {
        this.min = min;
        this.max = max;
        this.minOpen = minOpen;
        this.maxOpen = maxOpen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(min == -0.0 ? 0.0 : min, max == -0.0 ? 0.0 : max, minOpen, maxOpen);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Interval otherInterval = (Interval) other;
        return otherInterval.min == min && otherInterval.max == max &&
                minOpen == otherInterval.minOpen &&
                maxOpen == otherInterval.maxOpen;
    }

    public String toString() {
        return MessageFormat.format("{0}{1}, {2}{3}", minOpen ? "(" : "[", Double.toString(min), Double.toString(max), maxOpen ? ")" : "]");
    }
}
