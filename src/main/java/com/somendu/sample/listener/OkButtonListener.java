/**
 * 
 */
package com.somendu.sample.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.somendu.sample.ImageCaptureProcess;
import com.somendu.sample.utils.ScreenUtility;

import ij.ImagePlus;
import ij.gui.ImageCanvas;
import ij.gui.ImageWindow;

/**
 * cancel Button Listener
 * 
 * @author Somendu Maiti
 * @since Jul 27, 2016
 * 
 */
public class OkButtonListener implements MouseListener {

	private ImageCaptureProcess imageCaptureProcess;
	private ImageWindow imageWindow;

	public OkButtonListener(ImageCaptureProcess imageCaptureProcess, ImageWindow imageWindow) {

		this.imageCaptureProcess = imageCaptureProcess;
		this.imageWindow = imageWindow;

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		BufferedImage image = imageCaptureProcess.getNewImage();

		ImagePlus imagePlus = new ImagePlus("Final Image", image);

		ImageCanvas imageCanvas = new ImageCanvas(imagePlus);

		imageWindow = new ImageWindow(imagePlus, imageCanvas);

		imageCaptureProcess.getImageWindow().close();

		HashMap<String, Integer> frameLocationMap = ScreenUtility.getCenterCoordinates(imageWindow);
		imageWindow.setLocation(frameLocationMap.get("frameX"), frameLocationMap.get("frameY"));

		imageWindow.setVisible(true);

		// TODO Send it to the Image Universe
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
