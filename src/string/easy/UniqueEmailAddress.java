package string.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

	public static void main(String[] args) {
		String[] emails1 = { "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
				"testemail+david@lee.tcode.com" };
		String[] emails2 = { "a@leetcode.com", "b@leetcode.com", "c@leetcode.com" };

		System.out.println(numUniqueEmails(emails1));
		System.out.println(numUniqueEmails(emails2));
	}

	private static int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			int indexOfDot = email.indexOf('.');
			if (indexOfDot == email.lastIndexOf('.')) {
				checkForPlusSymbol(email, set);
			} else {
				// replace dot(.) in email local address
				StringBuilder sb = new StringBuilder();
				for (char ch : email.toCharArray()) {
					if (ch == '@')
						break;
					if (ch == '.')
						continue;
					sb.append(ch);
				}
				sb.append(email.substring(email.indexOf('@')));
				checkForPlusSymbol(sb.toString(), set);
			}
		}

		return set.size();
	}

	private static void checkForPlusSymbol(String mail, Set<String> set) {
		if (mail.indexOf('+') != -1) {
			String mailAddrs = mail.substring(0, mail.indexOf('+')) + mail.substring(mail.indexOf('@'));
			set.add(mailAddrs);
		} else
			set.add(mail);
	}
}
