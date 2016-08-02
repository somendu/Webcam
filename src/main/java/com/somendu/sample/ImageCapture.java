/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;

/**
 * Capture Class for Image
 * 
 * @author Somendu Maiti
 * @since Jul 22, 2016
 * 
 */
public class ImageCapture {

	private BufferedImage image;
	private ImageCaptureRectangle rectangleImage;

	public ImageCapture(ImageCaptureRectangle rectangleImage) {

		this.rectangleImage = rectangleImage;
	}

	/**
	 * Showing webcam
	 * 
	 * @return
	 */
	public void takePicture() {

		ImageCaptureSize imageCaptureSize = new ImageCaptureSize(this);
		imageCaptureSize.setCamDimensionUI();

	}

	/**
	 * capture the image in dimension
	 * 
	 * @param dimension
	 */
	public void captureDimensionImage(Dimension dimension) {

		Webcam webcam = Webcam.getDefault();

		webcam.setViewSize(dimension);

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

		// webcam.close();

		rectangleImage.showImageWindow(webcam.getImage());

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
