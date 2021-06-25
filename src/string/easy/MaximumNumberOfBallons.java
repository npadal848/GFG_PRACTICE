package string.easy;

public class MaximumNumberOfBallons {

	public static void main(String[] args) {
		String text1 = "nlaebolko";
		String text2 = "loonbalxballpoon";
		String text3 = "leetcode";

		System.out.println(maxNumberOfBalloons(text1));
		System.out.println(maxNumberOfBalloons(text2));
		System.out.println(maxNumberOfBalloons(text3));
		System.out.println();
		System.out.println(maxNumberOfBalloons2(text1));
		System.out.println(maxNumberOfBalloons2(text2));
		System.out.println(maxNumberOfBalloons2(text3));
	}

	public static int maxNumberOfBalloons(String text) {
		String str = "balloon";
		if (text == null || text.length() < str.length())
			return 0;
		int[] textCount = getCountArray(text);
		int[] strCount = getCountArray(str);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			int count = textCount[str.charAt(i) - 'a'] / strCount[str.charAt(i) - 'a'];
			min = Math.min(min, count);
		}
		return min;
	}

	static int[] getCountArray(String str) {
		int[] count = new int[26];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}
		return count;
	}
	
	// improved solution
	public static int maxNumberOfBalloons2(String text) {
        if(text==null || text.length()< 7)
            return 0;
        int a =0;
        int b =0;
        int l =0;
        int n =0;
        int o =0;
        
        for(int i = 0; i<text.length(); i++){
            switch(text.charAt(i)){
                case 'a':
                    a++;
                    break;
                case 'b':
                    b++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'n':
                    n++;
                    break;
                case 'o':
                    o++;
                    break;
            }    
        }
        return Math.min(Math.min(l/2, o/2), Math.min(Math.min(a, b), n));
    }
}
