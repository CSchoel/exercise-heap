package permutationsort;

import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;

class PermutationSort {
	
	public static List<List<Integer>> permutations(List<Integer> lst) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if (lst.size() <= 1) {
			permutations.add(lst);
		} else {
			List<Integer> list = new ArrayList<Integer>(lst);
			// Find out and delete the last element
			int last = list.get(list.size()-1);
			// Rest of the list
			List<Integer> rest = list.subList(0, list.size()-1);
			// Perform permutation on the rest list and
			// merge with the last integer
			for(List<Integer> permut : permutations(rest)) {
				// For each list, insert the last integer to all possible positions
				// and add them to the new list
				for(int i = 0; i <= permut.size(); i++) {
					List<Integer> permutation = new ArrayList<>();
					permutation.addAll(permut);
					permutation.add(i, last);	// insert an element
					permutations.add(permutation);
				}
			}	
		}
        return permutations;
    }

	private static boolean isSorted(List<Integer> lst) {
		for(int i = 1; i < lst.size(); i++) {
			if (lst.get(i-1) > lst.get(i)) {
				return false;
			}
		}
		return true;
	}

	// Brute Force, permutations() does not work for longer lists (> 10 elements)
	public static void permutationSort(List<Integer> lst) {
		List<Integer> list = new ArrayList<>(lst);
		for(List<Integer> li : permutations(list)) {
			if (isSorted(li)) {
				lst.clear();
				lst.addAll(li);
			}
		}
	}




	// iterative version, works better for longer lists (very long duration)
	public static List<List<Integer>> permutationsIt(List<Integer> lst) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		BigInteger[] factorials = new BigInteger[lst.size()+1];
		factorials[0] = new BigInteger("1");
        for (int i = 1; i <= lst.size(); i++) {
			factorials[i] = factorials[i-1].multiply(new BigInteger(Integer.toString(i)));
        }
		for (BigInteger bi = BigInteger.valueOf(0); bi.compareTo(factorials[lst.size()]) < 0; bi = bi.add(BigInteger.ONE)) {
            List<Integer> onePermutation = new ArrayList<>();
            List<Integer> temp = new ArrayList<>(lst);
			List<Integer> tmp2 = new ArrayList<>(lst);
            BigInteger positionCode = new BigInteger(bi.toString());
            for (int position = lst.size(); position > 0; position--) {
				BigInteger selected = new BigInteger(positionCode.divide(factorials[position-1]).toString());
				onePermutation.add(temp.get(Integer.parseInt(selected.toString())));
				positionCode = positionCode.mod(factorials[position-1]);
				tmp2.clear();
				tmp2.addAll(temp);
				temp = new ArrayList<>(tmp2.subList(0, Integer.parseInt(selected.toString())));
				temp.addAll(tmp2.subList(Integer.parseInt(selected.toString())+1, tmp2.size()));
            }
            permutations.add(onePermutation);
        }
		return permutations;
	}

}
