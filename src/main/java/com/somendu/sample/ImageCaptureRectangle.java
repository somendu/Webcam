/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.somendu.sample.listener.CaptureButtonListener;
import com.somendu.sample.listener.ImageCropListener;
import com.somendu.sample.utils.ScreenUtility;

import ij.ImagePlus;
import ij.gui.ImageCanvas;
import ij.gui.ImageWindow;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 * @since Jul 22, 2016
 * 
 */
public class ImageCaptureRectangle {

	private int firstxCoordinate = 0;
	private int firstyCoordinate = 0;

	private int secondxCoordinate = 0;
	private int secondyCoordinate = 0;

	private ImagePlus imagePlus;
	private ImageCanvas imageCanvas;
	private ImageWindow imageWindow;
	private ImageSaver imageCaptureWindow;

	private BufferedImage image;

	private JFrame jframe;

	public ImageCaptureRectangle() {

	}

	/**
	 * Showing the image in rectangle
	 * 
	 * @throws IOException
	 */
	public void showButton() {

		showButtonToClick();

	}

	/**
	 * First Button
	 * 
	 * @return
	 */
	private void showButtonToClick() {

		jframe = new JFrame("Welcome");
		JButton jButton = new JButton();

		jButton.setText("Click to Take Picture");

		jButton.setVisible(true);

		JPanel jPanel = new JPanel();
		jPanel.add(jButton);
		jframe.getContentPane().add(jPanel);

		jframe.pack();
		jframe.setVisible(true);

		Dimension dimension = ScreenUtility.getDimension(200, 70);
		jframe.setSize(dimension);

		HashMap<String, Integer> frameLocationMap = ScreenUtility.getCenterCoordinates(jframe);
		jframe.setLocation(frameLocationMap.get("frameX"), frameLocationMap.get("frameY"));

		CaptureButtonListener buttonClickListener = new CaptureButtonListener(this, jframe);

		jButton.addMouseListener(buttonClickListener);

	}

	/**
	 * SHowing Image Window
	 * 
	 * @param image
	 */
	public void showImageWindow(BufferedImage image) {

		imagePlus = new ImagePlus("Main Image", image);

		imageCanvas = new ImageCanvas(imagePlus);

		imageWindow = new ImageWindow(imagePlus, imageCanvas);

		imageCaptureWindow = new ImageSaver();

		HashMap<String, Integer> frameLocationMap = ScreenUtility.getCenterCoordinates(imageWindow);
		imageWindow.setLocation(frameLocationMap.get("frameX"), frameLocationMap.get("frameY"));

		imageWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		imageCaptureWindow.setImage(image);

		ImageCropListener mouseListener = new ImageCropListener(this, imageCaptureWindow);

		imageCanvas.addMouseListener(mouseListener);

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
	 * @return the imageCanvas
	 */
	public ImageCanvas getImageCanvas() {
		return imageCanvas;
	}

	/**
	 * @param imageCanvas
	 *            the imageCanvas to set
	 */
	public void setImageCanvas(ImageCanvas imageCanvas) {
		this.imageCanvas = imageCanvas;
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

	/**
	 * @return the jframe
	 */
	public JFrame getJframe() {
		return jframe;
	}

	/**
	 * @param jframe
	 *            the jframe to set
	 */
	public void setJframe(JFrame jframe) {
		this.jframe = jframe;
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