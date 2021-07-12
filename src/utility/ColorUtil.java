package utility;

import java.io.IOException;

import config.Keywords;

public class ColorUtil  {

	
	public static boolean verifyStatus(String status) throws IOException {

		if (status.equals("Inprogress") && Keywords.bgColor.equals("rgba(57, 183, 205, 1)")) {
		
		}
		
		else if (status.equals("Submitted") && Keywords.bgColor.equals("rgba(255, 124, 37, 1)")) {
		

		} else if (status.equals("Reviewed") && Keywords.bgColor.equals("rgba(13, 203, 40, 1)")) {
			
		} else if (status.equals("Approved") && Keywords.bgColor.equals("rgba(0, 166, 90, 1)")) {
			
		} else if (status.equals("Reassigned") && Keywords.bgColor.equals("rgba(14, 35, 80, 1)")) {
		
		}
		else if (status.equals("Accepted") && Keywords.bgColor.equals("rgba(14, 198, 65, 1)")) {
		
		}
		else if (status.equals("Planned") && Keywords.bgColor.equals("rgba(0, 192, 239, 1)")) {
		
		}
		else if (status.equals("Close Out")
				|| status.equals("Rejected") && Keywords.bgColor.equals("rgba(202, 2, 2, 1)")) {
			
		} 
		
		else
		{
		return false;
		}
		return true;
	}
	
	
	public static final String SCHEDULED = "rgba(51, 153, 204, 1)";
	public static final String OPEN_RED = "rgba(243, 25, 41, 1)";
	public static final String CLOSE_GREEN = "rgba(0, 166, 90, 1)";
	public static final String CLOSE_MIXED = "rgba(0, 166, 90, 1)";
	public static final String OPEN_ORANGE = "rgba(251, 121, 5, 1)";
	public static final String DATE_HIGHLIGHT = "rgba(255, 0, 0, 1)";
}
