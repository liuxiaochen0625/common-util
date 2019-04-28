/**
 * Reus
 * Copyright (C), 2011 - 2017, Reus.
 */
package com.reus;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * @author reus
 * @version $Id: CaptureScreen.java, v 0.1 2017-07-27 reus Exp $
 * 
 * java 截屏工具
 */
public class CaptureScreen {

    public static void captureScreen(String fileName) throws Exception {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(fileName));

    }

    public static void main(String[] args) {
        try {
            captureScreen("Test22.png");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}