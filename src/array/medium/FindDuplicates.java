package array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FindDuplicates {

	public static void main(String[] args) {
		int[] arr= {2,3,1,2,3};
		ArrayList<Integer> list = duplicates(arr, arr.length);
		for(int num:list) {
			System.out.print(num+" ");
		}
	}
	
	public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i=0; i<n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        
        // ArrayList<Integer> duplicates= (ArrayList<Integer>) map.entrySet()
        // 		.stream()
        // 		.filter(entry -> entry.getValue()>1)
        // 		.map(Entry::getKey)
        // 		.collect(Collectors.toList());
        
        ArrayList<Integer> duplicates=new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key)>1){
                duplicates.add(key);
            }
        }
        
        return duplicates;
    }
}
