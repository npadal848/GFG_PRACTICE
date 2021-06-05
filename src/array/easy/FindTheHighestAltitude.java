package array.easy;

public class FindTheHighestAltitude {

	public static void main(String[] args) {
		int[] gain1 = {-5,1,5,0,-7}; 
//		Output: 1
//		Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
		
		int[] gain2 = {-4,-3,-2,-1,4,3,2};
//		Output: 0
//		Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
		
		System.out.println(largestAltitude(gain1));
		System.out.println(largestAltitude(gain2));
	}

	static int largestAltitude(int[] gain) {
		int highestAltitude = 0;
		int sum=0;
		for (int i = 0; i < gain.length; i++) {
			sum+=gain[i];
			highestAltitude = Math.max(highestAltitude, sum);
		}
		return highestAltitude;
	}
}
