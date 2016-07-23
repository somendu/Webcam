/**
 * 
 */
package com.somendu.sample;

import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;

/**
 * <Description>
 * 
 * @author Somendu Maiti<smaiti@scan-it.com.sg>
 * @since Jul 22, 2016
 * 
 */
public class WebCamImage {

	public WebCamImage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Showing webcam
	 * 
	 * @return
	 */
	public BufferedImage takePicture() {

		Webcam webcam;
		webcam = Webcam.getDefault();

		webcam.open();

		BufferedImage image = webcam.getImage();

		// Incorrect dimension [1280x720] possible ones are [176x144] [320x240]
		// [640x480]
		// webcam.setViewSize(WebcamResolution.HD720.getSize());

		// TODO - Show Prompt before taking picture

		// image = webcam.getImage();

		return image;
	}
}
