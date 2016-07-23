/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.media.j3d.QuadArray;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.somendu.sample.listener.CaptureButtonListener;
import com.somendu.sample.listener.ImageCropListener;

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

	private JFrame jframe;

	public ImageCaptureRectangle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Showing the image in rectangle
	 * 
	 * @throws IOException
	 */
	public void showButton() throws IOException {

		showButtonToClick();

		QuadArray quadArray = new QuadArray(16, QuadArray.COORDINATES);

		// Point3f east = new Point3f(1.0f, 0.0f, 0.0f);
		//
		// Point3f east = new Point3f(1.0f, 0.0f, 0.0f);
		//
		// Point3f east = new Point3f(1.0f, 0.0f, 0.0f);
		//
		// Point3f east = new Point3f(1.0f, 0.0f, 0.0f);
		//
		// Point3f east = new Point3f(1.0f, 0.0f, 0.0f);

		//
		// FileSaver fs = new FileSaver(imagePlus);
		// fs.saveAsJpeg("path-to-gray.jpg");

		// webcam.close();
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

		jframe.getContentPane().add(jButton);

		jframe.pack();
		jframe.setVisible(true);

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println("Dimension X" + dimension.getHeight());
		System.out.println("Dimension Y" + dimension.getWidth());

		int frameX = (int) ((dimension.getWidth() - jframe.getWidth()) / 2);
		int frameY = (int) ((dimension.getHeight() - jframe.getHeight()) / 2);

		jframe.setLocation(frameX, frameY);

		CaptureButtonListener buttonClickListener = new CaptureButtonListener(this);

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

		imageWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		ImageCropListener mouseListener = new ImageCropListener(this);

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

}