/**
 * 
 */
package com.somendu.sample.listener;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.somendu.sample.WebCamImage;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 * @since Jul 22, 2016
 * 
 */
public class ImageWebcamListener implements WebcamListener {

	private WebCamImage webcamImage;

	private Webcam webCam;

	public ImageWebcamListener(WebCamImage webcamImage, Webcam webCam) {
		this.webcamImage = webcamImage;
		this.webCam = webCam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.sarxos.webcam.WebcamListener#webcamClosed(com.github.sarxos.
	 * webcam.WebcamEvent)
	 */
	public void webcamClosed(WebcamEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.sarxos.webcam.WebcamListener#webcamDisposed(com.github.sarxos.
	 * webcam.WebcamEvent)
	 */
	public void webcamDisposed(WebcamEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.sarxos.webcam.WebcamListener#webcamImageObtained(com.github.
	 * sarxos.webcam.WebcamEvent)
	 */
	public void webcamImageObtained(WebcamEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.github.sarxos.webcam.WebcamListener#webcamOpen(com.github.sarxos.
	 * webcam.WebcamEvent)
	 */
	public void webcamOpen(WebcamEvent arg0) {
		System.out.println("Open");

	}

}
