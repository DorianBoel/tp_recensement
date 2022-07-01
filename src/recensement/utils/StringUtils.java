package recensement.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	
	public static String sanitize(String term) {
		String sanitized = term.strip();
		sanitized = Pattern.quote(sanitized);
		return sanitized;
	}

	public static String stripAccents(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    return str;
	}
	
	public static boolean matchName(String term, String name, String flag) {
		Pattern pattern = null;
		String termNoAccents = StringUtils.stripAccents(term);
		String nameNoAccents = StringUtils.stripAccents(name);
		if (flag.equals("exact")) {
			pattern = Pattern.compile(termNoAccents, Pattern.CASE_INSENSITIVE);
		} else if (flag.equals("start")) {
			pattern = Pattern.compile(termNoAccents + ".*", Pattern.CASE_INSENSITIVE);
		}
		Matcher matcher = pattern.matcher(nameNoAccents);
		return matcher.matches();
	}
	
}
