package com.github.jameshiegel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * This program displays three simple shapes and then transforms them via translate, rotate and scale.
 * 
 * Code is based upon the provided CMSC405P1Template.java and AnimationStarter.java.
 */

public class ProjectOne extends JPanel {
	private int frameNumber;
	private long elapsedTimeMillis;
	private float pixelSize;

	static int translateX = 0;
	static int translateY = 0;
	static double rotation = 0.0;
	static double scaleX = 1.0;
	static double scaleY = 1.0;

	// loads images from ImageShapes class
	ImageShapes myImages = new ImageShapes();
	BufferedImage diamondImage = myImages.getImage(ImageShapes.Diamond);
	BufferedImage squareImage = myImages.getImage(ImageShapes.Square);
	BufferedImage circleImage = myImages.getImage(ImageShapes.Circle);

	public static void main(String[] args) {
		// creates main window on which shapes will be drawn and animated
		JFrame window;
		window = new JFrame("CMSC405 Project One");
		final ProjectOne panel = new ProjectOne();
		window.setContentPane(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setResizable(false);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation((screen.width - window.getWidth()) / 2, (screen.height - window.getHeight()) / 2);

		// sets up a timer for frame animation
		Timer animationTimer;
		final long startTime = System.currentTimeMillis();

		animationTimer = new Timer(1600, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (panel.frameNumber > 6) {
					panel.frameNumber = 0;
				} else {
					panel.frameNumber++;
				}
				panel.elapsedTimeMillis = System.currentTimeMillis() - startTime;
				panel.repaint();
			}
		});

		// displays window
		window.setVisible(true);

		// starts animation
		animationTimer.start();
	}

	/**
	 * This constructor sets the size of the display window
	 */
	public ProjectOne() {
		setPreferredSize(new Dimension(800, 600));
	}

	/**
	 * The paintComponent method draws the images onto the screen and animated them.
	 * Modified from CMSC405P1Template.java
	 */
	protected void paintComponent(Graphics g) {
		// creates a 2D graphics object
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setPaint(Color.WHITE);
		g2.fillRect(0, 0, getWidth(), getHeight());

		applyWindowToViewportTransformation(g2, -75, 75, -75, 75, true);

		AffineTransform savedTransform = g2.getTransform();
		
		System.out.printf("\nFrame is " + frameNumber);
		
		switch (frameNumber) {
		case 1: // First frame is unmodified.
			System.out.print(", no change.");
			translateX = 0;
			translateY = 0;
			scaleX = 1.0;
			scaleY = 1.0;
			rotation = 0;
			break;
		case 2: // Second frame translates each image by (-5 x).
			System.out.print(", translate -5x.");
			translateX = -5;
			break;
		case 3: // Third frame translates each image by (+7 y).
			System.out.print(", translate +7y.");
			translateX = -5;
			translateY = 7;
			break;
		case 4: // Fourth frame rotates each image by 45 degrees Counter
			System.out.print(", rotate 45 degrees counter clockwise.");
			translateX = -5;
			translateY = 7;
			rotation = 45 * Math.PI / 180.0;
			break;
		case 5: // Fifth frame rotates each image by 90 degrees
			System.out.print(", rotate 90 degrees clockwise.");
			translateX = -5;
			translateY = 7;
			rotation = 45 * Math.PI / 180.0;
			rotation = -2 * (45 * Math.PI / 180.0);
			break;
		case 6: // Sixth frame scales each image x by 2
			System.out.print(", scale x times 2.");
			translateX = -5;
			translateY = 7;
			rotation = 45 * Math.PI / 180.0;
			rotation = -2 * (45 * Math.PI / 180.0);
			scaleX = 2;
			break;
		case 7: // Seventh frame scales each image y by 0.5
			System.out.print(", scale y times 0.5.");
			translateX = -5;
			translateY = 7;
			rotation = 45 * Math.PI / 180.0;
			rotation = -2 * (45 * Math.PI / 180.0);
			scaleX = 2;
			scaleY = 0.5;
			break;
		default:
			break;
		}
		
		// diamond shape
		g2.translate(translateX, translateY); // Move image.
		// To offset translate again
		g2.translate(0, 0);
		g2.rotate(rotation); // Rotate image.
		g2.scale(scaleX, scaleY); // Scale image.
		g2.drawImage(diamondImage, 0, 0, this); // Draw image.
		g2.setTransform(savedTransform);
		
		// square shape
		g2.translate(translateX, translateY); // Move image.
		// To offset translate again
		g2.translate(-30, 30);
		g2.rotate(rotation); // Rotate image.
		g2.scale(scaleX, scaleY); // Scale image.
		g2.drawImage(squareImage, 0, 0, this); // Draw image.
		g2.setTransform(savedTransform);
		
		// circle shape
		g2.translate(translateX, translateY); // Move image.
		// To offset translate again
		g2.translate(30, -30);
		g2.rotate(rotation); // Rotate image.
		g2.scale(scaleX, scaleY); // Scale image.
		g2.drawImage(circleImage, 0, 0, this); // Draw image.
		g2.setTransform(savedTransform);
	}
	
	/**
	 * Applies a coordinate transform to a Graphics2D graphics context. 
	 * Taken from AnimationStarter.java
	 */
	private void applyWindowToViewportTransformation(Graphics2D g2, double left, double right, double bottom,
			double top, boolean preserveAspect) {
		int width = getWidth(); // The width of this drawing area, in pixels.
		int height = getHeight(); // The height of this drawing area, in pixels.
		if (preserveAspect) {
			// Adjust the limits to match the aspect ratio of the drawing area.
			double displayAspect = Math.abs((double) height / width);
			double requestedAspect = Math.abs((bottom - top) / (right - left));
			if (displayAspect > requestedAspect) {
				// Expand the viewport vertically.
				double excess = (bottom - top) * (displayAspect / requestedAspect - 1);
				bottom += excess / 2;
				top -= excess / 2;
			} else if (displayAspect < requestedAspect) {
				// Expand the viewport vertically.
				double excess = (right - left) * (requestedAspect / displayAspect - 1);
				right += excess / 2;
				left -= excess / 2;
			}
		}
		g2.scale(width / (right - left), height / (bottom - top));
		g2.translate(-left, -top);
		double pixelWidth = Math.abs((right - left) / width);
		double pixelHeight = Math.abs((bottom - top) / height);
		pixelSize = (float) Math.max(pixelWidth, pixelHeight);
	}
}
