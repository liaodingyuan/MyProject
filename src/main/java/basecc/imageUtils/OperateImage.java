package basecc.imageUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * Created by liaody on 2017/4/7.
 */
public class OperateImage {
    /**
     * default constructor
     */
    public OperateImage() {

    }

    /**
     * <p>对图片进行剪切，并把剪切后的图片保存到新的路径</p>
     * @param srcPath 读取源图片路径
     * @param desPath 写入的图片路径
     * @param xStart 剪切起始点x轴坐标
     * @param yStart 剪切起始点y轴坐标
     * @param width 剪切的宽度
     * @param height 剪切的高度
     * @param readImageFormat 读取图片的格式
     * @param writeImageFromat 写入图片的格式
     */
    public void cropImage(String srcPath, String desPath, int xStart, int yStart, int width, int height, String readImageFormat, String writeImageFromat) throws FileNotFoundException {

        FileInputStream fis = null;
        ImageInputStream iis = null;

        fis = new FileInputStream(new File(srcPath));
        Iterator it =  ImageIO.getImageReadersByFormatName(readImageFormat);
    }

    public static void main(String[] args) {

    }
}
