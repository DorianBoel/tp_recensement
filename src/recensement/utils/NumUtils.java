package recensement.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Non-instantiable class containing
 * utility methods used to process
 * numeric values.
 * 
 * @author DorianBoel
 */
public final class NumUtils {

	/**
	 * Don't let anyone instantiate this class.
	 */
	private NumUtils() {}
	
	/**
	 * Formats a given integer into a readable String.
	 * 
	 * @param i The integer to format
	 * @return The formatted number string 
	 */
	public static String format(int i) {
		return NumberFormat.getInstance(Locale.FRANCE).format(i);
	}
	
}
