package hashables.test;

import hashables.Gene;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeneTest extends HashableTest {
    private List<Gene> simpleGenes = List.of(
            new Gene("acgt"),
            new Gene("acgt"),
            new Gene("tgca"),
            new Gene("ACGT"),
            new Gene("TGCA"),
            new Gene("aCgT")
    );

    private Gene randomGene() {
        Random r = new Random();
        char[] seq = new char[10];
        for(int i = 0; i < seq.length; i++) {
            switch(r.nextInt(4)) {
                case 0: seq[i] = 'a'; break;
                case 1: seq[i] = 'c'; break;
                case 2: seq[i] = 'g'; break;
                case 3: seq[i] = 't'; break;
            }
        }
        return new Gene(new String(seq));
    }
    @Test
    public void g01_toString() {
        assertEquals("acgt", new Gene("acgt").toString());
        assertEquals("acgt", new Gene("ACGT").toString());
    }
    @Test
    public void g02_equals() {
        assertAllEqual(simpleGenes);
        assertShouldNotEqual(new Gene("acgt"), new Gene("acgtt"));
        assertShouldNotEqual(new Gene("accc"), new Gene("attt"));
        assertShouldNotEqual(new Gene("agcga"), new Gene("tccct"));
    }
    @Test
    public void g03_hashCodeFitsEquals() {
        assertAllHashesEqual(simpleGenes);
    }
    @Test
    public void g04_collisionsAcceptable() {
        testHashCollisions(this::randomGene, 100000, 100, 10);
    }
    @Test
    public void g05_collisionsOptimal() {
        testHashCollisions(this::randomGene, 100000, 5, 2);
    }
}
