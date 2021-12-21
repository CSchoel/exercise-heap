package hashables.test;

import java.text.MessageFormat;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class HashableTest {
    protected void testHashCollisions(Supplier<Object> randomObject, int n, int maxTotal, int maxPerCode) {
        Map<Integer,Set<Object>> byHash = collectByHash(randomObject, n);
        List<Integer> keys = new ArrayList<>(byHash.keySet());
        Optional<Integer> maxCollisionIndexOpt = IntStream.range(0, keys.size()).boxed()
                .max(Comparator.comparing(i -> byHash.get(keys.get(i)).size()));
        if (!maxCollisionIndexOpt.isPresent()) fail("empty results");
        int maxCollisionIndex = maxCollisionIndexOpt.get();
        int maxCollisionHash = keys.get(maxCollisionIndex);
        Set<Object> maxCollisions = byHash.get(maxCollisionHash);
        int sumCollisions = byHash.values().stream().filter(x -> x.size() > 1).mapToInt(x -> x.size() - 1).sum();
        String mostColl = MessageFormat.format(
                "there was a group of {0,number} objects with the same hash code: {1}",
                maxCollisions.size(),
                maxCollisions
        );
        assertTrue(
                MessageFormat.format(
                        "Expected at most {0,number} elements to have the same hash code, but {1}.",
                        maxPerCode, mostColl),
                maxCollisions.size() <= maxPerCode);
        assertTrue(
                MessageFormat.format(
                        "Expected at most {0,number} collisions in total, but got {1,number}. At max, {2}.",
                        maxTotal, sumCollisions, mostColl),
                sumCollisions <= maxTotal);
    }
    private Map<Integer,Set<Object>> collectByHash(Supplier<Object> randomObject, int n) {
        Object[] objects = Stream.generate(randomObject).limit(n).toArray();
        Map<Integer,Set<Object>> hashes = new HashMap<>();
        for(Object o : objects) {
            int h = o.hashCode();
            hashes.putIfAbsent(h, new HashSet<>());
            hashes.get(h).add(o);
        }
        return hashes;
    }
    protected void assertAllEqual(List<?> equalObjects) {
        for(Object a: equalObjects) {
            for(Object b: equalObjects) {
                assertShouldEqual(a, b);
            }
        }
    }
    protected void assertShouldNotEqual(Object a, Object b) {
        // Note: we do not use assertEquals, because that would give misleading error messages
        if (a.equals(b) || b.equals(a)) fail(a+" and "+b+" should not be equal.");
    }
    protected void assertShouldEqual(Object a, Object b) {
        // Note: we do not use assertEquals, because that would give misleading error messages
        if (!a.equals(b) || !b.equals(a)) fail(a+" and "+b+" should be equal.");
    }
    protected void assertAllHashesEqual(List<?> equalObjects) {
        for(Object a: equalObjects) {
            for(Object b: equalObjects) {
                // Note: we do not use assertEquals, because that would give misleading error messages
                assertHashEquals(a, b);
            }
        }
    }
    protected void assertHashEquals(Object a, Object b) {
        if (!(a.hashCode() == b.hashCode())) {
            fail(MessageFormat.format("{0} (hash: {2,number}) and {1} (hash: {3,number}) should have the same hash code", a, b, a.hashCode(), b.hashCode()));
        }
    }
}
