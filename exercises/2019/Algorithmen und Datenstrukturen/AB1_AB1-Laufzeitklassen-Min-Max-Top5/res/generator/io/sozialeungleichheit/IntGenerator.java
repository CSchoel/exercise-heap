package io.sozialeungleichheit;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream; 

public class IntGenerator {
	public static void main(String[] args) {
		Random random = new Random();
		IntStream.range(0, 4000)
			.map(i -> random.nextInt(Integer.MAX_VALUE))
			.mapToObj(Integer::toString)
			.flatMap(s -> Stream.of("\n", s))
			.skip(1).forEach(System.out::print);
	}
}
