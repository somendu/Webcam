/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.github.sarxos.webcam.Webcam;
import com.somendu.sample.listener.DimensionListener;
import com.somendu.sample.utils.ScreenUtility;

/**
 * This class to show the UI for setting size of the default webcam
 * 
 * @author Somendu Maiti
 * @since Aug 1, 2016
 * 
 */
public class ImageCaptureSize {

	private BufferedImage image;

	private Webcam webcam;

	private Dimension imageDimension = new Dimension();

	private ImageSaver imageSaver;
	private ImageCapture imageCapture;

	private JFrame jframe = new JFrame("Choose Size of Picture");

	public ImageCaptureSize(ImageCapture imageCapture, ImageSaver imageSaver) {

		this.webcam = webcam;
		this.imageSaver = imageSaver;
		this.imageCapture = imageCapture;
		imageSaver.setDimension(setCamDimensionUI());
	}

	// TODO
	// Calculate and Find the webcam dimensions
	// Further create UI with the dimensions
	// SetViewsize of the Dimension
	// Capture the image
	// Pass the image to setter

	private Dimension setCamDimensionUI() {

		HashMap<String, Integer> frameLocationMap = ScreenUtility.getCenterCoordinates(jframe);
		jframe.setLocation(frameLocationMap.get("frameX"), frameLocationMap.get("frameY"));

		Webcam webcam = Webcam.getDefault();

		Dimension[] dimensionArray = webcam.getViewSizes();

		JPanel jPanel = new JPanel();

		Dimension imageDimension = new Dimension();
		for (Dimension dimension : dimensionArray) {
			double height = dimension.getHeight();
			double width = dimension.getWidth();
			JButton jButton = new JButton();
			jButton.setText((int) width + " x " + (int) height);
			jButton.setVisible(true);
			jPanel.add(jButton);

			ImageSaver imageSaver = new ImageSaver();

			DimensionListener dimensionListener = new DimensionListener(jframe, imageCapture, imageSaver, dimension);
			jButton.addMouseListener(dimensionListener);

		}

		jframe.getContentPane().add(jPanel);

		jframe.pack();
		jframe.setVisible(true);

		return imageDimension;
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

	/**
	 * @return the imageDimension
	 */
	public Dimension getImageDimension() {
		return imageDimension;
	}

	/**
	 * @param imageDimension
	 *            the imageDimension to set
	 */
	public void setImageDimension(Dimension imageDimension) {
		this.imageDimension = imageDimension;
	}

	/**
	 * @return the imageSaver
	 */
	public ImageSaver getImageSaver() {
		return imageSaver;
	}

	/**
	 * @param imageSaver
	 *            the imageSaver to set
	 */
	public void setImageSaver(ImageSaver imageSaver) {
		this.imageSaver = imageSaver;
	}

}
