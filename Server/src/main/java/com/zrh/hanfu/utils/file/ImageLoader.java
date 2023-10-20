package com.zrh.hanfu.utils.file;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

public class ImageLoader {

    public static byte[] getImageByte(String filepath) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(filepath));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage,"png",byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

}
