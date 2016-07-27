/**
 * 
 */
package com.somendu.sample;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import ij.ImagePlus;
import ij.gui.ImageCanvas;
import ij.gui.ImageWindow;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 * @since Jul 25, 2016
 * 
 */
public class ImageCaptureWindow {

	private ImageWindow imageWindow = new ImageWindow("Test");
	private JButton okButton = new JButton();
	private JButton cancelButton = new JButton();

	private JPanel jPanel = new JPanel();

	private ImagePlus imagePlus;
	private ImageCanvas imageCanvas;

	private BufferedImage image;

	public ImageCaptureWindow() {

	}

	/**
	 * This method will show alert on the image window
	 */
	public void showImageWindowAlert() {

		jPanel.add(okButton);
		jPanel.add(cancelButton);

		okButton.setText("Ok");
		cancelButton.setText("Cancel");

		okButton.setVisible(true);
		cancelButton.setVisible(true);

		imageWindow.add(jPanel);
		jPanel.setVisible(true);
		Dimension dimension = imageWindow.getCanvas().getSize();
		imageWindow.setSize((int) dimension.getWidth() + 50, (int) (dimension.getHeight() + 150));

		imageWindow.setVisible(true);
		imageWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

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
