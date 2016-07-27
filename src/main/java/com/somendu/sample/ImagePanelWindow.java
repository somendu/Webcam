/**
 * 
 */
package com.somendu.sample;

import java.awt.Frame;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import ij.ImagePlus;
import ij.gui.ImageCanvas;
import ij.gui.ImageLayout;

/**
 * <Description>
 * 
 * @author Somendu Maiti
 * @since Jul 25, 2016
 * 
 */
public class ImagePanelWindow extends Frame
		implements FocusListener, WindowListener, WindowStateListener, MouseWheelListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImagePanelWindow(ImagePlus imagePlus, ImageCanvas imageCanvas) {

		setLayout(new ImageLayout(imageCanvas));
		add(imageCanvas);
		addFocusListener(this);
		setFocusTraversalKeysEnabled(false);

		setFocusTraversalKeysEnabled(false);

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
