package basilist;

import java.util.function.Function;

public interface GenericBasilist<A> {

	A get(int idx); // retrieve element

	void set(A el, int idx); // overwrite element

	int size(); // number of elements

	void add(A el); // append to end

	void remove(int idx); // remove at index

	void insert(A el, int idx); // insert at index

	<B> GenericBasilist<B> map(Function<A, B> f); // call `f` for each element and return a mapped list

	<B> GenericBasilist<B> reverseMap(Function<A, B> f); // like `map` but traverse in reverse order

}
