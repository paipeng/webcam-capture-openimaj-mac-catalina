package com.s2icode.webcapturetester;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.ds.buildin.natives.DeviceList;
import com.github.sarxos.webcam.ds.buildin.natives.OpenIMAJGrabber;
import com.github.sarxos.webcam.ds.openimaj.OpenImajDriver;
import org.apache.log4j.Logger;
import org.bridj.Pointer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class WebCaptureTester {
    private static Logger logger = Logger.getLogger(WebCaptureTester.class);

    static {
        // set OpenIMAJ driver
        Webcam.setDriver(new OpenImajDriver());
    }

    private static void testWebcam() {
        OpenIMAJGrabber grabber = new OpenIMAJGrabber();
        Pointer<DeviceList> devices = grabber.getVideoDevices();
        logger.info("get list of devices");
        DeviceList list = grabber.getVideoDevices().get();
        logger.info("list devices: " + list.getNumDevices());
        System.out.println("list devices: " + list.getNumDevices());
        System.out.println("device name: " + list.getDevice(0).get().getNameStr() );
        System.out.println("device id: " + list.getDevice(0).get().getIdentifierStr() );

        // get default camera
        Webcam webcam = Webcam.getWebcams().get(1);

        // set VGA resolution and open
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        Dimension[] a = webcam.getCustomViewSizes();

        a = webcam.getViewSizes();
        //webcam.setViewSize(a[4].getSize());

        webcam.open();

        // get image
        BufferedImage image = webcam.getImage();

        // close camera
        webcam.close();

        // save image to file
        try {
            ImageIO.write(image, "PNG", new File("bubu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testWebcam2() throws Throwable {

        // get default camera
        Webcam webcam = Webcam.getDefault();

        // set VGA resolution and open
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.open();

        // get image
        BufferedImage image = webcam.getImage();

        // close camera
        webcam.close();

        // save image to file
        ImageIO.write(image, "PNG", new File("bubu.png"));
    }

    public static void main(String[] args) throws Throwable {
        testWebcam();
        //testWebcam2();
    }
}
