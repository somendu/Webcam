/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.HashMap;

/**
 * Utility Class
 * 
 * @author Somendu Maiti
 * @since Jul 26, 2016
 * 
 */
public class ScreenUtility {

	/**
	 * Center dimension
	 * 
	 * @param frame
	 * @return
	 */
	public static HashMap<String, Integer> getCenterDimension(Frame frame) {

		HashMap<String, Integer> dimensionMap = new HashMap<String, Integer>();

		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

		int frameX = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
		int frameY = (int) ((dimension.getHeight() - frame.getHeight()) / 2);

		dimensionMap.put("frameX", frameX);
		dimensionMap.put("frameY", frameY);

		return dimensionMap;

	}

	public static Dimension getFrameSize(Frame frame) {

		return new Dimension();

	}
}
