package recensement;

import java.text.NumberFormat;
import java.util.Locale;

public class NumUtils {

	public static String format(int i) {
		return NumberFormat.getInstance(Locale.FRANCE).format(i);
	}
	
}
