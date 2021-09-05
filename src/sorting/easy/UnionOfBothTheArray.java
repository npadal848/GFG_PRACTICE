package sorting.easy;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UnionOfBothTheArray {

	public static void main(String[] args) {
		int[] arr1 = {23, 11, 5, 6};
		int[] arr2 = {2, 4, 5, 6};
		
		Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		for(int num: arr2)
			set.add(num);
		
		System.out.println(set);
	}
}
