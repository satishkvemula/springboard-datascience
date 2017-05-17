import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoOverMapPngs {

	public static void main(String... args) throws InterruptedException, IOException {

		String gmapPngFolder = "/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs";

		File gmapDirectory = new File(gmapPngFolder);

		File[] files = gmapDirectory.listFiles(new FileFilter() {

			public boolean accept(File file) {
				return !file.isHidden();
			}
		});

		Arrays.sort(files);
		for (File gmapFile : files) {
			System.out.println(gmapFile.toString());

		}
	}

	public class MyCanvas extends Canvas {

		public void paint(Graphics g) {

			Toolkit t = Toolkit.getDefaultToolkit();
			Image i = t.getImage("p3.gif");
			g.drawImage(i, 120, 100, this);

		}

		public void main(String arg) {
			MyCanvas m = new MyCanvas();
			JFrame f = new JFrame();
			f.add(m);
			f.setSize(400, 400);
			f.setVisible(true);
		}

	}

}
