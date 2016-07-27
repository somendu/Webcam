/**
 * 
 */
package com.somendu.sample.utils;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.HashMap;

/**
 * <Description>
 * 
 * @author Somendu Maiti<smaiti@scan-it.com.sg>
 * @since Jul 25, 2016
 * 
 */
public class ScreenUtility {

	/**
	 * Getting dimension value
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static Dimension getDimension(int x, int y) {

		Dimension dimension = new Dimension(x, y);
		return dimension;

	}

	/**
	 * Getting the centre dimension based on frame
	 * 
	 * @param frame
	 * @return
	 */
	public static HashMap<String, Integer> getCenterCoordinates(Frame frame) {

		Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
		int frameX = (int) ((screenDimension.getWidth() - frame.getWidth()) / 2);
		int frameY = (int) ((screenDimension.getHeight() - frame.getHeight()) / 2);

		HashMap<String, Integer> dimensionMap = new HashMap<>();

		dimensionMap.put("frameX", frameX);
		dimensionMap.put("frameY", frameY);

		return dimensionMap;
	}
}
