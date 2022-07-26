package recensement.utils;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Non-instantiable class containing
 * utility methods used to process
 * character string values.
 * 
 * @author DorianBoel
 */
public final class StringUtils {
	
	
	/**
	 * Don't let anyone instantiate this class.
	 */
	private StringUtils() {}
	
	/**
	 * Trims whitespace and escapes special characters
	 * in a given String.
	 * 
	 * @param term The string to sanitized
	 * @return The sanitized string
	 */
	public static String sanitize(String term) {
		String sanitized = term.strip();
		sanitized = Pattern.quote(sanitized);
		return sanitized;
	}

	/**
	 * Replaces all letters with diacritical marks
	 * in a given String with their unmarked versions.
	 * 
	 * @param str The string to remove accents from
	 * @return The string with all accents removed
	 */
	public static String stripAccents(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
	    return str;
	}
	
	/**
	 * Checks if a given search term
	 * matches a given String using a 
	 * {@link Pattern regex pattern}.
	 * The pattern is case-insensitive
	 * and ignores diacritics.
	 * <p>
	 * 		The expected values for the flag argument are the following:
	 * </p>
	 * <ul>
	 * 		<li>
	 * 			<strong>exact</strong>: The match will succeed only if the given String
	 * 			is identical to the search term.
	 * 		</li>
	 * 		<li>
	 * 			<strong>start</strong>: The match will succeed only if the given String
	 * 			contains the search term, starting at the first character.
	 * 		</li>
	 * </ul>
	 * 
	 * @param term The search term used to construct a regex pattern
	 * @param name The String to attempt to match with the pattern
	 * @param flag A flag determining how strictly the pattern
	 * will attempt to match the given String
	 * @return A {@code boolean} value indicating whether or not the match
	 * was successful
	 */
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
