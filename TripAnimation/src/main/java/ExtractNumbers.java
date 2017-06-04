import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumbers {
//	public static void main(String... args) {
//		 StringBuffer sBuffer = new StringBuffer();
//		  Pattern p = Pattern.compile("[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+");
//		  
//		  String str = "6:56 AM 59.0 °F 55.0 °F 87% 29.90 in 10.0 mi West Calm - N/A   Overcast"; 
//		  Matcher m = p.matcher(str);
//		  while (m.find()) {
//		    sBuffer.append(m.group());
//		  }
//		  System.out.println(sBuffer);
//	}
	
	public static void main(String...strings) throws ParseException {

		SimpleDateFormat dayFormatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat day1Formatter = new SimpleDateFormat("yyyy/M/dd");
		SimpleDateFormat day2Formatter = new SimpleDateFormat("yyyy/MM/dd");

		Date startDate = dayFormatter.parse("2013-12-28");
		System.out.println(day1Formatter.format(startDate));
		System.out.println(day2Formatter.format(startDate));
		
	}
}
