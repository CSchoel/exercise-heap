package hashables;

public class Gene {
    private String seq;
    public Gene(String seq) {
        this.seq = seq.toLowerCase();
    }
    public boolean equals(Object other) {
        if(other == this) return true;
        if(other == null) return false;
        if(other.getClass() != getClass()) return false;
        Gene otherSequence = (Gene) other;
        if (seq.equals(otherSequence.seq)) return true;
        return complement().seq.equals(otherSequence.seq);
    }
    private Gene complement() {
        char[] res = new char[seq.length()];
        for(int i = 0; i < res.length; i++) {
            switch(seq.charAt(i)) {
                case 'a': res[i] = 't'; break;
                case 't': res[i] = 'a'; break;
                case 'c': res[i] = 'g'; break;
                case 'g': res[i] = 'c'; break;
            }
        }
        return new Gene(new String(res));
    }
    public String toString() {
        return seq;
    }
    public int hashCode() {
        if(seq.length() == 0 || seq.charAt(0) == 'a' || seq.charAt(0) == 'c') {
            return seq.hashCode();
        } else {
            return complement().seq.hashCode();
        }
    }
}
