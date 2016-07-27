/**
 * 
 */
package com.somendu.sample;

import java.awt.image.BufferedImage;

/**
 * Image Saver class for keeping the reference of the image
 * 
 * 
 * @author Somendu Maiti
 * @since Jul 25, 2016
 * 
 */
public class ImageSaver {

	private BufferedImage image;

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
