/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 * @since Jul 22, 2016
 * 
 */
public class ImageCapture {

	private BufferedImage image;

	public ImageCapture() {

	}

	/**
	 * Showing webcam
	 * 
	 * @return
	 */
	public void takePicture() {

		Webcam webcam = Webcam.getDefault();

		// Incorrect dimension [1280x720] possible ones are [176x144] [320x240]
		// [640x480]

		// webcam.setViewSize(new Dimension(176, 144));

		// webcam.setViewSize(new Dimension(320, 240));

		webcam.setViewSize(new Dimension(640, 480));

		webcam.open();

		setImage(webcam.getImage());

		// TODO Piece of code to use when no webcam is getting used
		// File file = new File("test.png");
		//
		// try {
		// // save image to PNG file
		// image = ImageIO.read(file);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// setImage(image);

		webcam.close();

	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
