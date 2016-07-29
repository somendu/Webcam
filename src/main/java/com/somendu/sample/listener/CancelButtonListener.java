/**
 * 
 */
package com.somendu.sample.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.somendu.sample.ImageCaptureProcess;
import com.somendu.sample.ImageCaptureRectangle;
import com.somendu.sample.ImageSaver;
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
public class CancelButtonListener implements MouseListener {

	private ImageCaptureProcess imageCaptureProcess;
	private ImageWindow imageWindow;

	public CancelButtonListener(ImageCaptureProcess imageCaptureProcess, ImageWindow imageWindow) {

		this.imageCaptureProcess = imageCaptureProcess;
		this.imageWindow = imageWindow;

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		imageWindow.close();

		BufferedImage image = imageCaptureProcess.getOldImage();

		ImagePlus imagePlus = new ImagePlus("Main Image", image);

		ImageCanvas imageCanvas = new ImageCanvas(imagePlus);

		imageWindow = new ImageWindow(imagePlus, imageCanvas);

		imageWindow.setVisible(true);

		HashMap<String, Integer> frameLocationMap = ScreenUtility.getCenterCoordinates(imageWindow);
		imageWindow.setLocation(frameLocationMap.get("frameX"), frameLocationMap.get("frameY"));

		ImageCaptureRectangle imageCaptureRectangle = new ImageCaptureRectangle();

		imageCaptureRectangle.setImagePlus(imagePlus);
		imageCaptureRectangle.setImageCanvas(imageCanvas);

		ImageSaver imageSaver = new ImageSaver();

		imageSaver.setImage(image);

		ImageCropListener mouseListener = new ImageCropListener(imageCaptureRectangle, imageSaver);

		imageCanvas.addMouseListener(mouseListener);

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
