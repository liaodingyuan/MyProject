package basecc.imageUtils;

import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;

/**
 * Created by liaody on 2017/4/15.
 */
public class SysScreenshot {
    public SysScreenshot(){

    }

    /**
     * 指定屏幕区域截图，保存到指定目录
     * @param x
     * @param y
     * @param width
     * @param height
     * @param savePath - 文件保存路径
     * @param fileName - 文件保存名称
     * @param format - 文件格式
     */
    public void screenShotAsFile(int x, int y, int width, int height, String savePath, String fileName, String format) {
        try {
            Robot robot = new Robot();
            BufferedImage bfImage = robot.createScreenCapture(new Rectangle(x, y, width, height));
            File path = new File(savePath);
            File file = new File(path, fileName+ "." + format);
            ImageIO.write(bfImage, format, file);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * BufferedImage图片剪裁
     * @param srcBfImg - 被剪裁的BufferedImage
     * @param x - 左上角剪裁点X坐标
     * @param y - 左上角剪裁点Y坐标
     * @param width - 剪裁出的图片的宽度
     * @param height - 剪裁出的图片的高度
     * @return 剪裁得到的BufferedImage
     */
    public BufferedImage cutBufferedImage(BufferedImage srcBfImg, int x, int y, int width, int height) {
        BufferedImage cutedImage = null;
        CropImageFilter cropFilter = new CropImageFilter(x, y, width, height);
        Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(srcBfImg.getSource(), cropFilter));
        cutedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = cutedImage.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        return cutedImage;
    }

    public void SysCapture(String filePath,String fileName){

        if(StringUtils.isEmpty(filePath)|| StringUtils.isEmpty(fileName)){
            throw new IllegalArgumentException("保存截图目录或者截图后需要保存的截图名称不能够为空");
        }
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

//        Toolkit.getDefaultToolkit().

        try {
            Robot robot = new Robot();
            robot.createScreenCapture(new Rectangle(0,0,(int)screen.getWidth(),(int)screen.getHeight()));
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
