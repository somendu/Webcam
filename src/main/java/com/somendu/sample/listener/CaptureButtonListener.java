/**
 * 
 */
package com.somendu.sample.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import com.somendu.sample.ImageCapture;
import com.somendu.sample.ImageCaptureRectangle;

/**
 * Mouse Listener for capturing the image
 * 
 * @author Somendu Maiti<smaiti@scan-it.com.sg>
 * @since Jul 22, 2016
 * 
 */
public class CaptureButtonListener implements MouseListener {

	private BufferedImage image;
	private ImageCaptureRectangle rectangleImage;

	public CaptureButtonListener(ImageCaptureRectangle imageCaptureRectangle) {

		this.rectangleImage = imageCaptureRectangle;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {

		System.out.println("Clicked");
		rectangleImage.getJframe().setVisible(false);
		ImageCapture imageCapture = new ImageCapture();
		imageCapture.takePicture();

		rectangleImage.showImageWindow(imageCapture.getImage());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

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
