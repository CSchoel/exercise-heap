package basilist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.junit.Test;

public final class DoublyLinkedListTest {

	/* GenericBasilist::get */

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test1() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.get(0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test2() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test3() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.get(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test4() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.get(Integer.MIN_VALUE);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test5() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.get(Integer.MAX_VALUE);
	}

	@Test
	public final void get_test6() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("hello world");
		assertEquals("hello world", list.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test7() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("hello world");
		list.get(-1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test8() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("hello world");
		list.get(1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test9() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("hello world");
		list.get(Integer.MIN_VALUE);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void get_test10() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("hello world");
		list.get(Integer.MAX_VALUE);
	}

	@Test
	public final void get_test11() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		final int start = -200;
		final int end = 200;

		IntStream.range(start, end + 1 /* exclusively */).forEach(list::add);

		int sum = 0;
		for (int i = 0, len = list.size(); i < len; i++) {
			sum += list.get(i);
		}

		assertEquals(0, sum);
	}

	@Test
	public final void get_test12() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		final int start = 1;
		final int end = 200;

		IntStream.range(start, end + 1 /* exclusively */).forEach(list::add);

		int sum = 0;
		for (int i = 0, len = list.size(); i < len; i++) {
			sum += list.get(i);
		}

		final int gaussianSum = (end * end + end) / 2;


		assertEquals(gaussianSum, sum);
	}

	/* GenericBasilist::set */

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test1() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test2() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test3() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test4() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", Integer.MIN_VALUE);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test5() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", Integer.MAX_VALUE);
	}

	@Test
	public final void set_test6() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("hello world");
		list.set("world hello", 0);
		assertEquals("world hello", list.get(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test7() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", -1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test8() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test9() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", Integer.MIN_VALUE);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test10() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.set("", Integer.MAX_VALUE);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public final void set_test11() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);
		IntStream.range(0, 200).forEach(i -> list.set(i, -1));

		int sum = 0;
		for (int i = 0, len = list.size(); i < len; i++) {
			sum += list.get(i);
		}

		assertEquals(-200, sum);
	}

	/* GenericBasilist::size */

	@Test
	public final void size_test1() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		assertEquals(0, list.size());
	}

	@Test
	public final void size_test2() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		list.add(0);
		assertEquals(1, list.size());
	}

	@Test
	public final void size_test3() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		list.add(0);
		list.remove(0);
		assertEquals(0, list.size());
	}

	@Test
	public final void size_test4() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);
		assertEquals(200, list.size());
	}

	@Test
	public final void size_test5() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);
		IntStream.range(50, 125).forEach(list::remove);
		assertEquals(125, list.size());
		IntStream.range(0, 75).forEach(list::add);
		assertEquals(200, list.size());
		IntStream.range(0, 200).forEach(i -> list.remove(0));
		assertEquals(0, list.size());
	}

	@Test
	public final void size_test6() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);
		final Random random = new Random();
		int cnt = 200;
		while (cnt > 0) {
			list.remove(random.nextInt(list.size()));
			assertEquals(--cnt, list.size());
		}
	}

	/* GenericBasilist::add */

	@Test
	public final void add_test1() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("heLlO wOrLD");
		assertEquals("heLlO wOrLD", list.get(0));
	}

	@Test
	public final void add_test2() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(i -> list.add("" + i));
		list.add("heLlO wOrLD");
		assertEquals("heLlO wOrLD", list.get(list.size() - 1));
	}

	@Test
	public final void add_test3() {
		GenericBasilist<String> list = new DoublyLinkedBasilist<>();
		list.add("heLlO wOrLD");
		IntStream.range(0, 200).forEach(i -> list.add("" + i));
		assertEquals("heLlO wOrLD", list.get(0));
	}

	/* GenericBasilist::remove */

	@Test
	public final void remove_test1() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);
		while (list.size() > 0) {
			assertEquals(200 - list.size(), list.get(0).intValue());
			list.remove(0);
		}
	}

	@Test
	public final void remove_test2() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);
		final int index = new Random().nextInt(200);
		list.remove(index);

		IntStream.range(0, index).forEach(i -> {
			assertEquals(i, list.get(i).intValue());
		});

		IntStream.range(index, 199).forEach(i -> {
			assertEquals(i + 1, list.get(i).intValue());
		});

		try {
			list.get(199);
			fail();
		} catch (final IndexOutOfBoundsException e) {
			return;
		} catch (final Throwable t) {
			fail();
		}
	}

	/* GenericBasilist::insert */

	@Test
	public final void insert_test1() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(i -> list.insert(i * 2, 0));
		IntStream.range(0, 200).forEach(i -> assertEquals((199 - i) * 2, list.get(i).intValue()));
	}

	@Test
	public final void insert_test2() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(i -> list.insert(i * 2, i));
		IntStream.range(0, 200).forEach(i -> assertEquals(i * 2, list.get(i).intValue()));
	}

	@Test
	public final void insert_test3() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		final Random random = new Random();
		while (list.size() < 200) {
			final int index = random.nextInt(list.size() + 1);
			list.insert(index, index);
			IntStream.range(index + 1, list.size()).forEach(i -> list.set(list.get(i) + 1, i));
		}
		IntStream.range(0, 200).forEach(i -> assertEquals(i, list.get(i).intValue()));
	}

	/* GenericBasilist::map */

	@Test
	public final void map_test1() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);

		GenericBasilist<Integer> nlist = list.map(String::valueOf).map(s -> Integer.parseInt(s, 16));
		IntStream.range(0, 200).forEach(i -> assertEquals(Integer.parseInt("" + i, 16), nlist.get(i).intValue()));
	}

	@Test
	public final void map_test2() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);

		GenericBasilist<Integer> nlist = list.map(i -> {
			GenericBasilist<Integer> sub = new DoublyLinkedBasilist<>();
			IntStream.range(0, i).forEach(sub::add);
			return sub;
		}).map(sub -> {
			int sum = 0;
			for (int i = 0, len = sub.size(); i < len; i++) {
				sum += sub.get(i);
			}
			return sum;
		});

		assertEquals(0, nlist.get(0).intValue());
		nlist.remove(0);

		int[] triangularNumbers = IntStream.range(0, nlist.size()).map(n -> (n * n + n) / 2).toArray();
		for (int i = 0; i < triangularNumbers.length; i++) {
			assertEquals(triangularNumbers[i], nlist.get(i).intValue());
		}
	}

	/* GenericBasilist::reverseMap */

	@Test
	public final void reverseMap_test1() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);

		GenericBasilist<Integer> nlist = list.reverseMap(String::valueOf).reverseMap(s -> Integer.parseInt(s, 16));
		IntStream.range(0, 200).forEach(i -> assertEquals(Integer.parseInt("" + i, 16), nlist.get(i).intValue()));
	}

	@Test
	public final void reverseMap_test2() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);

		GenericBasilist<Integer> nlist = list.reverseMap(i -> {
			GenericBasilist<Integer> sub = new DoublyLinkedBasilist<>();
			IntStream.range(0, i).forEach(sub::add);
			return sub;
		}).reverseMap(sub -> {
			int sum = 0;
			for (int i = 0, len = sub.size(); i < len; i++) {
				sum += sub.get(i);
			}
			return sum;
		});

		assertEquals(0, nlist.get(0).intValue());
		nlist.remove(0);

		int[] triangularNumbers = IntStream.range(0, nlist.size()).map(n -> (n * n + n) / 2).toArray();
		for (int i = 0; i < triangularNumbers.length; i++) {
			assertEquals(triangularNumbers[i], nlist.get(i).intValue());
		}
	}

	@Test
	public final void reverseMap_test3() {
		GenericBasilist<Integer> list = new DoublyLinkedBasilist<>();
		IntStream.range(0, 200).forEach(list::add);
		final AtomicInteger cnt = new AtomicInteger(0);
		list.reverseMap(i -> {
			assertEquals(199 - cnt.get(), i.intValue());
			cnt.incrementAndGet();
			return i;
		});
	}

}
