import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectTemperatures {
	static FileWriter writer;
	static ChromeDriver driver;

	public static void main(String... args) throws InterruptedException, IOException, ParseException {
		long startTime = System.currentTimeMillis();
		System.setProperty("webdriver.chrome.driver", "/Users/p2723777/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.MILLISECONDS);

		String urlTemplate ="https://www.wunderground.com/history/airport/KSFO/DAY/DailyHistory.html?req_city=San%20Francisco&req_state=CA&req_statename=California&reqdb.zip=94103&reqdb.magic=1&reqdb.wmo=99999";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = formatter.parse("2014-01-05");
		Date endDate = formatter.parse("2014-03-01");
		
		Calendar start = Calendar.getInstance();
		start.setTime(startDate);
		Calendar end = Calendar.getInstance();
		end.setTime(endDate);

		writeHeaderToFile();
		int numberOfDays= 0;
		for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
			long localStartTime = System.currentTimeMillis();

			SimpleDateFormat day1Formatter = new SimpleDateFormat("yyyy/M/dd");
		    
			String day = day1Formatter.format(date);
			String url = urlTemplate.replace("DAY", day);

			driver.get(url);
			List<List<String>> hourlyData = getHourlyData();
			writeToFile(day, hourlyData);
			numberOfDays++;
			System.out.println("Time Taken for " + day + " : " + (System.currentTimeMillis() - localStartTime) + " ms");
		}

        writer.flush();
        writer.close();
        
        System.out.println("Time Taken for " + numberOfDays + " days : " + (System.currentTimeMillis() - startTime) + " ms");
        driver.close();
        driver.quit();
	}
	
	public static void writeHeaderToFile() throws IOException {
        String csvFile = "/Users/p2723777/personal/springboard-datascience/capstone_babs/CapstoneProject/data/SFO5_temperatures.csv";
        writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, Arrays.asList("Time", "Temp(F)", "Humidity(%)", "WindSpeed(mph)"));
	}
	
	public static void writeToFile(String day, List<List<String>> hourlyData) throws IOException, ParseException {

        for (List<String> dataRow: hourlyData) {
        	String time = day + " " + dataRow.get(0);
        	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm aaa"); //2013/8/28 12:56 AM
        	Date nearestHour = toNearestWholeHour(dateFormat.parse(time));

        	SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //2013/8/28 12:56 AM
        	time = outputDateFormat.format(nearestHour);
        	
        	String temperature = dataRow.get(1).split(" ")[0];
        	String humidity = dataRow.get(3).replace("%", "");

    		String windSpeed = dataRow.get(7).replace(" mph", "");
        	if (!isNumeric(windSpeed)) {
        		windSpeed = "0";
        	}
            CSVUtils.writeLine(writer, Arrays.asList(time, temperature, humidity, windSpeed));
        }
	}
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

	public static List<String> getHeaders() {
		WebElement table_element = driver.findElement(By.id("obsTable"));
		List<WebElement> tr_collection = table_element.findElements(By.xpath("id('obsTable')/thead/tr"));

		List<String> headers = new ArrayList<String>();

		headers = new ArrayList<String>();
		List<WebElement> td_collection = tr_collection.get(0).findElements(By.xpath("th"));

		for (WebElement tdElement : td_collection) {
			headers.add(tdElement.getText());
		}
		return headers;
	}

	public static List<List<String>> getHourlyData() {
		WebElement table_element = driver.findElement(By.id("obsTable"));
//		System.out.println(table_element.getText());
		
		List<WebElement> tr_collection = table_element.findElements(By.xpath("id('obsTable')/tbody/tr"));

		
		List<List<String>> dataTable = new ArrayList<List<String>>();

		for (WebElement trElement : tr_collection) {
			List<String> rowData = new ArrayList<String>();
			List<WebElement> td_collection = trElement.findElements(By.xpath("td"));

			for (WebElement tdElement : td_collection) {
				rowData.add(tdElement.getText());
			}
			dataTable.add(rowData);
		}
		return dataTable;
	}

	public static Date toNearestWholeHour(Date d) {
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        if (c.get(Calendar.MINUTE) >= 30)
            c.add(Calendar.HOUR, 1);

        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }
}
