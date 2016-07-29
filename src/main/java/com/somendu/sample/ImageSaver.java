/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
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
	private Dimension dimension;

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
	 * @return the dimension
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * @param dimension the dimension to set
	 */
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

}
