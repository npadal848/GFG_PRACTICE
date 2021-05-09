package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class CeeateTargetArrayByLeetCode {

	public static void main(String[] args) {
//		int[] nums = { 0, 1, 2, 3, 4 };
//		int[] index = { 0, 1, 2, 2, 1 };
		
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] index = { 0, 0, 0, 0, 0 };

//		int[] targetArray = createTargetArray1(nums, index);
		int[] targetArray = createTargetArray2(nums, index);
		Arrays.stream(targetArray).forEach(ele -> {
			System.out.print(ele + " ");
		});
	}

	public static int[] createTargetArray1(int[] nums, int[] index) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			list.add(index[i], nums[i]);
		}
		return list.stream().mapToInt(i->i).toArray();
	}
	
	public static int[] createTargetArray2(int[] nums, int[] index) {
        int[] target = new int[nums.length];
		int count = 0;
		while (count < target.length) {
            if (index[count] >= count) {
				target[index[count]] = nums[count];
			}
            else{
				for (int i = target.length - 1; i > index[count]; i--)
					target[i] = target[i - 1];
				target[index[count]] = nums[count];
			}
			count++;
		}
        return target;
    }
}
