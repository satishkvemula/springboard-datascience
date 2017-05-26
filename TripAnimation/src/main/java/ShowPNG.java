import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowPNG extends JFrame {
	JLabel label = new JLabel();
	private ShowPNG(String arg) {

		if (arg == null) {
			arg = "/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs/08-29-13_10-17-20.png";

		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		// panel.setSize(500, 640);
		// panel.setMinimumSize(new Dimension(500, 640));
		panel.setBackground(Color.CYAN);
		ImageIcon icon = new ImageIcon(arg);
		label.setIcon(icon);
		// label.setSize(500, 640);
		// label.setMinimumSize(new Dimension(500, 640));
		panel.add(label);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(panel, BorderLayout.WEST);
		this.pack();

	}

	public void animate()  throws InterruptedException{
		String[] images = new String[] {
				"/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs/08-29-13_12-02-50.png",
				"/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs/08-29-13_13-18-30.png",
				"/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs/08-29-13_14-24-40.png",
				"/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs/08-29-13_15-44-50.png",
				"/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs/08-29-13_16-47-50.png",
				"/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs/08-29-13_19-08-50.png" };

		for (int i = 0; i < images.length; i++) {
			Thread.sleep(1000);
			label.setIcon(new ImageIcon(images[i]));
			this.pack();
		}
	}
	
	public void animateOverFolder() throws InterruptedException {

		String gmapPngFolder = "/Users/p2723777/personal/springboard-datascience/capstone_babs/tripanimation/2013_Aug_tripGmapPngs";

		File gmapDirectory = new File(gmapPngFolder);

		File[] files = gmapDirectory.listFiles(new FileFilter() {

			public boolean accept(File file) {
				return !file.isHidden();
			}
		});

		Arrays.sort(files);
		for (File gmapFile : files) {
//			System.out.println(gmapFile.toString());
			Thread.sleep(25	);
			label.setIcon(new ImageIcon(gmapFile.toString()));
			this.pack();

		}
	}

	public static void main(String... args) throws InterruptedException {
		ShowPNG showPNG = new ShowPNG(null);
		showPNG.setVisible(true);
		showPNG.animateOverFolder();
	}
}
