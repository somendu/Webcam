/**
 * 
 */
package com.somendu.sample.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import com.somendu.sample.ImageCaptureProcess;
import com.somendu.sample.ImageCaptureRectangle;
import com.somendu.sample.ImageSaver;

import ij.gui.ImageWindow;

/**
 * Listener for Mouse on mouse hover
 * 
 * @author Somendu Maiti
 * @since Jul 22, 2016
 * 
 */
public class ImageCropListener implements MouseListener {

	private ImageCaptureRectangle rectangleImage;

	private int firstxCoordinate = 0;
	private int firstyCoordinate = 0;

	private int secondxCoordinate = 0;
	private int secondyCoordinate = 0;

	private ImageSaver imageCaptureWindow;

	public ImageCropListener(ImageCaptureRectangle rectangleImage, ImageSaver imageCaptureWindow) {

		this.rectangleImage = rectangleImage;
		this.imageCaptureWindow = imageCaptureWindow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {

		firstxCoordinate = e.getX();
		firstyCoordinate = e.getY();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		secondxCoordinate = e.getX();
		secondyCoordinate = e.getY();

		System.out.println("Mouse Pressed");
		System.out.println("X : " + firstxCoordinate + "	Y : " + firstyCoordinate);

		System.out.println("Mouse Released");
		System.out.println("X : " + secondxCoordinate + "	Y : " + secondyCoordinate);

		if (rectangleImage.getImageWindow() != null) {
			System.out.println("Image window is not null");
		}

		// imageCaptureWindow.setImageWindow(rectangleImage.getImageWindow());
		// imageCaptureWindow.showImageWindowAlert();

		BufferedImage oldImage = imageCaptureWindow.getImage();

		// TODO
		// Show Warning - before Cutting

		ImageCaptureProcess imageCapture = new ImageCaptureProcess();
		// Old Image
		imageCapture.setOldImage(oldImage);

		rectangleImage.setImageWindow(new ImageWindow(rectangleImage.getImagePlus(), rectangleImage.getImageCanvas()));

		imageCapture.setFirstxCoordinate(firstxCoordinate);
		imageCapture.setFirstyCoordinate(firstyCoordinate);
		imageCapture.setSecondxCoordinate(secondxCoordinate);
		imageCapture.setSecondyCoordinate(secondyCoordinate);
		imageCapture.setImageWindow(rectangleImage.getImageWindow());

		imageCapture.generateWindow();

		rectangleImage.getImageCanvas().removeMouseListener(this);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {

		System.out.println("Mouse Entered");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {

		System.out.println("Mouse Exited");
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

}
