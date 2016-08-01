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

		// Incorrect dimension [1280x720] possible ones are [176x144] [320x240]
		// [640x480]

		// webcam.setViewSize(new Dimension(176, 144));

		// webcam.setViewSize(new Dimension(320, 240));

		// webcam.setViewSize(new Dimension(640, 480));

		ImageSaver imageSaver = new ImageSaver();

		ImageCaptureSize imageCaptureSize = new ImageCaptureSize(this, imageSaver);
		imageCaptureSize.setImageSaver(imageSaver);

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

	}

	public void captureDimensionImage(Dimension dimension) {

		Webcam webcam = Webcam.getDefault();

		webcam.setViewSize(dimension);

		webcam.open();

		// BufferedImage image = imageCaptureSize.getImage();

		setImage(webcam.getImage());

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
