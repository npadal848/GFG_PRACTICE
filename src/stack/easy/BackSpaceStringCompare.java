package stack.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackSpaceStringCompare {

	public static void main(String[] args) {
		String s = "ab#c";
		String t = "ad#c";
		System.out.println(backspaceCompare(s, t));

		s = "ab##";
		t = "c#d#";
		System.out.println(backspaceCompare(s, t));
		s = "a##c";
		t = "#a#c";
		System.out.println(backspaceCompare(s, t));
	}

	public static boolean backspaceCompare(String s, String t) {
		Deque<Character> stack = new ArrayDeque<>();
        for(char ch: s.toCharArray()){
            if(ch!='#')
                stack.push(ch);
            else if(ch=='#' && !stack.isEmpty())
                stack.pop();
            
        }
        StringBuilder sBuilder = new StringBuilder();
        for(char ch: stack)
            sBuilder.append(ch);
        stack = new ArrayDeque<>();
        for(char ch: t.toCharArray()){
            if(ch!='#')
                stack.push(ch);
            else if(ch=='#' && !stack.isEmpty())
                stack.pop();
            
        }
        StringBuilder tBuilder = new StringBuilder();
        for(char ch: stack)
            tBuilder.append(ch);
        return sBuilder.toString().equals(tBuilder.toString());
	}
}
