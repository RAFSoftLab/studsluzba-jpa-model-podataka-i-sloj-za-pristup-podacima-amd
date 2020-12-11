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
			if (s instanceof List<?>)
				if (((List<?>) s).isEmpty())
					return true;
		}
		return false;
	}
	
//	public static boolean expectedType(Object...objs) {
//		// u izgradnji
//		
//	}
}
