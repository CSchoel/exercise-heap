package basilist;

import java.util.function.Function;

public final class DoublyLinkedBasilist<A> implements GenericBasilist<A> {
	private List<A> first = null;
	private List<A> last = null;

	private static final class List<E> {
		private E value;
		private List<E> prev = null;
		private List<E> next = null;

		@Override
		public final int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public final boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (!(obj instanceof List)) {
				return false;
			}
			final List<?> other = (List<?>) obj;
			if (next == null) {
				if (other.next != null) {
					return false;
				}
			} else if (!next.equals(other.next)) {
				return false;
			}
			if (value == null) {
				if (other.value != null) {
					return false;
				}
			} else if (!value.equals(other.value)) {
				return false;
			}
			return true;
		}

	}

	@Override
	public final A get(final int idx) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		List<A> l = first;
		int i = idx;
		while (l != null && i > 0) {
			i--;
			l = l.next;
		}
		if (l == null) {
			throw new IndexOutOfBoundsException();
		}
		return l.value;
	}

	@Override
	public final void set(final A el, final int idx) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		List<A> l = first;
		int i = idx;
		while (l != null && i > 0) {
			i--;
			l = l.next;
		}
		if (l == null) {
			throw new IndexOutOfBoundsException();
		}
		l.value = el;
	}

	@Override
	public final int size() {
		List<A> l = first;
		int length = 0;
		while (l != null) {
			length++;
			l = l.next;
		}
		return length;
	}

	@Override
	public final void add(final A el) {
		if (first == null) {
			first = last = new List<>();
		} else if (first == last) {
			first.next = last = new List<>();
			last.prev = first;
		} else {
			last.next = new List<>();
			last.next.prev = last;
			last = last.next;
		}
		last.value = el;
	}

	@Override
	public final void remove(final int idx) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		List<A> l = first;
		int i = idx;
		while (l != null && i > 0) {
			i--;
			l = l.next;
		}
		if (l == null) {
			throw new IndexOutOfBoundsException();
		}

		if (l.prev != null) {
			l.prev.next = l.next;
		}
		if (l.next != null) {
			l.next.prev = l.prev;
		}
		if (l == first) {
			first = l.next;
		}
		if (l == last) {
			last = l.prev;
		}
	}

	@Override
	public final void insert(final A el, final int idx) {
		if (idx < 0) {
			throw new IndexOutOfBoundsException();
		}
		List<A> l = first;
		int i = idx;
		while (l != null && i > 0) {
			i--;
			l = l.next;
		}

		if (l == null) {
			if (i == 0) {
				add(el);
				return;
			} else {
				throw new IndexOutOfBoundsException();
			}
		}

		final List<A> n = new List<>();
		n.value = el;

		n.next = l;
		n.prev = l.prev;
		l.prev = n;
		if (n.prev != null) {
			n.prev.next = n;
		}

		if (l == first) {
			first = n;
		}

	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		return result;
	}

	@Override
	public final boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof DoublyLinkedBasilist)) {
			return false;
		}
		final DoublyLinkedBasilist<?> other = (DoublyLinkedBasilist<?>) obj;
		if (first == null) {
			if (other.first != null) {
				return false;
			}
		} else if (!first.equals(other.first)) {
			return false;
		}
		return true;
	}

	@Override
	public final String toString() {
		final StringBuilder result = new StringBuilder("[");
		List<A> l = first;
		while (l != null) {
			if (l != first) {
				result.append(", ");
			}
			result.append(l.value);
			l = l.next;
		}

		result.append("]");
		return result.toString();
	}

	@Override
	public <B> GenericBasilist<B> map(Function<A, B> f) {
		DoublyLinkedBasilist<B> result = new DoublyLinkedBasilist<>();
		List<A> l = first;
		while (l != null) {
			result.add(f.apply(l.value));
			l = l.next;
		}
		return result;
	}

	@Override
	public <B> GenericBasilist<B> reverseMap(Function<A, B> f) {
		DoublyLinkedBasilist<B> result = new DoublyLinkedBasilist<>();
		List<A> l = last;
		while (l != null) {
			result.insert(f.apply(l.value), 0);
			l = l.prev;
		}
		return result;
	}

}
