/**
 * 
 */
package com.somendu.sample;

import java.awt.image.BufferedImage;

import javax.media.j3d.BranchGroup;
import javax.vecmath.Point3f;
import javax.vecmath.Point4f;

import com.sun.j3d.utils.universe.SimpleUniverse;

/**
 * @author Admin_8_1
 *
 */
public class ImageUniverse {

	private BufferedImage bufferedImage;

	public ImageUniverse() {
		// TODO Auto-generated constructor stub
	}

	public void showImage() {

		SimpleUniverse simpleUniverse = new SimpleUniverse();
		BranchGroup branchGroup = new BranchGroup();

		Point4f ne = new Point4f(1.0f, 0.0f, 0.0f, 1.0f); // east
		// Point4f ne = new Point4f(1.0f, 0.0f, 0.0f, 1.0f); // east
		Point3f s = new Point3f(0.0f, 0.0f, 1.0f); // south
		Point3f w = new Point3f(-1.0f, 0.0f, 0.0f); // west
		Point3f n = new Point3f(0.0f, 0.0f, -1.0f); // north
		Point3f t = new Point3f(0.0f, 0.721f, 0.0f); // top

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

}
