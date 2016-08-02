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

	private Dimension imageDimension = new Dimension();

	private ImageCapture imageCapture;

	private JFrame jframe = new JFrame("Choose Size of Picture");

	public ImageCaptureSize(ImageCapture imageCapture) {

		this.imageCapture = imageCapture;

	}

	// TODO
	// Calculate and Find the webcam dimensions
	// Further create UI with the dimensions
	// SetViewsize of the Dimension
	// Capture the image
	// Pass the image to setter

	public void setCamDimensionUI() {

		Webcam webcam = Webcam.getDefault();

		Dimension[] dimensionArray = webcam.getViewSizes();

		JPanel jPanel = new JPanel();

		// jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

		for (Dimension dimension : dimensionArray) {
			double height = dimension.getHeight();
			double width = dimension.getWidth();
			JButton jButton = new JButton();
			jButton.setText((int) width + " x " + (int) height);

			jButton.setVisible(true);

			jPanel.add(jButton);

			DimensionListener dimensionListener = new DimensionListener(jframe, imageCapture, dimension);
			jButton.addMouseListener(dimensionListener);

		}

		jframe.getContentPane().add(jPanel);

		jframe.pack();
		jframe.setVisible(true);

		Dimension jFrameDimension = ScreenUtility.getDimension(270, 100);
		jframe.setSize(jFrameDimension);

		HashMap<String, Integer> frameLocationMap = ScreenUtility.getCenterCoordinates(jframe);
		jframe.setLocation(frameLocationMap.get("frameX"), frameLocationMap.get("frameY"));

		jframe.setResizable(false);

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

}
