package pages;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Util {
	 public static String generateCurrentDateAndTime() {
	        return new SimpleDateFormat("ddMMyyyyHHmmssSSS").format(new Date(0, 0, 0));
	    }

}
