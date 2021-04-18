package array.medium;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOperation {

	public static void main(String[] args) {
		
		ArrayList<Integer> clist=new ArrayList<>();
		clist.add(2);
		clist.add(2);
		clist.add(3);
		clist.add(4);
		clist.add(3);
		

		System.out.println(Collections.binarySearch(clist, 2));
		System.out.println(clist);
	}
	
	
}

