/**
 * 
 */
package com.somendu.sample;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import ij.ImagePlus;
import ij.gui.ImageWindow;
import ij.gui.Roi;
import ij.process.ImageProcessor;

/**
 * Processing Class
 * 
 * @author Somendu Maiti
 * @since Jul 15, 2016
 * 
 */
public class RectangleImageProcess {

	private int firstxCoordinate = 0;

	private int firstyCoordinate = 0;

	private int secondxCoordinate = 0;

	private int secondyCoordinate = 0;

	// Checking this for diff in height and width
	private int fixedHeight = 90;
	private int fixedWidth = 70;

	private ImageWindow imageWindow;

	private ImagePlus imagePlus = new ImagePlus();

	public RectangleImageProcess() {

	}

	/**
	 * Generating the image in window
	 */
	public void generateWindow() {

		imageWindow = getImageWindow();
		imagePlus = imageWindow.getImagePlus();
		imagePlus.setTitle("Cropped Image");
		setImage();
		imageWindow.setImage(imagePlus);
		imageWindow.setVisible(true);
		imageWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}

	/**
	 * Setting the image
	 */
	private void setImage() {

		int x1 = firstxCoordinate;
		int y1 = firstyCoordinate;
		int x2 = secondxCoordinate;
		int y2 = secondyCoordinate;
		int maxHeight = fixedHeight;
		int maxWidth = fixedWidth;

		int height = 0;
		int width = 0;

		if (x1 == x2 || y1 == y2) {
			// exit;
		} else

		// Case When Start from Left Top
		// x1 = 10, y1 = 10, x2 = 30, y2 = 30
		if (x1 < x2) {
			if (y1 == y2) {
				// exit;
			} else

			if (y1 < y2) {
				height = y2 - y1;

				// if (height < maxHeight) {
				// height = maxHeight;
				// }

				width = x2 - x1;
				// if (width < maxWidth) {
				// width = maxWidth;
				// }

				try {
					imagePlus = processImage(x1, y1, width, height);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else

			// Case When Start from Left Bottom
			// x1 = 10, y1 = 30, x2 = 30, y2 = 10
			if (y1 > y2) {

				height = x2 - x1;
				// if (height < maxHeight) {
				// height = maxHeight;
				// }

				width = y1 - y2;

				// if (width < maxWidth) {
				// width = maxWidth;
				// }

				try {
					imagePlus = processImage(x1, y2, width, height);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		// Case When start from Right Top
		// x1 = 30, y1 = 10, x2 = 10, y2 = 30
		if (x1 > x2) {
			if (y1 == y2) {
				// exit;
			} else

			if (y1 < y2) {
				height = y2 - y1;

				// if (height < maxHeight) {
				// height = maxHeight;
				// }

				width = x1 - x2;
				// if (width < maxWidth) {
				// width = maxWidth;
				// }

				try {
					imagePlus = processImage(x2, y1, width, height);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else

			// Case When start from Right Bottom
			// x1 = 30, y1 = 30, x2 = 10, y2 = 10
			if (y1 > y2) {

				height = x1 - x2;

				// if (height < maxHeight) {
				// height = maxHeight;
				// }

				width = y1 - y2;

				// if (width < maxWidth) {
				// width = maxWidth;
				// }

				try {
					imagePlus = processImage(x2, y2, width, height);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	// http://albert.rierol.net/imagej_programming_tutorials.html
	/**
	 * Processing and Cropping the image
	 * 
	 * @param x1
	 * @param y1
	 * @param width
	 * @param height
	 * @return
	 * @throws IOException
	 */
	private ImagePlus processImage(int x1, int y1, int width, int height) throws IOException {

		final ImageProcessor imageProcessor = imagePlus.getProcessor();

		Roi roi = new Roi(x1, y1, width, height);

		imageProcessor.setRoi(roi);

		ImageProcessor imageProcessorNew = imageProcessor.crop();

		imagePlus.setProcessor(imageProcessorNew);

		return imagePlus;
	}

	/**
	 * @return the firstxCoordinate
	 */
	public int getFirstxCoordinate() {

		return firstxCoordinate;
	}

	/**
	 * @param firstxCoordinate
	 *            the firstxCoordinate to set
	 */
	public void setFirstxCoordinate(int firstxCoordinate) {
		this.firstxCoordinate = firstxCoordinate;
	}

	/**
	 * @return the firstyCoordinate
	 */
	public int getFirstyCoordinate() {
		return firstyCoordinate;
	}

	/**
	 * @param firstyCoordinate
	 *            the firstyCoordinate to set
	 */
	public void setFirstyCoordinate(int firstyCoordinate) {
		this.firstyCoordinate = firstyCoordinate;
	}

	/**
	 * @return the secondxCoordinate
	 */
	public int getSecondxCoordinate() {
		return secondxCoordinate;
	}

	/**
	 * @param secondxCoordinate
	 *            the secondxCoordinate to set
	 */
	public void setSecondxCoordinate(int secondxCoordinate) {
		this.secondxCoordinate = secondxCoordinate;
	}

	/**
	 * @return the secondyCoordinate
	 */
	public int getSecondyCoordinate() {
		return secondyCoordinate;
	}

	/**
	 * @param secondyCoordinate
	 *            the secondyCoordinate to set
	 */
	public void setSecondyCoordinate(int secondyCoordinate) {
		this.secondyCoordinate = secondyCoordinate;
	}

	/**
	 * @return the imagePlus
	 */
	public ImagePlus getImagePlus() {
		return imagePlus;
	}

	/**
	 * @param imagePlus
	 *            the imagePlus to set
	 */
	public void setImagePlus(ImagePlus imagePlus) {
		this.imagePlus = imagePlus;
	}

	/**
	 * @return the imageWindow
	 */
	public ImageWindow getImageWindow() {
		return imageWindow;
	}

	/**
	 * @param imageWindow
	 *            the imageWindow to set
	 */
	public void setImageWindow(ImageWindow imageWindow) {
		this.imageWindow = imageWindow;
	}
}
