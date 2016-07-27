/**
 * 
 */
package com.somendu.sample;

import java.awt.image.BufferedImage;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.QuadArray;
import javax.media.j3d.VirtualUniverse;
import javax.vecmath.Point3f;

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
		VirtualUniverse virtualUniverse = new VirtualUniverse();
		BranchGroup branchGroup = new BranchGroup();

		Point3f n = new Point3f(1.0f, 0.0f, 0.0f); // North east
		Point3f nw = new Point3f(0.0f, 0.0f, 1.0f); // south
		Point3f w = new Point3f(-1.0f, 0.0f, 0.0f); // west
		Point3f ws = new Point3f(0.0f, 0.0f, -1.0f); // north
		Point3f s = new Point3f(0.0f, 0.721f, 0.0f); // top
		Point3f se = new Point3f(-1.0f, 0.0f, 0.0f); // west
		Point3f e = new Point3f(0.0f, 0.0f, -1.0f); // north
		Point3f en = new Point3f(0.0f, 0.721f, 0.0f); // top

		QuadArray quadArray = new QuadArray(12, QuadArray.COORDINATES);

		quadArray.setCoordinate(0, n);

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
