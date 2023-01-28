package com.example.backend.core;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

public class ImageConverter {

    public static void main(String[] args) throws IOException {
        ImageConverter converter = new ImageConverter();
        File file = new File("C:\\projects\\X\\demo-app-20230128-LT\\backend\\src\\main\\resources\\img\\sample_large.jpg");
        FileInputStream fis = new FileInputStream(file);
        File newFile = new File("C:\\projects\\X\\demo-app-20230128-LT\\backend\\src\\main\\resources\\img\\sample_small.jpg");
        newFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(newFile);
        fos.write(Objects.requireNonNull(converter.widthAdjustment(fis.readAllBytes(), 1920, "jpg")));
        fos.close();
    }

    /**
     * Adjust image width.
     *
     * @param srcBytes Image binary before conversion.
     * @param newWidth Width after conversion.
     * @param fileType file extension.
     * @return Image binary after conversion.
     */
    public byte[] widthAdjustment(byte[] srcBytes, int newWidth, String fileType) throws IOException {
        return convert(srcBytes, newWidth, 0, fileType);
    }

    /**
     * Adjust image height.
     *
     * @param srcBytes  Image binary before conversion.
     * @param newHeight Height after conversion.
     * @param fileType  file extension.
     * @return Image binary after conversion.
     */
    public byte[] heightAdjustment(byte[] srcBytes, int newHeight, String fileType) throws IOException {
        return convert(srcBytes, 0, newHeight, fileType);
    }

    private byte[] convert(byte[] srcBytes, int newWidth, int newHeight, String fileType) throws IOException {
        try (ByteArrayInputStream in = new ByteArrayInputStream(srcBytes);
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            BufferedImage srcBuf = ImageIO.read(in);
            int w = srcBuf.getWidth(), h = srcBuf.getHeight(),
                    newW = newWidth > 0 ? newWidth : newHeight * w / h,
                    newH = newHeight > 0 ? newHeight : newWidth * h / w;
            AffineTransformOp op = new AffineTransformOp(
                    AffineTransform.getScaleInstance((double) newW / w, (double) newH / h),
                    AffineTransformOp.TYPE_BILINEAR);
            BufferedImage dstBuf = new BufferedImage(newW, newH, srcBuf.getType());
            op.filter(srcBuf, dstBuf);
            ImageIO.write(dstBuf, fileType, out);
            return out.toByteArray();
        }
    }
}
