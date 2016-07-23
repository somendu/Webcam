/**
 * 
 */
package com.somendu.sample;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;

import ij.ImagePlus;
import ij.process.ImageProcessor;

/**
 * <Description>
 * 
 * @author Somendu Maiti<smaiti@scan-it.com.sg>
 * @since Jul 12, 2016
 * 
 */
public class ImageCrop {

	private BufferedImage bufferedImage;

	private ImagePlus imagePlus = new ImagePlus();

	public ImageCrop() {

	}

	public ImagePlus cropImage() {

		bufferedImage = getBufferedImage();

		ImagePlus imagePlus = new ImagePlus("gray", bufferedImage);

		ImageProcessor imageProcessor = imagePlus.getProcessor();

		ColorModel colorModel = bufferedImage.getColorModel();

		IndexColorModel indexColorModel = imageProcessor.getDefaultColorModel();

		int size = indexColorModel.getMapSize();
		int[] rgbs = new int[size];

		indexColorModel.getRGBs(rgbs);

		// imageProcessor.convertToRGB();

		imageProcessor.setInterpolationMethod(ImageProcessor.FIND_EDGES);

		return imagePlus;

	}

	/**
	 * @return the bufferedImage
	 */
	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	/**
	 * @param bufferedImage
	 *            the bufferedImage to set
	 */
	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
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

}
