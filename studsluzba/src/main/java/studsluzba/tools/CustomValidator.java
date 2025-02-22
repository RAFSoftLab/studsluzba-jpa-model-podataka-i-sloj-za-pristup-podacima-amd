package studsluzba.tools;

import java.util.List;

/**
 * 
 * @author Aleksa Dacic 92/19RN
 *
 */

public class CustomValidator {

	public static boolean emptyString(String...strings) {
		for (String s : strings) {
			if (s.isEmpty())
				return true;
		}
		return false;
	}
	
	public static boolean emptyOrNull(Object...objs) {
		for (Object s : objs) {
			if (s == null)
				return true;
			if (s instanceof String)
				if (((String) s).isEmpty())
					return true;
		}
		return false;
	}
	
	public static boolean allEmpty(String...strings) {
		for (String s : strings) {
			if (!s.isEmpty())
				return false;
		}
		return true;
	}
	
	public static boolean isNumeric(String s) {
		for (char c : s.toCharArray()) {
			if (c < '0' || c > '9')
				return false;
		}
		return true;
	}
	
//	public static boolean expectedType(Object...objs) {
//		// u izgradnji
//		
//	}
}
