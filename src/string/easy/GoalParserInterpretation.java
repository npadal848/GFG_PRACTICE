package string.easy;

public class GoalParserInterpretation {

	public static void main(String[] args) {
		String command1 = "G()(al)"; // Output: Goal
		String command2 = "G()()()()(al)"; // Output: "Gooooal"
		String command3 = "(al)G(al)()()G"; // Output: "alGalooG"

		System.out.println(parse1(command1));
		System.out.println(parse1(command2));
		System.out.println(parse1(command3));
	}

	static String parse1(String command) {
		int n = command.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n;) {
			if (command.charAt(i) == 'G') {
				sb.append(command.charAt(i));
				i++;
			} else if ((i + 1) < n && (command.charAt(i) == '(' && command.charAt(i + 1) == ')')) {
				sb.append('o');
				i += 2;
			} else {
				sb.append("al");
				i += 4;
			}
		}
		return sb.toString();
	}

	static String parse2(String command) {
		return command.replace("()", "o").replace("(al)", "al");
	}
}
