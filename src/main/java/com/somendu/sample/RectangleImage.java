/**
 * 
 */
package com.somendu.sample;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.media.j3d.QuadArray;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.somendu.sample.listener.ButtonClickListener;
import com.somendu.sample.listener.ImageMouseListener;

import ij.ImagePlus;
import ij.gui.ImageCanvas;
import ij.gui.ImageWindow;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 * @since Jul 15, 2016
 * 
 */
public class RectangleImage {

	private int firstxCoordinate = 0;
	private int firstyCoordinate = 0;

	private int secondxCoordinate = 0;
	private int secondyCoordinate = 0;

	private ImagePlus imagePlus;
	private ImageCanvas imageCanvas;
	private ImageWindow imageWindow;

	public RectangleImage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Showing the image in rectangle
	 * 
	 * @throws IOException
	 */
	public void showButton() throws IOException {

		// get default webcam and open it
		// Webcam webcam;
		// webcam = Webcam.getDefault();
		//
		// webcam.open();

		// showButtonToClick();

		// get image
		// BufferedImage image = webcam.getImage();

		File file = new File("test.png");

		// save image to PNG file
		// BufferedImage image = ImageIO.read(file);
		showButtonToClick();

		JFrame jframe = new JFrame("Welcome");

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

		// TODO - Method to show image
		// showImageWindow(image);

		// mouseListener.getFirstxCoordinate();

		// jframe.setContentPane(new JLabel(new ImageIcon(file.getName())));
		//
		// jframe.add(imageCanvas);
		//
		// JPanel jPanel = new JPanel();
		//
		// jPanel.setLayout(new GridLayout(1, 1, 2, 2));
		//
		// jframe.getContentPane().add(jPanel, BorderLayout.CENTER);
		//
		// jframe.pack();
		// jframe.setVisible(true);
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

		JFrame jframe = new JFrame("Welcome");
		JButton jButton = new JButton("Click to Take Picture");

		jframe.setContentPane(jButton);

		JPanel jPanel = new JPanel();

		jPanel.setLayout(new GridLayout(4, 4, 2, 2));

		jframe.getContentPane().add(jPanel, BorderLayout.CENTER);

		jframe.pack();
		jframe.setVisible(true);

		ButtonClickListener buttonClickListener = new ButtonClickListener(this);

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

		ImageMouseListener mouseListener = new ImageMouseListener(this);

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

}