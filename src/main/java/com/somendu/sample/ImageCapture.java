/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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

		// setCameraImage(dimension);

		// TODO Piece of code to use when no webcam is getting used
		setCapturedImage();

	}

	private void setCapturedImage() {
		File file = new File("test.png");

		try {
			// save image to PNG file
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		rectangleImage.showImageWindow(image);

	}

	private void setCameraImage(Dimension dimension) {

		Webcam webcam = Webcam.getDefault();

		webcam.setViewSize(dimension);

		webcam.open();

		rectangleImage.showImageWindow(webcam.getImage());

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
